package bookstore.Receipt;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// This class writes each receipt to src/Report/sale.csv.
// It keeps all previous receipt rows and updates TOTAL_REVENUE at the bottom.
public class ReceiptCsvWriter {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Appends one receipt row and recalculates the running total revenue.
    public static void appendReceipt(String bookTitle, String bookAuthor, double bookPrice, double quantity, double totalPrice) {
        Path salesCsv = resolveSalesCsvPath();

        try {
            Files.createDirectories(salesCsv.getParent());

            List<String> existingLines = Files.exists(salesCsv)
                    ? Files.readAllLines(salesCsv, StandardCharsets.UTF_8)
                    : new ArrayList<>();

            List<String> receiptRows = new ArrayList<>();
            double runningRevenue = 0.0;

            for (String line : existingLines) {
                if (line == null || line.trim().isEmpty()) {
                    continue;
                }
                if (line.startsWith("timestamp,bookTitle,bookAuthor,bookPrice,quantity,totalPrice")) {
                    continue;
                }
                if (line.startsWith("TOTAL_REVENUE,")) {
                    continue;
                }

                receiptRows.add(line);
                String[] columns = line.split(",", -1);
                if (columns.length >= 6) {
                    try {
                        runningRevenue += Double.parseDouble(columns[5]);
                    } catch (NumberFormatException ignored) {
                        // Skip malformed historic row amount and continue processing.
                    }
                }
            }

            String now = LocalDateTime.now().format(DATE_TIME_FORMATTER);
            String newReceiptRow = escapeCsv(now) + ","
                    + escapeCsv(bookTitle) + ","
                    + escapeCsv(bookAuthor) + ","
                    + formatMoney(bookPrice) + ","
                    + formatQuantity(quantity) + ","
                    + formatMoney(totalPrice);

            receiptRows.add(newReceiptRow);
            runningRevenue += totalPrice;

            List<String> outputLines = new ArrayList<>();
            outputLines.add("timestamp,bookTitle,bookAuthor,bookPrice,quantity,totalPrice");
            outputLines.addAll(receiptRows);
            outputLines.add("TOTAL_REVENUE," + formatMoney(runningRevenue));

            Files.write(salesCsv, outputLines, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.out.println("Could not write sales report CSV: " + ex.getMessage());
        }
    }

    // Always targets src/Report/sale.csv (or demo/src/Report/sale.csv based on current working dir).
    private static Path resolveSalesCsvPath() {
        Path srcRoot = Paths.get("src");
        Path reportInSrcDir;

        if (Files.exists(srcRoot)) {
            reportInSrcDir = srcRoot.resolve("Report");
        } else {
            reportInSrcDir = Paths.get("demo", "src", "Report");
        }

        return reportInSrcDir.resolve("sale.csv");
    }

    // Formats currency-like values to 2 decimal places for CSV consistency.
    private static String formatMoney(double value) {
        return String.format("%.2f", value);
    }

    // Prints whole numbers without .0, otherwise keeps decimal form.
    private static String formatQuantity(double value) {
        if (value == Math.floor(value)) {
            return String.valueOf((int) value);
        }
        return String.valueOf(value);
    }

    // Escapes CSV text safely by doubling internal quotes and wrapping in quotes.
    private static String escapeCsv(String value) {
        String escaped = value.replace("\"", "\"\"");
        return "\"" + escaped + "\"";
    }
}

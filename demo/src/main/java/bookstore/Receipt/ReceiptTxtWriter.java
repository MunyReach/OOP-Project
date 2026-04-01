package bookstore.Receipt;

import bookstore.Book;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

// Appends a human-readable receipt block into src/Report/receipt.txt
public class ReceiptTxtWriter {
    private static final double TAX_RATE = 0.07;
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void appendReceiptBlock(String bookTitle, String bookAuthor, double bookPrice, double quantity) {
        double subTotal = bookPrice * quantity;
        double tax = subTotal * TAX_RATE;
        double total = subTotal + tax;

        StringBuilder content = new StringBuilder();
        content.append("OOP Bookstore\n");
        content.append("Date, Time: ").append(LocalDateTime.now().format(DATE_TIME_FORMATTER)).append("\n");
        content.append("Payment method: N/A\n\n");

        content.append("----------------------------------------\n");
        content.append("Customer Phone Number: N/A\n");
        content.append("Address: Walk-in purchase\n\n");

        content.append("----------------------------------------\n");
        content.append("Book Name | Amount | Price per Unit | Total per Book\n");
        content.append(bookTitle)
                .append(" by ").append(bookAuthor)
                .append(" | ").append(formatQuantity(quantity))
                .append(" | $").append(formatMoney(bookPrice))
                .append(" | $").append(formatMoney(subTotal)).append("\n\n");

        content.append("----------------------------------------\n");
        content.append("Tax (always 7%): $").append(formatMoney(tax)).append("\n");
        content.append("Total: $").append(formatMoney(total)).append("\n");
        content.append("----------------------------------------\n");
        content.append("Cashier Name: N/A\n\n");
        content.append("Thank you for your purchase. Please come again next time. With love, OOP Bookstore:3\n");
        content.append("----------------------------------------\n\n");

        Path receiptFile = resolveReceiptTxtPath();

        try {
            Files.createDirectories(receiptFile.getParent());
            Files.write(
                    receiptFile,
                    content.toString().getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException ex) {
            System.out.println("Could not write TXT receipt: " + ex.getMessage());
        }
    }

    public static void appendOrderReceiptBlock(List<Book> books, List<Integer> quantities) {
        StringBuilder lines = new StringBuilder();
        double subTotal = 0.0;

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            int qty = quantities.get(i);
            double lineTotal = book.getPrice() * qty;
            subTotal += lineTotal;

            lines.append(book.getTitle())
                    .append(" by ").append(book.getAuthor())
                    .append(" | ").append(qty)
                    .append(" | $").append(formatMoney(book.getPrice()))
                    .append(" | $").append(formatMoney(lineTotal))
                    .append("\n");
        }

        double tax = subTotal * TAX_RATE;
        double total = subTotal + tax;

        StringBuilder content = new StringBuilder();
        content.append("OOP Bookstore\n");
        content.append("Date, Time: ").append(LocalDateTime.now().format(DATE_TIME_FORMATTER)).append("\n");
        content.append("Payment method: N/A\n\n");
        content.append("----------------------------------------\n");
        content.append("Customer Phone Number: N/A\n");
        content.append("Address: Walk-in purchase\n\n");
        content.append("----------------------------------------\n");
        content.append("Book Name | Amount | Price per Unit | Total per Book\n");
        content.append(lines).append("\n");
        content.append("----------------------------------------\n");
        content.append("Tax (always 7%): $").append(formatMoney(tax)).append("\n");
        content.append("Total: $").append(formatMoney(total)).append("\n");
        content.append("----------------------------------------\n");
        content.append("Cashier Name: N/A\n\n");
        content.append("Thank you for your purchase. Please come again next time. With love, OOP Bookstore:3\n");
        content.append("----------------------------------------\n\n");

        Path receiptFile = resolveReceiptTxtPath();

        try {
            Files.createDirectories(receiptFile.getParent());
            Files.write(
                    receiptFile,
                    content.toString().getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException ex) {
            System.out.println("Could not write TXT receipt: " + ex.getMessage());
        }
    }

    private static Path resolveReceiptTxtPath() {
        Path srcRoot = Paths.get("src");
        if (Files.exists(srcRoot)) {
            return srcRoot.resolve("Report").resolve("receipt.txt");
        }
        return Paths.get("demo", "src", "Report", "receipt.txt");
    }

    private static String formatMoney(double value) {
        return String.format("%.2f", value);
    }

    private static String formatQuantity(double value) {
        if (value == Math.floor(value)) {
            return String.valueOf((int) value);
        }
        return String.valueOf(value);
    }
}

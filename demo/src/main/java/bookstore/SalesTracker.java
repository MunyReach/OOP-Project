package bookstore;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SalesTracker {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static class SalesData {
        public int orderCount;
        public double netValue;
        public int walkInCount;
        public int deliveryCount;
        public String dateOverview;

        public SalesData(int orderCount, double netValue, int walkInCount, int deliveryCount, String dateOverview) {
            this.orderCount = orderCount;
            this.netValue = netValue;
            this.walkInCount = walkInCount;
            this.deliveryCount = deliveryCount;
            this.dateOverview = dateOverview;
        }
    }

    public static SalesData getSalesForPeriod(String period) {
        Path salesCsv = resolveSalesCsvPath();
        LocalDateTime now = LocalDateTime.now();
        LocalDate today = now.toLocalDate();

        int orderCount = 0;
        double netValue = 0.0;
        int walkInCount = 0;
        int deliveryCount = 0;
        LocalDateTime latestOrderTime = null;

        try {
            if (!Files.exists(salesCsv)) {
                return new SalesData(0, 0.0, 0, 0, now.format(DateTimeFormatter.ofPattern("M/d/yyyy h:mma")));
            }

            List<String> lines = Files.readAllLines(salesCsv);
            for (String line : lines) {
                if (line.trim().isEmpty() || line.startsWith("timestamp") || line.startsWith("TOTAL_REVENUE")) {
                    continue;
                }

                String[] columns = line.split(",", -1);
                if (columns.length < 6) continue;

                try {
                    LocalDateTime orderTime = LocalDateTime.parse(columns[0].replace("\"", ""), DATE_TIME_FORMATTER);
                    LocalDate orderDate = orderTime.toLocalDate();
                    double totalPrice = Double.parseDouble(columns[5]);
                    boolean isWalkIn = columns.length >= 8 ? "true".equals(columns[7].replace("\"", "")) : true; // default to walk-in for old data

                    boolean include = false;
                    if ("today".equals(period)) {
                        include = orderDate.equals(today);
                    } else if ("week".equals(period)) {
                        LocalDate weekStart = today.minusDays(today.getDayOfWeek().getValue() - 1);
                        include = !orderDate.isBefore(weekStart) && !orderDate.isAfter(today);
                    } else if ("month".equals(period)) {
                        include = orderDate.getYear() == today.getYear() && orderDate.getMonth() == today.getMonth();
                    }

                    if (include) {
                        orderCount++;
                        netValue += totalPrice;
                        if (isWalkIn) {
                            walkInCount++;
                        } else {
                            deliveryCount++;
                        }
                        if (latestOrderTime == null || orderTime.isAfter(latestOrderTime)) {
                            latestOrderTime = orderTime;
                        }
                    }
                } catch (Exception e) {
                    // Skip malformed lines
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read sales data: " + e.getMessage());
        }

        String dateOverview = (latestOrderTime != null) ? latestOrderTime.format(DateTimeFormatter.ofPattern("M/d/yyyy h:mma")) : now.format(DateTimeFormatter.ofPattern("M/d/yyyy h:mma"));
        return new SalesData(orderCount, netValue, walkInCount, deliveryCount, dateOverview);
    }

    private static Path resolveSalesCsvPath() {
        return Paths.get("demo", "src", "Report", "sale.csv");
    }
}
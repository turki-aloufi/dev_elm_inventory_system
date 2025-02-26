class StockPredictor {
    public static int predictStockOutDays(Product product, double averageDailySales) {
        if (averageDailySales <= 0) {
            throw new IllegalArgumentException("Average daily sales must be greater than zero.");
        }
        return (int) Math.ceil(product.getStockLevel() / averageDailySales);
    }

    public static String suggestRestocking(Product product, double averageDailySales) {
        int daysUntilStockOut = predictStockOutDays(product, averageDailySales);
        if (daysUntilStockOut <= 3) {
            return "Urgent: Restock immediately!";
        } else if (daysUntilStockOut <= 7) {
            return "Moderate: Consider restocking soon.";
        } else {
            return "Stock is sufficient for now.";
        }
    }
}
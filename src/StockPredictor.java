class StockPredictor {
    public static int predictStockOutDays(Product product, double averageDailySales) {
        if (averageDailySales <= 0) {
            throw new IllegalArgumentException("Average daily sales must be greater than zero.");
        }
        return (int) Math.ceil(product.getStockLevel() / averageDailySales);
    }

    public static String suggestRestocking(Product product, double averageDailySales) {
        int daysUntilStockOut = predictStockOutDays(product, averageDailySales);
        if (daysUntilStockOut <= 5) {
            return "Urgent restocking needed immediately!";
        } else if (daysUntilStockOut <= 10) {
            return "Consider placing a restocking order soon.";
        } else {
            return "Stock levels are sufficient for now.";
        }
    }
}

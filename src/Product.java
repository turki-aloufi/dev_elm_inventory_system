import java.util.UUID;

// Class representing a product with stock management
class Product {
    private UUID productId;
    private String name;
    private double price;
    private int stockLevel;
    private int reorderThreshold;

    public Product(String name, double price, int stockLevel, int reorderThreshold) {
        this.productId = UUID.randomUUID(); // Generate unique product ID
        this.name = name;
        this.price = price;
        this.stockLevel = stockLevel;
        this.reorderThreshold = reorderThreshold;
    }

    public UUID getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStockLevel() { return stockLevel; }
    public int getReorderThreshold() { return reorderThreshold; }

    // Synchronized method to safely reduce stock level
    public synchronized void reduceStock(int quantity) {
        if (quantity > stockLevel) {
            throw new IllegalArgumentException("Not enough stock available.");
        }
        stockLevel -= quantity;
    }
}

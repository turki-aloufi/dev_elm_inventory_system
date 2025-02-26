import java.util.UUID;

public class Product {
     private UUID productId;
     private String name;
     private double price;
    private int stockLevel;
    private int reorderThreshold;
    Product(String name, double price, int stockLevel, int reorderThreshold) {
        this.productId = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.stockLevel = stockLevel;
        this.reorderThreshold = reorderThreshold;
    }
    public UUID getProductId() {return productId;}
    public String getName() {return name;}
    public double getPrice() {return price;}
    public int getStockLevel() {return stockLevel;}
    public int getReorderThreshold() {return reorderThreshold;}

    public void setProductId(UUID productId) {this.productId = productId;}
    public void setName(String name) {this.name = name;}
    public void setPrice(double price) {this.price = price;}
    public void setStockLevel(int stockLevel) {this.stockLevel = stockLevel;}
    public void setReorderThreshold(int reorderThreshold) {this.reorderThreshold = reorderThreshold;}


    public void reduceStock(int quantity) {
        if (quantity > stockLevel) {
            throw new IllegalArgumentException("Not enough stxock available.");
        }
        stockLevel -= quantity;
    }

    public void restock(int quantity) {
        stockLevel += quantity;
    }
}

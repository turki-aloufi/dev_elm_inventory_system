import java.util.UUID;
// Enum representing different order statuses
enum OrderStatus {
    PENDING, SHIPPED, DELIVERED
}

// Class representing an order
class Order {
    private UUID orderId;
    private String customerName;
    private UUID productId;
    private int quantity;
    private OrderStatus status;

    public Order(String customerName, UUID productId, int quantity) {
        this.orderId = UUID.randomUUID(); // Generate unique order ID
        this.customerName = customerName;
        this.productId = productId;
        this.quantity = quantity;
        this.status = OrderStatus.PENDING;
    }

    public UUID getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public UUID getProductId() { return productId; }
    public int getQuantity() { return quantity; }

    // Synchronized method to safely update order status
    public synchronized OrderStatus getStatus() { return status; }
    public synchronized void updateStatus(OrderStatus newStatus) {
        this.status = newStatus;
    }
}

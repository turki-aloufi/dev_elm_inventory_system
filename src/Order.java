import java.util.UUID;

enum OrderStatus {
    PENDING,
    SHIPPED,
    DELIVERED
}

class Order {
    private final UUID orderId;
    private final String customerName;
    private final UUID productId;
    private final int quantity;
    private OrderStatus orderStatus;

    public Order(String customerName, UUID productId, int quantity) {
        this.orderId = UUID.randomUUID();
        this.customerName = customerName;
        this.productId = productId;
        this.quantity = quantity;
        this.orderStatus = OrderStatus.PENDING;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public UUID getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void updateOrderStatus(OrderStatus status) {
        this.orderStatus = status;
    }
}


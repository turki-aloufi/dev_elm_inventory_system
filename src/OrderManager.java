import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class OrderManager {
     ExecutorService executorService = Executors.newFixedThreadPool(5);
     List<Order> orders = new ArrayList<>();

    public void processOrder(Order order, Product product) {

        product.reduceStock(order.getQuantity());
        orders.add(order);
        System.out.println("Processing order: " + order.getOrderId());
        executorService.submit(() -> updateOrderStatus(order));

        product.reduceStock(order.getQuantity());
        orders.add(order);
        System.out.println("Processing order: " + order.getOrderId());
        executorService.submit(() -> updateOrderStatus(order));
    }

    private void updateOrderStatus(Order order) {
        try {
            Thread.sleep(2000);
            order.updateOrderStatus(OrderStatus.SHIPPED);
            System.out.println("Order " + order.getOrderId() + " has been shipped.");

            Thread.sleep(2000);
            order.updateOrderStatus(OrderStatus.DELIVERED);
            System.out.println("Order " + order.getOrderId() + " has been delivered.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
        executorService.shutdown();
    }
}

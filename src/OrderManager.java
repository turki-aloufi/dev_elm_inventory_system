import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Class responsible for managing orders
class OrderManager {
    private ExecutorService executorService = Executors.newFixedThreadPool(3);
    private static final String ORDER_FILE = "orders.txt";

    // Method to process an order asynchronously
    public void processOrder(Order order, Product product) {
        executorService.submit(() -> {
            try {
                System.out.println("Processing order: " + order.getOrderId());
                product.reduceStock(order.getQuantity());
                Thread.sleep(2000); // Simulating processing delay
                order.updateStatus(OrderStatus.SHIPPED);
                System.out.println("Order " + order.getOrderId() + " status updated to SHIPPED");
                Thread.sleep(2000);
                order.updateStatus(OrderStatus.DELIVERED);
                System.out.println("Order " + order.getOrderId() + " status updated to DELIVERED");
                saveOrder(order);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    // Save order details to a file
    private synchronized void saveOrder(Order order) {
        try (FileWriter writer = new FileWriter(ORDER_FILE, true)) {
            writer.write(order.getOrderId() + "," + order.getCustomerName() + "," + order.getProductId() + "," + order.getQuantity() + "," + order.getStatus() + "\n");
        } catch (IOException e) {
            System.err.println("Error saving order: " + e.getMessage());
        }
    }

    // Load orders from a file
    public void loadOrders() {
        File file = new File(ORDER_FILE);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(ORDER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Loaded Order: " + line);
            }
        } catch (IOException e) {
            System.err.println("Error loading orders: " + e.getMessage());
        }
    }

    // Shutdown the executor service
    public void shutdown() {
        executorService.shutdown();
    }
}
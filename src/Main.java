import java.io.*;
import java.util.*;
import java.util.concurrent.*;


// Main class to run the application
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        System.out.print("Enter product price: ");
        double productPrice = scanner.nextDouble();
        System.out.print("Enter initial stock level: ");
        int stockLevel = scanner.nextInt();
        System.out.print("Enter reorder threshold: ");
        int reorderThreshold = scanner.nextInt();

        Product product = new Product(productName, productPrice, stockLevel, reorderThreshold);
        OrderManager orderManager = new OrderManager();

        orderManager.loadOrders();

        System.out.print("Enter average daily sales: ");
        double dailySales = scanner.nextDouble();

        displayProductDetails(product);

        System.out.println("Stock Prediction:");
        System.out.println("Days until stock out: " + StockPredictor.predictStockOutDays(product, dailySales));
        System.out.println("Restock Suggestion: " + StockPredictor.suggestRestocking(product, dailySales));

        Order order = new Order("Alice", product.getProductId(), 2);
        orderManager.processOrder(order, product);
        orderManager.shutdown();
    }

    // Display product details in the console
    private static void displayProductDetails(Product product) {
        System.out.println("Product ID: " + product.getProductId());
        System.out.println("Name: " + product.getName());
        System.out.println("Price: $" + product.getPrice());
        System.out.println("Stock Level: " + product.getStockLevel());
        System.out.println("Reorder Threshold: " + product.getReorderThreshold());
        System.out.println("----------------------------");
    }
}

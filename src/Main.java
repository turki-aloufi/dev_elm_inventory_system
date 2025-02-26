import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Product laptop = new Product("Laptop", 1200.0, 20, 5);
        Product smartphone = new Product("Smartphone", 800.0, 10, 3);

        System.out.print("Enter average daily sales for Laptop: ");
        double laptopSales = scanner.nextDouble();

        System.out.print("Enter average daily sales for Smartphone: ");
        double smartphoneSales = scanner.nextDouble();

        displayProductDetails(laptop);
        displayProductDetails(smartphone);

        System.out.println("Stock Prediction for Laptop:");
        System.out.println("Days until stock out: " + StockPredictor.predictStockOutDays(laptop, laptopSales));
        System.out.println("Restock Suggestion: " + StockPredictor.suggestRestocking(laptop, laptopSales));

        System.out.println("Stock Prediction for Smartphone:");
        System.out.println("Days until stock out: " + StockPredictor.predictStockOutDays(smartphone, smartphoneSales));
        System.out.println("Restock Suggestion: " + StockPredictor.suggestRestocking(smartphone, smartphoneSales));
    }

    private static void displayProductDetails(Product product) {
        System.out.println("Product ID: " + product.getProductId());
        System.out.println("Name: " + product.getName());
        System.out.println("Price: $" + product.getPrice());
        System.out.println("Stock Level: " + product.getStockLevel());
        System.out.println("Reorder Threshold: " + product.getReorderThreshold());
        System.out.println("----------------------------");
    }
}
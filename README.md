# Product Stock Predictor

## Overview

The **Product Stock Predictor** is a Java-based application that manages product inventory and processes orders using multi-threading. The system predicts stock depletion based on daily sales and suggests restocking actions. Orders are processed asynchronously, and order details are stored in a file.

## Features

- Product management with stock level and reorder threshold.
- Multi-threaded order processing using **ExecutorService**.
- Order status updates (PENDING → SHIPPED → DELIVERED) with logging.
- Persistent order storage using file handling (**orders.txt**).
- Stock prediction for depletion and restocking suggestions.

## Technologies Used

- **Java** (Core language)
- **Multi-threading** (ExecutorService for parallel order processing)
- **File I/O** (BufferedReader & FileWriter for order persistence)
- **UUID** (Unique identification for products & orders)
- **Concurrency Handling** (Synchronization for thread safety)

## Installation & Setup

1. Clone the repository or download the source files.
2. Compile the Java files:
   ```sh
   javac Main.java
   ```
3. Run the application:
   ```sh
   java Main
   ```

## Usage

1. Enter product details (name, price, stock level, reorder threshold).
2. Enter the average daily sales for stock prediction.
3. The system displays:
    - Product information
    - Days until stock depletion
    - Restock suggestions
4. Orders are created and processed in separate threads.
5. Order details are saved to **orders.txt** and reloaded on startup.

## Example Output

```
Enter product name: Laptop
Enter product price: 1200
Enter initial stock level: 20
Enter reorder threshold: 5
Enter average daily sales: 4

Product ID: 123e4567-e89b-12d3-a456-426614174000
Name: Laptop
Price: $1200.0
Stock Level: 20
Reorder Threshold: 5
----------------------------
Stock Prediction for Laptop:
Days until stock out: 5
Restock Suggestion: Moderate: Consider restocking soon.

Processing order: a1b2c3d4-5678-90ab-cdef-1234567890ab
Order a1b2c3d4 status updated to SHIPPED
Order a1b2c3d4 status updated to DELIVERED
```

## Future Enhancements

- Implement a database for persistent storage.
- Add a graphical user interface (GUI).
- Support for multiple products and bulk orders.

## License

This project is open-source and free to use.


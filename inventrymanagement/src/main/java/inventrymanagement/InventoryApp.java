package inventrymanagement;

import java.util.Scanner;

public class InventoryApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManager inventoryManager = new InventoryManager();

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. View all products");
            System.out.println("2. Add new product");
            System.out.println("3. Update product");
            System.out.println("4. Remove product");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    inventoryManager.viewProducts();
                    break;

                case 2:
                    System.out.print("Enter product ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    Product newProduct = new Product(id, name, category, quantity, price);
                    inventoryManager.addProduct(newProduct);
                    System.out.println("Product added.");
                    break;

                case 3:
                    System.out.print("Enter product ID to update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    inventoryManager.updateProduct(updateId, newPrice, newQuantity);
                    break;

                case 4:
                    System.out.print("Enter product ID to remove: ");
                    String removeId = scanner.nextLine();
                    inventoryManager.removeProduct(removeId);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }
}

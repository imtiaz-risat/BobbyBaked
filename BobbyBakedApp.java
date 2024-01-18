
//import Orders.OnlineOrder;
//import Orders.InStoreOrder;
//import Products.BakeryItem;
//import Products.Cake;
//import Products.Pastry;
import Inventory.InventoryManager;
import Inventory.ProductManager;
//import Employees.Employee;
//import Employees.EmployeeManager;
//import Billings.InvoiceGenerator;

import java.util.Scanner;

public class BobbyBakedApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ProductManager productManager = new ProductManager();
        InventoryManager inventoryManager = InventoryManager.getInstance();

        while (true) {
            printMainMenu();

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    handleCustomerMenu(scanner, productManager, inventoryManager);
                    break;
                case 2:
                    handleProductManagerMenu(scanner, productManager, inventoryManager);
                    break;
                case 3:
                    inventoryManagerMenu(scanner, inventoryManager);
                    break;
                case 4:
                    System.out.println("Exiting Bakery App. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("Main Menu:");
        System.out.println("1. Customer");
        System.out.println("2. Product Manager");
        System.out.println("3. Inventory Manager");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void handleCustomerMenu(Scanner scanner, ProductManager productManager,
            InventoryManager inventoryManager) {
        while (true) {
            printCustomerMenu();

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    handleMakeOrder(scanner, productManager, inventoryManager);
                    break;
                case 2:
                    handleViewCart(scanner);
                    break;
                case 3:
                    return; // Back to main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printCustomerMenu() {
        System.out.println("\nCustomer Menu:");
        System.out.println("1. Make Order");
        System.out.println("2. View Cart");
        System.out.println("3. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }

    private static void handleMakeOrder(Scanner scanner, ProductManager productManager,
            InventoryManager inventoryManager) {
        // Implement the logic for making an order
        // You may need to create additional methods and classes for this functionality
        System.out.println("Make Order functionality not implemented yet.");
    }

    private static void handleViewCart(Scanner scanner) {
        // Implement the logic for viewing the cart
        // You may need to create additional methods and classes for this functionality
        System.out.println("View Cart functionality not implemented yet.");
    }

    private static void handleProductManagerMenu(Scanner scanner, ProductManager productManager,
            InventoryManager inventoryManager) {
        while (true) {
            printProductManagerMenu();

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    handleAddProduct(scanner, productManager, inventoryManager);
                    break;
                case 2:
                    handleCheckAvailability(scanner, productManager, inventoryManager);
                    break;
                case 3:
                    return; // Back to main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printProductManagerMenu() {
        System.out.println("\nProduct Manager Menu:");
        System.out.println("1. Add Product");
        System.out.println("2. Check Availability");
        System.out.println("3. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }

    private static void handleAddProduct(Scanner scanner, ProductManager productManager,
            InventoryManager inventoryManager) {
        // Implement the logic for adding a product
        // You may need to create additional methods and classes for this functionality
        System.out.println("Add Product functionality not implemented yet.");
    }

    private static void handleCheckAvailability(Scanner scanner, ProductManager productManager,
            InventoryManager inventoryManager) {
        // Implement the logic for checking product availability
        // You may need to create additional methods and classes for this functionality
        System.out.println("Check Availability functionality not implemented yet.");
    }

    private static void inventoryManagerMenu(Scanner scanner, InventoryManager inventoryManager) {
        while (true) {
            printInventoryManagerMenu();

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    inventoryManager.trackInventory();
                    break;
                case 2:
                    inventoryManager.checkLowInventory();
                    break;
                case 3:
                    return; // Back to main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printInventoryManagerMenu() {
        System.out.println("\nInventory Manager Menu:");
        System.out.println("1. Track Inventory");
        System.out.println("2. Check Low Inventory");
        System.out.println("3. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }
}

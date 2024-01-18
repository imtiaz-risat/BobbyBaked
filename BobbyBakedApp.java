
//import Orders.OnlineOrder;
import Products.BakeryItem;
import Products.Cake;
import Products.Pastry;
import Orders.InStoreOrder;
//import Products.BakeryItem;
//import Products.Cake;
//import Products.Pastry;
import Inventory.InventoryManager;
import Inventory.ProductManager;
//import Billings.InvoiceGenerator;

import java.util.Scanner;

import Billings.InvoiceGenerator;

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
        InStoreOrder customerOrder = new InStoreOrder();

        while (true) {
            printOrderMenu();

            int orderChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (orderChoice) {
                case 1:
                    addCakeToOrder(scanner, productManager, customerOrder);
                    break;
                case 2:
                    addPastryToOrder(scanner, productManager, customerOrder);
                    break;
                case 3:
                    processOrder(productManager, inventoryManager, customerOrder);
                    return; // Back to customer menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printOrderMenu() {
        System.out.println("\nMake Order Menu:");
        System.out.println("1. Add Cake to Order");
        System.out.println("2. Add Pastry to Order");
        System.out.println("3. Process Order");
        System.out.print("Enter your choice: ");
    }

    private static void addCakeToOrder(Scanner scanner, ProductManager productManager, InStoreOrder customerOrder) {

        System.out.println("Add Cake to Order functionality not implemented yet.");
    }

    private static void addPastryToOrder(Scanner scanner, ProductManager productManager, InStoreOrder customerOrder) {

        System.out.println("Add Pastry to Order functionality not implemented yet.");
    }

    private static void processOrder(ProductManager productManager, InventoryManager inventoryManager,
            InStoreOrder customerOrder) {
        if (customerOrder.isEmpty()) {
            System.out.println("No items in the order. Returning to Customer Menu.");
            return;
        }

        System.out.println("\nProcessing Order...\n\n");

        for (BakeryItem item : customerOrder.getItems()) {
            productManager.removeProduct(item);
        }

        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        invoiceGenerator.generateInvoice(customerOrder);

        customerOrder.clearOrder();
    }

    private static void handleViewCart(Scanner scanner) {
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
        System.out.println("\nAdd Product:");

        System.out.print("Enter product type (Cake/Pastry): ");
        String productType = scanner.nextLine();

        System.out.print("Enter flavor: ");
        String flavor = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        BakeryItem newProduct;

        if (productType.equalsIgnoreCase("Cake")) {
            newProduct = new Cake(flavor, price);
        } else if (productType.equalsIgnoreCase("Pastry")) {
            newProduct = new Pastry(flavor, price);
        } else {
            System.out.println("Invalid product type. Product not added.");
            return;
        }

        productManager.addProduct(newProduct);
        System.out.println("Product added successfully.");
    }

    private static void handleCheckAvailability(Scanner scanner, ProductManager productManager,
            InventoryManager inventoryManager) {
        System.out.println("\nCheck Product Availability:");

        System.out.print("Enter product type (Cake/Pastry): ");
        String productType = scanner.nextLine();

        System.out.print("Enter flavor: ");
        String flavor = scanner.nextLine();

        int availableQuantity = inventoryManager.getAvailableQuantity(productType, flavor);

        System.out.println("Available Quantity: " + availableQuantity);
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

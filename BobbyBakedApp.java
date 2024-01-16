import Orders.OnlineOrder;
import Orders.InStoreOrder;
import Products.BakeryItem;
import Products.Cake;
import Products.Pastry;
import Inventory.InventoryManager;
import Inventory.ProductManager;
import Employees.Employee;
import Employees.EmployeeManager;
import Billings.InvoiceGenerator;

import java.util.Scanner;

public class BobbyBakedApp {

    public static Scanner scanner = new Scanner(System.in);
    public static OnlineOrder onlineOrder = new OnlineOrder();

    public void customerDashboard() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Welcome to Bobby's Baked Goods!");
            System.out.println("1. Make Order");
            System.out.println("2. View Cart");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    makeOrder();
                    break;
                case 2:
                    viewCart();
                    break;
                case 3:
                    checkout();
                    exit = true;
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public void makeOrder() {

        System.out.println("1. Cake");
        System.out.println("2. Pastry");

        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            System.out.println("We have these flavors available:");
            System.out.println("Chocolate, Vanilla, Butter");
            System.out.println("Choose Flavor: ");
            String flavor = scanner.nextLine();

            if (flavor.equals("Chocolate") || flavor.equals("Vanilla") || flavor.equals("Butter")) {
                BakeryItem cake = new Cake(flavor, 30);
                onlineOrder.addItem(cake);
                System.out.println(cake.getType() + " cake added to order!");
                System.out.println("=====================\n1. Add More Items\n2. Checkout");
                choice = Integer.parseInt(scanner.nextLine());

                if (choice == 1) {
                    makeOrder();
                } else if (choice == 2) {
                    checkout();
                } else {
                    System.out.println("Invalid option selected! Exiting...");
                    return;
                }
            } else {
                System.out.println("This flavor is not available!");
                makeOrder();
            }
        } else if (choice == 2) {
            System.out.println("We have these pastries available...");
            System.out.println("1. Cheesecake\n2. Danish\n3. Velvet");
            System.out.println("Choose Pastry: ");
            String flavor = scanner.nextLine();

            if (flavor.equals("Danish") || flavor.equals("Cheesecake") || flavor.equals("Velvet")) {

                int price;
                if (flavor.equals("Danish")) {
                    price = 80;
                } else if (flavor.equals("Cheesecake")) {
                    price = 170;
                } else {
                    price = 120;
                }

                BakeryItem pastry = new Pastry("Croissant", price);
                onlineOrder.addItem(pastry);
                System.out.println(pastry.getType() + " pastry added to order!");
                System.out.println("=====================\n1. Add More Items\n2. Checkout");
                choice = Integer.parseInt(scanner.nextLine());

                if (choice == 1) {
                    makeOrder();
                } else if (choice == 2) {
                    System.out.println("Checkout complete! Thank you for your order.");
                } else {
                    System.out.println("Invalid option selected! Exiting...");
                    return;
                }
            } else {
                System.out.println("This pastry is not available");
                makeOrder();
            }
        }

    }

    public void viewCart() {
        System.out.println("Your Cart:");
        double total = 0;
        for (BakeryItem item : onlineOrder.getItems()) {
            System.out.println(item.getType() + ": " + item.getPrice());
            total += item.getPrice();
        }
        System.out.println("Total: " + total);

        System.out.println("=====================\n1. Add More Items\n2. Checkout");
        int choice = scanner.nextInt();

        if (choice == 1) {
            makeOrder();
        } else if (choice == 2) {
            System.out.println("Checkout complete! Thank you for your order.");
        } else {
            System.out.println("Invalid option selected! Exiting...");
            return;
        }
    }

    public void checkout() {
        if (onlineOrder.getTotalPrice() > 0) {
            System.out.println("Generating invoice...");
            InvoiceGenerator invoice = new InvoiceGenerator();
            invoice.generateInvoice(onlineOrder);

            System.out.println("Thank you for your order!");
        } else {
            System.out.println("Your cart is empty. Please add some items.");
            makeOrder();
        }
    }

    public static void main(String[] args) {
        // Sample usage of the Bakery Management System
        // Create bakery items

        // int scanned = scanner.nextInt();
        // if (scanned == 1) {
        // System.out.println("Taking in-store order...");

        // } else {
        // System.out.println("Taking online order...");
        // }

        // Create bakery items
        BakeryItem cake1 = new Cake("Chocolate", 25.0);
        BakeryItem pastry1 = new Pastry("Croissant", 5.0);
        BakeryItem pastry2 = new Pastry("Velvet", 5.0);

        // Create product manager and add products
        ProductManager productManager = new ProductManager();
        productManager.addProduct(cake1);
        productManager.addProduct(pastry1);
        productManager.addProduct(pastry2);
        productManager.addProduct(cake1);
        productManager.addProduct(pastry1);
        productManager.addProduct(pastry2);

        // Display current inventory
        InventoryManager.getInstance().trackInventory();

        // Check Low Inventory
        InventoryManager.getInstance().checkLowInventory();

        // Create employee manager and add employees
        EmployeeManager employeeManager = new EmployeeManager();
        // employeeManager.addEmployee();

        // Update an employee
        // employeeManager.updateEmployee();

        // Create online order and add items
        OnlineOrder onlineOrder = new OnlineOrder();
        onlineOrder.addItem(cake1);
        onlineOrder.addItem(pastry1);

        // Process the online order
        onlineOrder.processOrder();

        // Generate invoice for the order
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double invoiceAmount = invoiceGenerator.generateInvoice(onlineOrder);
        System.out.println("Invoice Amount: $" + invoiceAmount);

        // Create in-store order and add items
        InStoreOrder inStoreOrder = new InStoreOrder();
        inStoreOrder.addItem(pastry2);

        // Process the in-store order
        inStoreOrder.processOrder();

        // Generate invoice for the in-store order
        double inStoreInvoiceAmount = invoiceGenerator.generateInvoice(inStoreOrder);
        System.out.println("In-Store Invoice Amount: $" + inStoreInvoiceAmount);

    }
}

import Orders.OnlineOrder;
import Orders.InStoreOrder;
import Products.BakeryItem;
import Products.Cake;
import Products.Pastry;
import Inventory.InventoryManager;
import Inventory.ProductManager;
import Employees.Employee;
import Employees.EmployeeManager;

import java.util.Scanner;

import Billings.InvoiceGenerator;

public class BobbyBakedApp {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Sample usage of the Bakery Management System
        // Create bakery items

        int scanned = scanner.nextInt();
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
        Employee employee1 = new Employee(100, "John Doe");
        employeeManager.addEmployee(employee1);

        // Update an employee
        employeeManager.updateEmployee();

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

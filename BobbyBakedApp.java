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

public class BobbyBakedApp {
    public static void main(String[] args) {
        // Sample usage of the Bakery Management System
        // Create bakery items
        BakeryItem cake1 = new Cake("Chocolate", 25.0);
        BakeryItem pastry1 = new Pastry("Croissant", 5.0);
        BakeryItem pastry2 = new Pastry("Velvet", 5.0);

        // Create product manager and add products
        ProductManager productManager = new ProductManager();
        productManager.addProduct(cake1);
        productManager.addProduct(pastry1);
        productManager.addProduct(pastry2);

        // Display current inventory
        InventoryManager.getInstance().trackInventory();

        // Create employee manager and add employees
        EmployeeManager employeeManager = new EmployeeManager();
        Employee employee1 = new Employee("John Doe");
        employeeManager.addEmployee(employee1);

        // Update an employee
        employeeManager.updateEmployee(employee1);

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

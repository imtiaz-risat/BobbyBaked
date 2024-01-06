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
        BakeryItem cake = new Cake("Chocolate", 25.0);
        BakeryItem pastry = new Pastry("Croissant", 5.0);

        // Create product manager and add products
        ProductManagement productManager = new ProductManager();
        productManager.addProduct(cake);
        productManager.addProduct(pastry);

        // Display current inventory
        InventoryManager.getInstance().trackInventory();

        // Create employee manager and add employees
        EmployeeManagement employeeManager = new EmployeeManager();
        Employee employee1 = new Employee("John Doe");
        employeeManager.addEmployee(employee1);

        // Update an employee
        employeeManager.updateEmployee(employee1);

        // Create online order and add items
        Order onlineOrder = new OnlineOrder();
        ((OnlineOrder) onlineOrder).addItem(cake);
        ((OnlineOrder) onlineOrder).addItem(pastry);

        // Process the online order
        onlineOrder.processOrder();

        // Generate invoice for the order
        Billing invoiceGenerator = new InvoiceGenerator();
        invoiceGenerator.generateInvoice(onlineOrder);
    }
}

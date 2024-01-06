package Inventory;

//import java.util.ArrayList;
//import java.util.List;
import Products.BakeryItem;

public class ProductManager implements ProductManagement {
    // private List<BakeryItem> products;

    public ProductManager() {
        // this.products = new ArrayList<>();
    }

    @Override
    public void addProduct(BakeryItem item) {
        // products.add(item);
        InventoryManager.getInstance().addInventoryItem(item);
    }

    @Override
    public void updateProduct(BakeryItem item) {
        // Implementation to update product details
        // Placeholder, actual implementation needed
        System.out.println("Product updated: ");
        item.display();
    }

    @Override
    public void removeProduct(BakeryItem item) {
        // products.remove(item);
        // Additional logic for removing from inventory
        InventoryManager.getInstance().trackInventory();
    }
}
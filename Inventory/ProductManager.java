package Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import Products.BakeryItem;

public class ProductManager extends Inventory implements ProductManagement {
    // private List<BakeryItem> products;
    private static List<BakeryItem> inventory = getSharedList();
    private static Map<String, Integer> itemCounts = getSharedItemCount();

    public ProductManager() {
        inventory = new ArrayList<>();
        itemCounts = new HashMap<>();
    }

    @Override
    public void addProduct(BakeryItem item) {

        inventory.add(item);

        String itemName = item.getClass().getSimpleName();

        if (itemCounts.containsKey(itemName)) {
            int count = itemCounts.get(item.getClass().getSimpleName());
            itemCounts.remove(itemName, count);
            itemCounts.put(item.getClass().getSimpleName(), count + 1);
        } else {
            itemCounts.put(item.getClass().getSimpleName(), 1);
        }
    }

    // @Override
    // public void updateProduct(BakeryItem item) {
    // // Implementation to update product details
    // // Placeholder, actual implementation needed
    // System.out.println("Product updated: ");
    // item.display();
    // }

    @Override
    public void removeProduct(BakeryItem item) {

        inventory.add(item);

        String itemName = item.getClass().getSimpleName();

        if (checkAvailability(item)) {
            int count = itemCounts.get(item.getClass().getSimpleName());
            itemCounts.remove(itemName, count);
            itemCounts.put(item.getClass().getSimpleName(), count + 1);
        } else {
            itemCounts.put(item.getClass().getSimpleName(), 0);
            System.out.println("There's no ");
        }
    }

    public boolean checkAvailability(BakeryItem item) {

        String itemName = itemCounts.getClass().getSimpleName();
        if (itemCounts.containsKey(itemName)) {
            int count = itemCounts.get(item.getClass().getSimpleName());
            if (count > 0) {
                return true;
            }
        }
        return false;
    }
}
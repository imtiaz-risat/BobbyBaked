package Inventory;

import java.util.List;
import java.util.Map;

import Products.BakeryItem;

public class ProductManager extends Inventory implements ProductManagement {
    // private List<BakeryItem> products;
    private static List<BakeryItem> inventory;
    private static Map<String, Integer> itemCounts;

    public ProductManager() {
        inventory = getSharedList();
        itemCounts = getSharedItemCount();
    }

    @Override
    public void addProduct(BakeryItem item) {

        inventory.add(item);

        String itemName = item.getClass().getSimpleName();

        if (itemCounts.containsKey(itemName)) {
            int count = itemCounts.get(item.getClass().getSimpleName());
            itemCounts.remove(itemName, count);
            itemCounts.put(item.getClass().getSimpleName(), count + 1);
            System.out.println("Product updated: " + item.getClass().getSimpleName() + " quantity: " + (count + 1));
        } else {
            itemCounts.put(item.getClass().getSimpleName(), 1);
            System.out.println("Product added: " + item.getClass().getSimpleName() + " quantity: 1");
        }
    }

    @Override
    public void removeProduct(BakeryItem item) {

        inventory.add(item);

        String itemName = item.getClass().getSimpleName();

        if (checkAvailability(itemName) > 0) {
            int count = itemCounts.get(item.getClass().getSimpleName());
            itemCounts.remove(itemName, count);
            itemCounts.put(item.getClass().getSimpleName(), count - 1);
        } else {
            itemCounts.put(item.getClass().getSimpleName(), 0);
            System.out.println("There's no ");
        }
    }

    public int checkAvailability(String itemName) {

        // String itemName = itemCounts.getClass().getSimpleName();
        if (itemCounts.containsKey(itemName)) {
            int count = itemCounts.get(itemName);
            if (count > 0) {
                return count;
            }
        }
        return 0;
    }
}
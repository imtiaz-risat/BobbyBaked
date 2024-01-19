package Inventory;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Products.BakeryItem;

public class InventoryManager extends Inventory implements InventoryManagement {
    private static InventoryManager inventoryManager;
    private static List<BakeryItem> inventory;
    private Map<String, Integer> itemCounts;

    private InventoryManager() {
        inventory = getSharedList();
        itemCounts = getSharedItemCount();
    }

    public static InventoryManager getInstance() {
        if (inventoryManager == null) {
            inventoryManager = new InventoryManager();
        }
        return inventoryManager;
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

    @Override
    public void trackInventory() {
        System.out.println("Current Inventory:");

        // Using Set to keep track of distinct items
        Set<String> uniqueItems = new HashSet<>();

        for (BakeryItem item : inventory) {
            if (uniqueItems.add(item.getClass().getSimpleName())) {
                int itemCount = itemCounts.getOrDefault(item.getClass().getSimpleName(), 0);
                System.out.println(item.getClass().getSimpleName() + " - " + itemCount +
                        "pc");
            }
        }
    }

    private void alertLowInventory(BakeryItem item, int count) {
        System.out.println("Alert: There's " + count + " " + item.getClass().getSimpleName() + " in the inventory!");
    }

    @Override
    public void checkLowInventory() {
        Set<String> uniqueItems = new HashSet<>();

        for (BakeryItem item : inventory) {
            if (uniqueItems.add(item.getClass().getSimpleName())) {
                int itemCount = itemCounts.getOrDefault(item.getClass().getSimpleName(), 0);
                if (itemCount <= 1) {
                    alertLowInventory(item, itemCount);
                } else {
                    System.out.println(item.getClass().getSimpleName() + " are in sufficient amount!");
                }
            }
        }
    }

    public int getAvailableQuantity(String productType, String flavor) {
        int count = 0;

        for (BakeryItem item : inventory) {
            String itemName = item.getClass().getSimpleName();

            if (itemName.equalsIgnoreCase(productType) && item.getType().equalsIgnoreCase(flavor)) {
                count++;
            }
        }

        return count;
    }
}

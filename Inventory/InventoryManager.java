package Inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Products.BakeryItem;

public class InventoryManager extends Inventory implements InventoryManagement {
    private static InventoryManager inventoryManager;
    private static List<BakeryItem> inventory = getSharedList();
    private Map<String, Integer> itemCounts;

    private InventoryManager() {
        inventory = new ArrayList<>();
        itemCounts = new HashMap<String, Integer>();
    }

    public static InventoryManager getInstance() {
        if (inventoryManager == null) {
            inventoryManager = new InventoryManager();
        }
        return inventoryManager;
    }

    public void addInventoryItem(BakeryItem item) {

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

        // Use a Set to keep track of distinct items
        Set<String> uniqueItems = new HashSet<>();

        for (BakeryItem item : inventory) {
            if (uniqueItems.add(item.getClass().getSimpleName())) {
                int itemCount = itemCounts.getOrDefault(item.getClass().getSimpleName(), 0);
                System.out.println(item.getClass().getSimpleName() + " - " + itemCount +
                        "pc");
            }
        }
    }

    // @Override
    // public void trackInventory() {
    // System.out.println("Current Inventory:");

    // for (BakeryItem item : inventory) {
    // int itemCount = itemCounts.getOrDefault(item.getClass().getSimpleName(), 0);
    // System.out.println(item.getClass().getSimpleName() + " - " + itemCount +
    // "pc");
    // }
    // }

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
                    System.out.println("All products are in sufficient amount!");
                }
            }
        }
    }
}

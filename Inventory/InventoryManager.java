package Inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Products.BakeryItem;

public class InventoryManager implements InventoryManagement {
    private static InventoryManager inventoryManager;
    private List<BakeryItem> inventory;
    private Map<String, Integer> itemCounts;

    private InventoryManager() {
        this.inventory = new ArrayList<>();
        itemCounts = new HashMap<>();
    }

    public static InventoryManager getInstance() {
        if (inventoryManager == null) {
            inventoryManager = new InventoryManager();
        }
        return inventoryManager;
    }

    public void addInventoryItem(BakeryItem item) {
        inventory.add(item);
        itemCounts.put(item.getClass().getSimpleName(),
                itemCounts.getOrDefault(item.getClass().getSimpleName(), 0) + 1);
    }

    @Override
    public void trackInventory() {
        System.out.println("Current Inventory:");

        // Use a Set to keep track of distinct items
        Set<String> uniqueItems = new HashSet<>();

        for (BakeryItem item : inventory) {
            if (uniqueItems.add(item.getClass().getSimpleName())) {
                int itemCount = itemCounts.getOrDefault(item.getClass().getSimpleName(), 0);
                System.out.println(item.getClass().getSimpleName() + " - " + itemCount + "pc");
            }
        }
    }

    @Override
    public void alertLowInventory() {
        // Implementation to alert low inventory
        // Placeholder, actual implementation needed
        System.out.println("Alert: Low inventory!");
    }
}

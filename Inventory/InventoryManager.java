package Inventory;

public class InventoryManager implements InventoryManagement {
    private static InventoryManager instance;
    private List<BakeryItem> inventory;

    private InventoryManager() {
        this.inventory = new ArrayList<>();
    }

    public static InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }

    public void addInventoryItem(BakeryItem item) {
        inventory.add(item);
    }

    @Override
    public void trackInventory() {
        System.out.println("Current Inventory:");
        for (BakeryItem item : inventory) {
            item.display();
        }
    }

    @Override
    public void alertLowInventory() {
        // Implementation to alert low inventory
        // Placeholder, actual implementation needed
        System.out.println("Alert: Low inventory!");
    }
}

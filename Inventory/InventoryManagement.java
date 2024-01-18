package Inventory;

import Products.BakeryItem;

public interface InventoryManagement {
    void addProduct(BakeryItem item);

    void trackInventory();

    void checkLowInventory();
}
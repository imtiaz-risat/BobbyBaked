package Inventory;

import Products.BakeryItem;

public interface ProductManagement {
    void addProduct(BakeryItem item);

    void removeProduct(BakeryItem item);
}
package Inventory;

import java.util.ArrayList;
import java.util.List;

import Products.BakeryItem;

public class Inventory {
    private static List<BakeryItem> inventory = new ArrayList<>();

    public static List<BakeryItem> getSharedList() {
        return inventory;
    }
}

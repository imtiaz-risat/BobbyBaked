package Inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Products.BakeryItem;

public class Inventory {
    private static List<BakeryItem> inventory = new ArrayList<>();
    private static Map<String, Integer> itemCounts = new HashMap<>();

    public static List<BakeryItem> getSharedList() {
        return inventory;
    }

    public static Map<String, Integer> getSharedItemCount() {
        return itemCounts;
    }
}

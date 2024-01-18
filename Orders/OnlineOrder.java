package Orders;

import java.util.ArrayList;
import java.util.List;
import Products.BakeryItem;

public class OnlineOrder implements Order {
    private List<BakeryItem> items;
    public double totalPrice;

    public OnlineOrder() {
        this.items = new ArrayList<>();
    }

    public void addItem(BakeryItem item) {
        items.add(item);
    }

    @Override
    public void processOrder() {
        System.out.println("Processing in-store order:");
        for (BakeryItem item : items) {
            item.display();
        }
        System.out.println("===========================");
    }

    @Override
    public double getTotalPrice() {
        for (BakeryItem item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public void clearOrder() {
        items.clear();
        totalPrice = 0;
    }

    public void removeItem(BakeryItem item) {
        items.remove(item);
    }

    public List<BakeryItem> getItems() {
        return items;
    }
}

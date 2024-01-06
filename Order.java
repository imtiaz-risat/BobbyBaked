public interface Order {
    void processOrder();
}

public class OnlineOrder implements Order {
    private List<BakeryItem> items;

    public OnlineOrder() {
        this.items = new ArrayList<>();
    }

    public void addItem(BakeryItem item) {
        items.add(item);
    }

    @Override
    public void processOrder() {
        System.out.println("Processing online order:");
        for (BakeryItem item : items) {
            item.display();
        }
    }
}

// Concrete class for in-store orders
public class InStoreOrder implements Order {
    private List<BakeryItem> items;

    public InStoreOrder() {
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
    }
}
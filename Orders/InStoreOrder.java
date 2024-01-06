package Orders;

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
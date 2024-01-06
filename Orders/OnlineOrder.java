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

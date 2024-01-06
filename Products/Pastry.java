package Products;

public class Pastry implements BakeryItem {
    private String type;
    private double price;

    public Pastry(String type, double price) {
        this.type = type;
        this.price = price;
    }

    @Override
    public void display() {
        System.out.println("Pastry - Type: " + type + ", Price: $" + price);
    }

    @Override
    public double getPrice() {
        return price;
    }
}
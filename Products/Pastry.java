package Products;

public class Pastry implements BakeryItem {
    private String flavor;
    private double price;

    public Pastry(String type, double price) {
        this.flavor = type;
        this.price = price;
    }

    @Override
    public void display() {
        System.out.println("Pastry - Type: " + flavor + ", Price: $" + price);
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getType() {
        return flavor;
    }
}
package Products;

public class Cake implements BakeryItem {
    private String flavor;
    private double price;

    public Cake(String flavor, double price) {
        this.flavor = flavor;
        this.price = price;
    }

    @Override
    public void display() {
        System.out.println("Cake - Flavor: " + flavor + ", Price: $" + price);
    }

    @Override
    public double getPrice() {
        return price;
    }
}
package Products;

public class Cake implements BakeryItem {
    private String flavor;
    private double price;

    public Cake(String flavor) {
        this.flavor = flavor;
        this.price = getPrice();
    }

    @Override
    public void display() {
        System.out.println("Cake - Flavor: " + flavor + ", Price: $" + price);
    }

    @Override
    public double getPrice() {
        if (flavor == "Chocolate") {
            return 90.00;
        } else if (flavor == "Vanilla") {
            return 70.00;
        } else if (flavor == "Butter") {
            return 100.00;
        }
        return 90.00;
    }

    @Override
    public String getType() {
        return flavor;
    }
}
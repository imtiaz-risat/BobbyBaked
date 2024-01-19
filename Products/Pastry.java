package Products;

public class Pastry implements BakeryItem {
    private String flavor;
    private double price;

    public Pastry(String type) {
        this.flavor = type;
        this.price = getPrice();
    }

    @Override
    public void display() {
        System.out.println("Pastry - Type: " + flavor + ", Price: $" + price);
    }

    @Override
    public double getPrice() {
        if (flavor == "Chessecake") {
            return 250.00;
        } else if (flavor == "Velvet") {
            return 160.00;
        } else if (flavor == "Balck Forest") {
            return 180.00;
        } else {
            return 150.00;
        }
    }

    @Override
    public String getType() {
        return flavor;
    }
}
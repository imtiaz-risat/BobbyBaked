package Orders;

public interface Order {
    void processOrder();

    double getTotalPrice();

    boolean isEmpty();

    void clearOrder();

}
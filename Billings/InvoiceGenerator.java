package Billings;

import Orders.Order;

public class InvoiceGenerator {
    // @Override
    public double generateInvoice(Order order) {
        order.processOrder();
        System.out.println(String.format("Total price for order is: $%.2f", order.getTotalPrice()));
        System.out.println("Thank You for your order !");
        return 0.0;
    }

}
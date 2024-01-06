package Billings;

import Orders.Order;

public class InvoiceGenerator implements Billing {
    @Override
    public double generateInvoice(Order order) {
        // Implementation to generate an invoice for an order
        // Actual calculation needed
        System.out.println("Invoice generated for the order");
        return 0.0;
    }
}
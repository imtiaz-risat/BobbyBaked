package Billings;

import Orders.Order;

public interface Billing {
    double generateInvoice(Order order);
}
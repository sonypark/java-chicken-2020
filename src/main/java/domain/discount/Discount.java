package domain.discount;

import domain.order.Order;

public interface Discount {
    double discount(Order order);
}

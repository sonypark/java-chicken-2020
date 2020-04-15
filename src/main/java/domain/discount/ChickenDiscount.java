package domain.discount;

import domain.order.Order;

public class ChickenDiscount implements Discount {
    public static final int DISCOUNT_PRICE = 10_000;
    public static final int DISCOUNT_UNIT = 10;

    @Override
    public double discount(Order order) {
        if (!order.isChicken()) {
            return order.price();
        }
        int count = order.getQuantity() / DISCOUNT_UNIT;
        return order.price() - (DISCOUNT_PRICE * count);
    }
}

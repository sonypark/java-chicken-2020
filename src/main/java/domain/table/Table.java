package domain.table;

import java.util.Objects;

import domain.menu.Menu;
import domain.order.Order;
import domain.order.Orders;
import domain.payment.Payment;

public class Table {
    private final int number;
    private final Orders orders;

    public Table(final int number) {
        this.number = number;
        this.orders = new Orders();
    }

    public boolean isNumber(int number) {
        return this.number == number;
    }

    public void order(Menu menu, int quantity) {
        orders.addOrder(menu, quantity);
    }

    public boolean hasOrder() {
        return !orders.isEmpty();
    }

    public Orders getOrder() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Table))
            return false;
        Table table = (Table)o;
        return number == table.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public double payment(Payment payment) {
        return orders.values()
            .stream()
            .mapToDouble(Order::price)
            .map(payment::pay)
            .sum();
    }
}

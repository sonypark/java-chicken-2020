package domain.order;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import domain.menu.Menu;

public class Orders {
    private final Map<Menu, Order> orders;

    public Orders() {
        this.orders = new HashMap<>();
    }

    public boolean isEmpty() {
        return orders.isEmpty();
    }

    public void addOrder(Menu newMenu, int quantity) {
        orders.computeIfPresent(newMenu, (menu, order) -> new Order(menu, order.getQuantity() + quantity));
        orders.putIfAbsent(newMenu, new Order(newMenu, quantity));
    }

    public Collection<Order> values() {
        return Collections.unmodifiableCollection(orders.values());
    }
}

package domain.order;

import domain.menu.Menu;

public class Order {
    private Menu menu;
    private int quantity;

    public Order(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double price() {
        return menu.getPrice() * quantity;
    }

    public boolean isChicken() {
        return menu.isChicken();
    }
}

package domain;

import java.util.Objects;

public class OrderMenu {
    public static final String SPACE = " ";
    Table table;
    Menu menu;
    int amount;

    public OrderMenu(Menu menu, Table table, int amount) {
        this.menu = menu;
        this.table = table;
        this.amount = amount;
    }

    public Table getTable() {
        return table;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getChickenMenuAmount() {
        if (menu.isChicken()) {
            return amount;
        }
        return 0;
    }

    public int getAmount() {
        return amount;
    }

    public int getTableNumber() {
        return table.getNumber();
    }

    public boolean containTableNumber(int tableNumber) {
        return table.getNumber() == tableNumber;
    }

    public int calculateTotalPrice() {
        return menu.getPrice() * amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof OrderMenu))
            return false;
        OrderMenu orderMenu = (OrderMenu)o;
        return amount == orderMenu.amount &&
            Objects.equals(table, orderMenu.table) &&
            Objects.equals(menu, orderMenu.menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(table, menu, amount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(menu.getName());
        sb.append(SPACE);
        sb.append(amount);
        sb.append(SPACE);
        sb.append(menu.getPrice() * amount);
        return sb.toString();
    }
}

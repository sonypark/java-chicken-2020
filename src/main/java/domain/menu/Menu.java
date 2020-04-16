package domain.menu;

import java.util.Objects;

public class Menu {
    private final int number;
    private final String name;
    private final Category category;
    private final int price;

    public Menu(final int number, final String name, final Category category, final int price) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }

    public boolean isNumber(int number) {
        return this.number == number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Menu))
            return false;
        Menu menu = (Menu)o;
        return number == menu.number &&
            price == menu.price &&
            Objects.equals(name, menu.name) &&
            category == menu.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, category, price);
    }

    public double getPrice() {
        return price;
    }
}

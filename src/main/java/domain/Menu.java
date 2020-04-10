package domain;

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

    public boolean isChicken() {
        return category.isChicken();
    }

    public boolean isSameNumber(int number) {
        return this.number == number;
    }

    public boolean isSameCategory(Category category) {
        return this.category.isSameCategory(category);
    }

    public Category getCategory() {
        return category;
    }

    public int getNumber() {
        return number;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
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

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }
}

package domain;

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
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }
}

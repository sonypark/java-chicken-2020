package domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public static final int MAX_ORDER_NUMBER_IN_A_CATEGORY = 99;
    List<Menu> menus = new ArrayList<>();
    Table table;

    public Order(Table table) {
        this.table = table;
    }

    public void addMenu(Menu menu) {
        validateOrderAmount(menu);
        menus.add(menu);
    }

    private void validateOrderAmount(Menu menu) {
        if (sumNumberOfCategoryOrders(menu) > MAX_ORDER_NUMBER_IN_A_CATEGORY) {
            throw new IllegalArgumentException(
                String.format("한 카테고리의 메뉴는 %s까지만 주문할 수 있습니다.", MAX_ORDER_NUMBER_IN_A_CATEGORY));
        }
    }

    private Integer sumNumberOfCategoryOrders(Menu menu) {
        return menus.stream()
            .filter(menu1 -> menu1.isSameCategory(menu.getCategory()))
            .map(Menu::getNumber)
            .reduce(menu.getNumber(), Integer::sum);
    }

}

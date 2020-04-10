package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChickenRestaurant {
    private static final int FIRST_MENU = 0;
    private static final int MAX_ORDER_NUMBER_IN_CATEGORY = 99;

    List<OrderMenu> orderMenus = new ArrayList<>();

    public void addToOrderList(Menu selectedMenu, int tableNumber, int menuAmount) {
        validateMaxAmountOfCategoryMenu(selectedMenu, menuAmount);
        orderMenus.add(new OrderMenu(selectedMenu, new Table(tableNumber), menuAmount));
    }

    private void validateMaxAmountOfCategoryMenu(Menu menu, int menuAmount) {
        if (MAX_ORDER_NUMBER_IN_CATEGORY < sumAmountOfCategoryMenu(menu, menuAmount)) {
            throw new IllegalArgumentException("같은 카테고리 메뉴는 99까지만 주문 가능합니다.");
        }
    }

    private int sumAmountOfCategoryMenu(Menu menu, int menuAmount) {
        return orderMenus.stream()
            .filter(orderMenu -> orderMenu.getMenu().isSameCategory(menu.getCategory()))
            .map(OrderMenu::getAmount)
            .reduce(menuAmount, Integer::sum);
    }

    public Menu selectMenu(List<Menu> menus, int menuNumber) {
        return menus.stream()
            .filter(menu -> menu.isSameNumber(menuNumber))
            .collect(Collectors.toList())
            .get(FIRST_MENU);
    }

    public List<Integer> findOccupiedTableNumbers() {
        return orderMenus.stream()
            .map(OrderMenu::getTableNumber)
            .collect(Collectors.toList());
    }

    public List<OrderMenu> findTableToPay(int tableNumberToPay) {
        return orderMenus.stream()
            .filter(orderMenu -> orderMenu.containTableNumber(tableNumberToPay))
            .collect(Collectors.toList());
    }

    public void emptyPaidTable(int tableNumber) {
        orderMenus = orderMenus.stream()
            .filter(orderMenu -> !orderMenu.containTableNumber(tableNumber))
            .collect(Collectors.toList());
    }
}

package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChickenRestaurant {
    private static final int FIRST_MENU = 0;

    List<OrderMenu> orderMenus = new ArrayList<>();

    public void addToOrderList(Menu selectedMenu, int tableNumber, int menuAmount) {
        orderMenus.add(new OrderMenu(selectedMenu, new Table(tableNumber), menuAmount));
    }

    public Menu selectMenu(List<Menu> menus, int menuNumber) {
        return menus.stream()
            .filter(menu -> menu.isSameNumber(menuNumber))
            .collect(Collectors.toList())
            .get(FIRST_MENU);
    }

    public List<Integer> getOccupiedTableNumbers() {
        return orderMenus.stream()
            .map(OrderMenu::getTableNumber)
            .collect(Collectors.toList());
    }

    public List<OrderMenu> getTableToPay(int tableNumberToPay) {
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

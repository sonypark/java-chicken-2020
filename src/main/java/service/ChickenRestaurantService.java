package service;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.table.Table;
import domain.table.TableRepository;

public class ChickenRestaurantService {

    public void order(int tableNumber, int menuNumber, int quantity) {
        Table table = TableRepository.findTableByNumber(tableNumber);
        Menu menu = MenuRepository.findMenuByNumber(menuNumber);
        table.order(menu, quantity);
    }
}

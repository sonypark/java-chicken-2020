package controller;

import java.util.List;

import domain.ChickenRestaurant;
import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class ChickenRestaurantController {
    private ChickenRestaurant chickenRestaurant;

    public ChickenRestaurantController(ChickenRestaurant chickenRestaurant) {
        this.chickenRestaurant = chickenRestaurant;
    }

    public void run() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables, chickenRestaurant.getOccupiedTableNumbers());
        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
        int menuNumber = InputView.inputOrderMenu();
        int menuAmount = InputView.inputMenuAmount();
        Menu selectedMenu = chickenRestaurant.selectMenu(menus, menuNumber);
        chickenRestaurant.addToOrderList(selectedMenu, tableNumber, menuAmount);
    }
}

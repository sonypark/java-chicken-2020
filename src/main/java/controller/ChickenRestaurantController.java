package controller;

import java.util.List;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.table.Table;
import domain.table.TableRepository;
import service.ChickenRestaurantService;
import view.InputView;
import view.OutputView;

public class ChickenRestaurantController {
    private final ChickenRestaurantService chickenRestaurantService;
    public boolean isRunning = true;

    public ChickenRestaurantController(ChickenRestaurantService chickenRestaurantService) {
        this.chickenRestaurantService = chickenRestaurantService;
    }

    public void run() {
        while (isRunning) {
            OutputView.printMainScreen();
            int input = InputView.inputMainProcess();
            if (input == 1) {
                order();
            }
            if (input == 2) {
                payment();
            }
            if (input == 3) {
                exit();
            }
        }
    }

    private void order() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
        int menuNumber = InputView.inputOrderMenu();
        int quantity = InputView.inputMenuAmount();

        chickenRestaurantService.order(tableNumber, menuNumber, quantity);
    }

    private void payment() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber();
        OutputView.printOrderList(TableRepository.findTableByNumber(tableNumber).getOrder().values());

        int paymentType = InputView.inputPaymentType();
        OutputView.printPaymentTableNumber(tableNumber);
        double payment = chickenRestaurantService.payment(tableNumber, paymentType);
        OutputView.printPaymentResult(payment);
    }

    private void exit() {
        isRunning = false;
    }
}

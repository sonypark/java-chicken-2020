package service;

import domain.discount.ChickenDiscount;
import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.payment.PaymentGroup;
import domain.table.Table;
import domain.table.TableRepository;

public class ChickenRestaurantService {

    public void order(int tableNumber, int menuNumber, int quantity) {
        Table table = TableRepository.findTableByNumber(tableNumber);
        Menu menu = MenuRepository.findMenuByNumber(menuNumber);
        table.order(menu, quantity);
    }

    public double payment(int tableNumber, int paymentType) {
        Table table = TableRepository.findTableByNumber(tableNumber);
        return table.payment(PaymentGroup.get(paymentType), new ChickenDiscount());
    }
}


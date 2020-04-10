package controller;

import java.util.List;

import domain.ChickenRestaurant;
import domain.OrderMenu;
import domain.Table;
import domain.TableRepository;
import pay.Pay;
import view.InputView;
import view.OutputView;

public class PaymentController {
    private ChickenRestaurant chickenRestaurant;

    public PaymentController(ChickenRestaurant chickenRestaurant) {
        this.chickenRestaurant = chickenRestaurant;
    }

    public void run() {
        showOccupiedTable();

        int tableNumberToPay = InputView.inputTableNumberToPay();
        List<OrderMenu> orderMenus = chickenRestaurant.findTableToPay(tableNumberToPay);
        if (orderMenus.isEmpty()) {
            System.out.println("주문 내역이 없는 테이블 입니다.");
            return;
        }
        pay(tableNumberToPay, orderMenus);
        chickenRestaurant.emptyPaidTable(tableNumberToPay);
    }

    private void pay(int tableNumberToPay, List<OrderMenu> orderMenus) {
        OutputView.printOrderList(orderMenus);
        OutputView.printPaymentTableNumber(tableNumberToPay);
        int paymentType = InputView.inputPaymentType();

        Pay pay = new Pay();
        double payment = pay.getPayment(paymentType, orderMenus);
        OutputView.printPaymentResult(payment);
    }

    private void showOccupiedTable() {
        final List<Table> tables = TableRepository.tables();
        List<Integer> occupiedTableNumbers = chickenRestaurant.findOccupiedTableNumbers();
        OutputView.printTables(tables, occupiedTableNumbers);
    }
}

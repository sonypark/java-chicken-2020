package pay;

import java.util.List;

import domain.OrderMenu;

public class Pay {
    private static final double CASH_DISCOUNT = 0.95;
    private static final int CHICKEN_DISCOUNT = 10_000;
    private static final int CHICKEN_DISCOUNT_UNIT = 10;
    private static final int CREDIT_CARD = 1;
    private static final int CASH = 2;
    private static final int ZERO = 0;

    public double getPayment(int paymentType, List<OrderMenu> orderMenus) {
        int chickenDiscount = calculateChickenDiscount(orderMenus);
        int payMoney = calculateTotalMoneyToPay(orderMenus);

        double payment = ZERO;

        if (paymentType == CREDIT_CARD) {
            payment = payMoney - chickenDiscount;
        }
        if (paymentType == CASH) {
            payment = (payMoney - chickenDiscount) * CASH_DISCOUNT;
        }
        if (payment < ZERO) {
            return ZERO;
        }
        return payment;
    }

    private int calculateChickenDiscount(List<OrderMenu> orderMenuList) {
        int chickenNumber = calculateNumberOfChickenMenu(orderMenuList);
        int discountQuantity = chickenNumber / CHICKEN_DISCOUNT_UNIT;
        if (discountQuantity > ZERO) {
            return discountQuantity * CHICKEN_DISCOUNT;
        }
        return ZERO;
    }

    private int calculateNumberOfChickenMenu(List<OrderMenu> orderMenus) {
        return orderMenus.stream().map(OrderMenu::getChickenMenuAmount).reduce(ZERO, Integer::sum);
    }

    private int calculateTotalMoneyToPay(List<OrderMenu> orderMenuList) {
        return orderMenuList.stream().map(OrderMenu::calculateTotalPrice).reduce(ZERO, Integer::sum);
    }
}

package domain.payment;

public class CashPayment implements Payment {
    public static final double CASH_DISCOUNT = 0.95;

    @Override
    public double pay(double price) {
        return CASH_DISCOUNT * price;
    }
}

package domain.payment;

public class CreditCardPayment implements Payment {
    @Override
    public double pay(double price) {
        return price;
    }
}

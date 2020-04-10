import controller.ChickenRestaurantController;
import controller.PaymentController;
import domain.ChickenRestaurant;
import view.InputView;
import view.OutputView;

public class Application {
    public static final int ORDER = 1;
    public static final int PAY = 2;
    public static final int EXIT = 3;

    public static void main(String[] args) {
        ChickenRestaurant chickenRestaurant = new ChickenRestaurant();
        ChickenRestaurantController chickenRestaurantController = new ChickenRestaurantController(chickenRestaurant);
        PaymentController paymentController = new PaymentController(chickenRestaurant);

        while (true) {
            OutputView.printMainScreen();
            int input = InputView.inputMainProcess();
            if (input == ORDER) {
                chickenRestaurantController.run();
            }
            if (input == PAY) {
                paymentController.run();
            }
            if (input == EXIT) {
                break;
            }
        }
    }

}

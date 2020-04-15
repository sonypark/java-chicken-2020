import controller.ChickenRestaurantController;
import service.ChickenRestaurantService;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {

        new ChickenRestaurantController(new ChickenRestaurantService()).run();

    }
}

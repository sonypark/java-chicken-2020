package domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChickenRestaurantTest {
    private static final List<Menu> menus = new ArrayList<>();

    private ChickenRestaurant chickenRestaurant;

    static {
        menus.add(new Menu(1, "후라이드", Category.CHICKEN, 16_000));
        menus.add(new Menu(2, "양념치킨", Category.CHICKEN, 16_000));
        menus.add(new Menu(3, "반반치킨", Category.CHICKEN, 16_000));
        menus.add(new Menu(4, "통구이", Category.CHICKEN, 16_000));
        menus.add(new Menu(5, "간장치킨", Category.CHICKEN, 17_000));
        menus.add(new Menu(6, "순살치킨", Category.CHICKEN, 17_000));
        menus.add(new Menu(21, "콜라", Category.BEVERAGE, 1_000));
        menus.add(new Menu(22, "사이다", Category.BEVERAGE, 1_000));
    }

    @BeforeEach
    void setUp() {
        chickenRestaurant = new ChickenRestaurant();
    }

    @Test
    @DisplayName("주문 내역 추가")
    void addToOrderList() {

    }

    @Test
    void getOccupiedTableNumbers() {
        //given
        //when
        //then
    }

    @Test
    void getTableToPay() {
        //given
        //when
        //then
    }

    @Test
    void emptyPaidTable() {
        //given
        //when
        //then
    }
}

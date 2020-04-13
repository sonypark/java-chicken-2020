package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderMenuTest {
    private OrderMenu orderMenu;

    @BeforeEach
    void setUp() {
        orderMenu = new OrderMenu(new Menu(1, "후라이드", Category.CHICKEN, 16_000), new Table(1), 10);
    }

    @Test
    @DisplayName("생성자 테스트")
    void constructor() {
        assertThat(orderMenu).isInstanceOf(OrderMenu.class);
    }

    @Test
    @DisplayName("주문한 치킨 갯수")
    void getChickenMenuAmount() {
        OrderMenu notChicken = new OrderMenu(new Menu(22, "사이다", Category.BEVERAGE, 1_000), new Table(1), 10);
        assertThat(orderMenu.getChickenMenuAmount()).isEqualTo(10);
        assertThat(notChicken.getChickenMenuAmount()).isEqualTo(0);
    }

    @Test
    @DisplayName("주문 내역 출력 테스트")
    void toString_test() {
        assertThat(orderMenu.toString()).isEqualTo("후라이드 10 160000");
    }

    @Test
    @DisplayName("주문 내역 해시코드 테스트")
    void hashcode_test() {
        //given
        HashMap<OrderMenu, Integer> orderMenuCount = new HashMap<>();
        //when
        orderMenuCount.put(orderMenu, 1);
        //then
        assertThat(orderMenuCount.get(
            new OrderMenu(new Menu(1, "후라이드", Category.CHICKEN, 16_000),
                new Table(1), 10))).isEqualTo(1);
    }
}

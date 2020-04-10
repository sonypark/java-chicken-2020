package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    @DisplayName("Order 생성자")
    void constructor() {
        assertThat(new Order(new Table(1))).isInstanceOf(Order.class);
    }

    @Test
    @DisplayName("한 카테고리 메뉴는 99개까지 주문 가능")
    void addMenu_under99() {
        Order order = new Order(new Table(1));
        order.addMenu(new Menu(99, "후라이드", Category.CHICKEN, 16_000));
        assertThat(order.menus.size() > 0).isTrue();
    }

    @Test
    @DisplayName("한 카테고리 메뉴는 99개 초과 주문 불가")
    void addMenu_moreThan99() {
        Order order = new Order(new Table(1));
        assertThatThrownBy(() -> order.addMenu(new Menu(100, "후라이드", Category.CHICKEN, 16_000))).isInstanceOf(
            IllegalArgumentException.class);
    }
}

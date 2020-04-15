package domain.order;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.menu.MenuRepository;

class OrderTest {
    @Test
    @DisplayName("주문 생성")
    void constructor() {
        assertThat(new Order(MenuRepository.menus().get(1), 1)).isInstanceOf(Order.class);
    }

    @Test
    @DisplayName("주문 메뉴 수량 추가")
    void addQuantity() {
        //given
        int quantity = 1;
        Order order = new Order(MenuRepository.menus().get(1), 1);
        //when
        order.addQuantity(quantity);
        //then
        assertThat(order.getQuantity()).isEqualTo(2);
    }
}

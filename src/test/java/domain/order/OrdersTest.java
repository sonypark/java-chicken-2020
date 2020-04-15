package domain.order;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.menu.Menu;
import domain.menu.MenuRepository;

class OrdersTest {

    @Test
    @DisplayName("주문 내역 생성")
    void constructor() {
        assertThat(new Orders()).isInstanceOf(Orders.class);
    }

    @Test
    @DisplayName("주문 내역 없음 체크")
    void isEmpty() {
        assertThat(new Orders().isEmpty()).isTrue();
    }

    @Test
    @DisplayName("주문 내역 있음 체크")
    void isNotEmpty() {
        //given
        Menu menu = MenuRepository.menus().get(1);
        Orders orders = new Orders();
        //when
        orders.addOrder(menu, 1);
        assertThat(orders.isEmpty()).isFalse();
    }

    @Test
    @DisplayName("주문 내역 추가")
    void addOrder() {
        //given
        Menu menu = MenuRepository.menus().get(1);
        Orders orders = new Orders();
        //when
        orders.addOrder(menu, 1);
        //then
        assertThat(orders.values().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("이미 존재하는 주문 내역 추가")
    void addOrder_alreadyExist() {
        //given
        Menu menu = MenuRepository.menus().get(1);
        Orders orders = new Orders();
        //when
        orders.addOrder(menu, 1);
        orders.addOrder(menu, 1);
        //then
        assertThat(orders.values().size()).isEqualTo(1);
        assertThat(orders.values()).extracting("quantity").containsExactly(2);
    }
}

package domain.discount;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.menu.MenuRepository;
import domain.order.Order;

class ChickenDiscountTest {

    @Test
    @DisplayName("치킨 10마리 이상 구매 시 할인 적용")
    void discount() {
        //given
        Order order = new Order(MenuRepository.findMenuByNumber(1), 10);
        //when & then
        assertThat(new ChickenDiscount().discount(order)).isEqualTo(150_000);
    }

    @Test
    @DisplayName("치킨 10미만 이상 구매 시 할인 미적용")
    void noDiscount_under_10() {
        //given
        Order order = new Order(MenuRepository.findMenuByNumber(1), 9);
        //when & then
        assertThat(new ChickenDiscount().discount(order)).isEqualTo(144_000);
    }

    @Test
    @DisplayName("치킨 아닌 경우 할인 미적용")
    void noDiscount_When_NotChicken() {
        //given
        Order order = new Order(MenuRepository.findMenuByNumber(22), 10);
        //when & then
        assertThat(new ChickenDiscount().discount(order)).isEqualTo(10_000);
    }
}

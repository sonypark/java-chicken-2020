package pay;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Menu;
import domain.MenuRepository;
import domain.OrderMenu;
import domain.Table;

class PayTest {
    private static final int CREDIT_CARD = 1;
    private static final int CASH = 2;

    @Test
    @DisplayName("주문 내역 카드 계산")
    void calculateByCreditCard() {
        //given
        List<Menu> menus = MenuRepository.menus();
        Menu menu = menus.get(0);
        OrderMenu orderMenu = new OrderMenu(menu, new Table(1), 1);

        //when, then
        assertThat(new Pay().getPayment(CREDIT_CARD, Arrays.asList(orderMenu))).isEqualTo(16_000);
    }

    @Test
    @DisplayName("주문 내역 현금 계산")
    void calculateByCash() {
        //given
        List<Menu> menus = MenuRepository.menus();
        Menu menu = menus.get(0);
        OrderMenu orderMenu = new OrderMenu(menu, new Table(1), 1);

        //when, then
        assertThat(new Pay().getPayment(CASH, Arrays.asList(orderMenu))).isEqualTo(15_200);
    }
}

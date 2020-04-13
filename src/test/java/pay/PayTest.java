package pay;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import domain.Menu;
import domain.MenuRepository;
import domain.OrderMenu;
import domain.Table;

class PayTest {
    private static final int CREDIT_CARD = 1;
    private static final int CASH = 2;
    private final List<Menu> menus = MenuRepository.menus();

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("주문 내역 카드 계산")
    void calculateByCreditCard() {
        //given
        Menu menu = menus.get(0);
        OrderMenu orderMenu = new OrderMenu(menu, new Table(1), 1);

        //when, then
        assertThat(new Pay().getPayment(CREDIT_CARD, Arrays.asList(orderMenu))).isEqualTo(16_000);
    }

    @Test
    @DisplayName("주문 내역 현금 계산")
    void calculateByCash() {
        //given
        Menu menu = menus.get(0);
        OrderMenu orderMenu = new OrderMenu(menu, new Table(1), 1);

        //when, then
        assertThat(new Pay().getPayment(CASH, Arrays.asList(orderMenu))).isEqualTo(15_200);
    }

    @Test
    @DisplayName("주문 내역 없을 때 계산")
    void calculate_when_no_order() {
        //given
        Menu menu = menus.get(0);
        OrderMenu orderMenu = new OrderMenu(menu, new Table(1), 0);

        //when, then
        assertThat(new Pay().getPayment(CASH, Arrays.asList(orderMenu))).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("치킨 10개 단위로 할인")
    @MethodSource("provideChicken")
    void calculate_chicken_discount(final int PAYMENT_TYPE, int amount, int expected) {
        Menu menu = menus.get(0);
        OrderMenu orderMenu = new OrderMenu(menu, new Table(1), amount);

        //when, then
        assertThat(new Pay().getPayment(PAYMENT_TYPE, Arrays.asList(orderMenu))).isEqualTo(expected);
    }

    private static Stream<Arguments> provideChicken() {
        return Stream.of(
            Arguments.arguments(CREDIT_CARD, 10, 150_000),
            Arguments.arguments(CASH, 10, 142_500),
            Arguments.arguments(CREDIT_CARD, 9, 144_000),
            Arguments.arguments(CASH, 9, 136_800)
        );
    }
}

package domain.table;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.menu.MenuRepository;
import domain.payment.CashPayment;
import domain.payment.CreditCardPayment;

class TableRepositoryTest {

    @Test
    @DisplayName("테이블 갯수는 6개")
    void tables() {
        assertThat(TableRepository.tables().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("테이블 번호로 테이블 찾기")
    void findTableByNumber() {
        //given
        Table expected = new Table(1);
        //when & then
        assertThat(TableRepository.findTableByNumber(1)).isEqualTo(expected);
    }

    @Test
    @DisplayName("테이블에 주문 추가")
    void addOrder() {
        //given
        Table table = new Table(1);
        //when
        table.order(MenuRepository.menus().get(1), 1);
        //then
        assertThat(table.getOrder().values().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("테이블에 주문 내역이 있는지 체크")
    void hasOrder() {
        //given
        Table table = new Table(1);
        //when
        table.order(MenuRepository.menus().get(1), 1);
        //then
        assertThat(table.hasOrder()).isTrue();
    }

    @Test
    @DisplayName("테이블 주문 내역 카드 계산")
    void payment_byCreditCard() {
        //given
        Table table = new Table(1);
        //when
        table.order(MenuRepository.menus().get(1), 1);
        //then
        assertThat(table.payment(new CreditCardPayment())).isEqualTo(16_000);
    }

    @Test
    @DisplayName("테이블 주문 내역 현금 계산")
    void payment_byCash() {
        //given
        Table table = new Table(1);
        //when
        table.order(MenuRepository.menus().get(1), 1);
        //then
        assertThat(table.payment(new CashPayment())).isEqualTo(15_200);
    }
}

package domain.payment;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PaymentGroupTest {

    @Test
    @DisplayName("카드 결제 선택")
    void get_creditCardPayment() {
        assertThat(PaymentGroup.get(1)).isInstanceOf(CreditCardPayment.class);
    }

    @Test
    @DisplayName("현금 결제 선택")
    void get_cashPayment() {
        assertThat(PaymentGroup.get(2)).isInstanceOf(CashPayment.class);
    }

    @Test
    @DisplayName("유효하지 않은 결제 방식 선택")
    void get_invalidPaymentType() {
        assertThatThrownBy(() -> PaymentGroup.get(3))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("존재하지 않는 결제 방식입니다.");
    }
}

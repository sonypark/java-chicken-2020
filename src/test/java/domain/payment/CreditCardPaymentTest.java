package domain.payment;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CreditCardPaymentTest {

    @Test
    @DisplayName("카드 결제 시 할인 없음")
    void pay() {
        //given
        double expected = 16_000;
        //when & then
        assertThat(new CreditCardPayment().pay(16_000)).isEqualTo(expected);
    }
}

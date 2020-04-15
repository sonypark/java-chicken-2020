package domain.payment;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CashPaymentTest {

    @Test
    @DisplayName("현금 결제 시 95% 할인")
    void pay() {
        //given
        double expected = 15_200;
        // when & then
        assertThat(new CashPayment().pay(16_000)).isEqualTo(expected);
    }
}

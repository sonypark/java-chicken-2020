package domain.menu;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CategoryTest {

    @Test
    @DisplayName("카테고리가 치킨이면 true 리턴")
    void isChicken() {
        // given
        Category chicken = Category.CHICKEN;
        //when & then
        assertThat(chicken.isChicken()).isTrue();
    }
}

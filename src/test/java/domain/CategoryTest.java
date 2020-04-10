package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CategoryTest {

    @Test
    @DisplayName("카테고리 생성자 테스트")
    void constructor() {
        assertThat(Category.CHICKEN).isInstanceOf(Category.class);
    }

    @Test
    @DisplayName("카테고리에 치킨,음료만 있는지 확인")
    void values() {
        assertThat(Category.values()).containsOnly(Category.CHICKEN, Category.BEVERAGE);
    }
}

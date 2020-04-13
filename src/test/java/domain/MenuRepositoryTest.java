package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuRepositoryTest {
    private final List<Menu> menus = MenuRepository.menus();
    ;

    @Test
    @DisplayName("메뉴 갯수")
    void menus_size() {
        assertThat(menus.size()).isEqualTo(8);
    }
}

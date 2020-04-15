package domain.menu;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuRepositoryTest {

    @Test
    @DisplayName("메뉴의 갯수는 총 8개")
    void menus() {
        //when & then
        assertThat(MenuRepository.menus().size()).isEqualTo(8);
    }

    @Test
    @DisplayName("메뉴 번호로 메뉴 찾기")
    void findMenuByNumber() {
        //given
        Menu expected = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
        //when & then
        assertThat(MenuRepository.findMenuByNumber(1)).isEqualTo(expected);
    }
}

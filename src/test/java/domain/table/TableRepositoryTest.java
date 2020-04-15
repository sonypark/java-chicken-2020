package domain.table;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.menu.MenuRepository;

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
}

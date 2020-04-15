package domain.table;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}

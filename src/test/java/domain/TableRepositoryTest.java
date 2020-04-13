package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TableRepositoryTest {

    @Test
    @DisplayName("생성자 테스트")
    void constructor() {
        assertThat(new TableRepository()).isInstanceOf(TableRepository.class);
    }

    @Test
    @DisplayName("테이블 갯수")
    void table_size() {
        assertThat(TableRepository.tables().size()).isEqualTo(6);
    }
}

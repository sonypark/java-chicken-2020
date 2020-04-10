package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChickenRestaurantTest {
    private List<Menu> menus = MenuRepository.menus();

    @Test
    @DisplayName("한 카테고리 메뉴를 100개 이상 주문시 예외 발생")
    void addToOrderList() {
        //given
        Menu friedChicken = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
        //when then
        assertThatThrownBy(() -> new ChickenRestaurant().addToOrderList(friedChicken, 1, 100))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("같은 카테고리 메뉴는 99까지만 주문 가능합니다.");
    }

    @Test
    @DisplayName("메뉴 선택")
    void selectMenu() {
        //given
        Menu friedChicken = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
        //when then
        assertThat(new ChickenRestaurant().selectMenu(menus, 1)).isEqualTo(friedChicken);
    }

    @Test
    @DisplayName("주문한 테이블 번호 찾기")
    void findOccupiedTableNumbers() {
        Menu menu = menus.get(0);
        ChickenRestaurant chickenRestaurant = new ChickenRestaurant();
        chickenRestaurant.addToOrderList(menu, 1, 1);
        chickenRestaurant.addToOrderList(menu, 2, 1);

        assertThat(chickenRestaurant.findOccupiedTableNumbers()).containsExactly(1, 2);
    }

    @Test
    @DisplayName("계산할 테이블 찾기")
    void findTableToPay() {
        Menu menu = menus.get(0);
        ChickenRestaurant chickenRestaurant = new ChickenRestaurant();
        chickenRestaurant.addToOrderList(menu, 1, 1);
        OrderMenu orderMenu = new OrderMenu(menu, new Table(1), 1);

        assertThat(chickenRestaurant.findTableToPay(1)).containsExactly(orderMenu);
    }

    @Test
    @DisplayName("결제한 테이블 치우기")
    void emptyPaidTable() {
        //given
        Menu menu = menus.get(0);
        ChickenRestaurant chickenRestaurant = new ChickenRestaurant();
        chickenRestaurant.addToOrderList(menu, 1, 1);
        chickenRestaurant.addToOrderList(menu, 2, 1);
        //when
        chickenRestaurant.emptyPaidTable(1);
        //then
        assertThat(chickenRestaurant.findOccupiedTableNumbers()).containsExactly(2);
    }
}

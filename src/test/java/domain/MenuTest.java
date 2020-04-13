package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MenuTest {
    @Test
    @DisplayName("메뉴 생성자")
    void constructor() {
        assertThat(new Menu(1, "후라이드", Category.CHICKEN, 16_000)).isInstanceOf(Menu.class);
    }

    @Test
    @DisplayName("메뉴가 치킨인 경우 True")
    void isChicken() {
        Menu chicken = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
        assertThat(chicken.isChicken()).isTrue();
    }

    @Test
    @DisplayName("메뉴가 치킨이 아닌 경우 False")
    void isNotChicken() {
        Menu beverage = new Menu(21, "콜라", Category.BEVERAGE, 1_000);
        assertThat(beverage.isChicken()).isFalse();
    }

    @ParameterizedTest
    @DisplayName("같은 메뉴인지 체크")
    @MethodSource("provideMenuWithMenuNumber")
    void isSameNumber(Menu menu, int number, boolean expected) {
        assertThat(menu.isSameNumber(number)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideMenuWithMenuNumber() {
        return Stream.of(
            Arguments.arguments(new Menu(1, "후라이드", Category.CHICKEN, 16_000), 1, true),
            Arguments.arguments(new Menu(1, "후라이드", Category.CHICKEN, 16_000), 2, false),
            Arguments.arguments(new Menu(2, "양념치킨", Category.CHICKEN, 16_000), 2, true),
            Arguments.arguments(new Menu(2, "양념치킨", Category.CHICKEN, 16_000), 1, false),
            Arguments.arguments(new Menu(3, "반반치킨", Category.CHICKEN, 16_000), 3, true),
            Arguments.arguments(new Menu(3, "반반치킨", Category.CHICKEN, 16_000), 2, false),
            Arguments.arguments(new Menu(4, "통구이", Category.CHICKEN, 16_000), 4, true),
            Arguments.arguments(new Menu(4, "통구이", Category.CHICKEN, 16_000), 3, false),
            Arguments.arguments(new Menu(5, "간장치킨", Category.CHICKEN, 17_000), 5, true),
            Arguments.arguments(new Menu(5, "간장치킨", Category.CHICKEN, 17_000), 6, false),
            Arguments.arguments(new Menu(6, "순살치킨", Category.CHICKEN, 17_000), 6, true),
            Arguments.arguments(new Menu(6, "순살치킨", Category.CHICKEN, 17_000), 7, false),
            Arguments.arguments(new Menu(21, "콜라", Category.BEVERAGE, 1_000), 21, true),
            Arguments.arguments(new Menu(21, "콜라", Category.BEVERAGE, 1_000), 22, false),
            Arguments.arguments(new Menu(22, "사이다", Category.BEVERAGE, 1_000), 22, true),
            Arguments.arguments(new Menu(22, "사이다", Category.BEVERAGE, 1_000), 21, false)
        );
    }

    @ParameterizedTest
    @DisplayName("같은 카테고리인지 체크")
    @MethodSource("provideMenuWithCategory")
    void isSameCategory(Menu menu, Category category, boolean expected) {
        assertThat(menu.isSameCategory(category)).isEqualTo(expected);

    }

    private static Stream<Arguments> provideMenuWithCategory() {
        return Stream.of(
            Arguments.arguments(new Menu(1, "후라이드", Category.CHICKEN, 16_000), Category.CHICKEN, true),
            Arguments.arguments(new Menu(1, "후라이드", Category.CHICKEN, 16_000), Category.BEVERAGE, false),
            Arguments.arguments(new Menu(2, "양념치킨", Category.CHICKEN, 16_000), Category.CHICKEN, true),
            Arguments.arguments(new Menu(2, "양념치킨", Category.CHICKEN, 16_000), Category.BEVERAGE, false),
            Arguments.arguments(new Menu(3, "반반치킨", Category.CHICKEN, 16_000), Category.CHICKEN, true),
            Arguments.arguments(new Menu(3, "반반치킨", Category.CHICKEN, 16_000), Category.BEVERAGE, false),
            Arguments.arguments(new Menu(4, "통구이", Category.CHICKEN, 16_000), Category.CHICKEN, true),
            Arguments.arguments(new Menu(4, "통구이", Category.CHICKEN, 16_000), Category.BEVERAGE, false),
            Arguments.arguments(new Menu(5, "간장치킨", Category.CHICKEN, 17_000), Category.CHICKEN, true),
            Arguments.arguments(new Menu(5, "간장치킨", Category.CHICKEN, 17_000), Category.BEVERAGE, false),
            Arguments.arguments(new Menu(6, "순살치킨", Category.CHICKEN, 17_000), Category.CHICKEN, true),
            Arguments.arguments(new Menu(6, "순살치킨", Category.CHICKEN, 17_000), Category.BEVERAGE, false),
            Arguments.arguments(new Menu(21, "콜라", Category.BEVERAGE, 1_000), Category.BEVERAGE, true),
            Arguments.arguments(new Menu(21, "콜라", Category.BEVERAGE, 1_000), Category.CHICKEN, false),
            Arguments.arguments(new Menu(22, "사이다", Category.BEVERAGE, 1_000), Category.BEVERAGE, true),
            Arguments.arguments(new Menu(22, "사이다", Category.BEVERAGE, 1_000), Category.CHICKEN, false)
        );
    }

    @ParameterizedTest
    @DisplayName("메뉴 객체 비교")
    @MethodSource("provideMenu")
    void equals(Menu menu1, Menu menu2, boolean expected) {
        assertThat(menu1.equals(menu2)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideMenu() {
        Menu friedChicken = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
        return Stream.of(
            Arguments.arguments(friedChicken, friedChicken, true),
            Arguments.arguments(new Menu(1, "후라이드", Category.CHICKEN, 16_000),
                new Menu(1, "후라이드", Category.CHICKEN, 16_000), true),
            Arguments.arguments(new Menu(1, "후라이드", Category.CHICKEN, 16_000),
                new Menu(1, "후라이드", Category.CHICKEN, 16_000), true),
            Arguments.arguments(new Menu(1, "후라이드", Category.CHICKEN, 10_000),
                new Menu(2, "양념치킨", Category.CHICKEN, 16_000), false),
            Arguments.arguments(new Menu(2, "양념치킨", Category.CHICKEN, 16_000),
                new Menu(2, "양념치킨", Category.CHICKEN, 16_000), true),
            Arguments.arguments(new Menu(3, "반반치킨", Category.CHICKEN, 16_000),
                new Menu(3, "반반치킨", Category.CHICKEN, 16_000), true),
            Arguments.arguments(new Menu(4, "통구이", Category.CHICKEN, 16_000),
                new Menu(4, "통구이", Category.CHICKEN, 16_000), true),
            Arguments.arguments(new Menu(5, "간장치킨", Category.CHICKEN, 17_000),
                new Menu(5, "간장치킨", Category.CHICKEN, 17_000), true),
            Arguments.arguments(new Menu(6, "순살치킨", Category.CHICKEN, 17_000),
                new Menu(6, "순살치킨", Category.CHICKEN, 17_000), true),
            Arguments.arguments(new Menu(21, "콜라", Category.BEVERAGE, 1_000),
                new Menu(21, "콜라", Category.BEVERAGE, 1_000), true),
            Arguments.arguments(new Menu(21, "콜라", Category.BEVERAGE, 1_000),
                new Menu(22, "사이다", Category.BEVERAGE, 1_000), false),
            Arguments.arguments(new Menu(22, "사이다", Category.BEVERAGE, 1_000),
                new Menu(22, "사이다", Category.BEVERAGE, 1_000), true),
            Arguments.arguments(new Menu(22, "사이다", Category.BEVERAGE, 1_000),
                new Menu(6, "순살치킨", Category.CHICKEN, 17_000), false)
        );
    }

    @Test
    @DisplayName("객체의 해시값 같은지 체크")
    void hashCode_test() {
        //given
        Menu friedChicken = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
        HashMap<Menu, Integer> menuCount = new HashMap<>();
        //when
        menuCount.put(friedChicken, 1);
        //then
        assertThat(menuCount.get(new Menu(1, "후라이드", Category.CHICKEN, 16_000))).isEqualTo(1);
    }
}

package view;

import java.util.Collection;
import java.util.List;

import domain.menu.Menu;
import domain.order.Order;
import domain.table.Table;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String ORDER_BOTTOM_LINE = "└ ₩ ┘";
    private static final String MAIN_SCREEN_LIST = "## 메인화면\n1 - 주문등록\n2 - 결제하기\n3 - 프로그램 종료\n";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printTableBottomLine(tables);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    private static void printTableBottomLine(final List<Table> tables) {
        for (final Table table : tables) {
            if (table.hasOrder()) {
                System.out.print(ORDER_BOTTOM_LINE);
                continue;
            }
            System.out.print(BOTTOM_LINE);
        }
        System.out.println();
    }

    public static void printMainScreen() {
        System.out.println(MAIN_SCREEN_LIST);
    }

    public static void printOrderList(Collection<Order> orderMenuList) {
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");
        orderMenuList.forEach(
            order -> System.out.println(
                order.getMenu().getName() + " " + order.getQuantity() + " " + (int)order.price()));
    }

    public static void printPaymentTableNumber(int tableNumber) {
        System.out.println(tableNumber + "번 테이블의 결제를 진행합니다.");
    }

    public static void printPaymentResult(double payment) {
        System.out.println("최종 결제한 금액은 " + (int)payment + "원 입니다.");
    }
}

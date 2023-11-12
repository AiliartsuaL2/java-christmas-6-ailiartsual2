package christmas.views;

import christmas.domain.Order;
import christmas.domain.User;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class OutputView {
    private enum OutputPhrases {
        BASIC_OUTPUT_GREET("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
        BASIC_OUTPUT_VISIT_DAY("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
        BASIC_OUTPUT_ORDERS_MENU("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
        BASIC_OUTPUT_PRE_VIEW("에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
        VISIT_MONTH("12월 "),
        ORDERS_MENU_BANNER("<주문 메뉴>"),
        NOT_DISCOUNTED_PRICE_BANNER("<할인 전 총주문 금액>"),
        MENU_BANNER("<증정 메뉴>"),
        BENEFIT_BANNER("<혜택 내역>"),
        TOTAL_BENEFIT_BANNER("<총혜택 금액>"),
        EXPECT_PAYMENT_BANNER("<할인 후 예상 결제 금액>"),
        EVENT_BADGE_BANNER("<12월 이벤트 배지>");

        private final String message;

        OutputPhrases(String message) {
            this.message = message;
        }
    }

    public void showBasicOutPutGreet() {
        System.out.println(OutputPhrases.BASIC_OUTPUT_GREET.message);
    }

    public void showBasicOutPutVisitDay() {
        System.out.println(OutputPhrases.BASIC_OUTPUT_VISIT_DAY.message);
    }

    public void showBasicOutPutOrders() {
        System.out.println(OutputPhrases.BASIC_OUTPUT_ORDERS_MENU.message);
    }

    public void showVisitDay(int day) {
        String visitDateToKorean = visitDateToKorean(day);
        System.out.println(visitDateToKorean + OutputPhrases.BASIC_OUTPUT_PRE_VIEW.message);
    }

    public void showTotalOrdersInfo(User user) {
        showVisitDay(user.getVisitDate().getDay());
        showMenu(user.getOrders());
    }

    private void showMenu(List<Order> orders) {
        for (Order order : orders) {
            String menuName = order.getMenu().getName();
            int count = order.getCount();
            System.out.println(menuName + " " + count+"개");
        }
    }

    private String visitDateToKorean(int day) {
        return OutputPhrases.VISIT_MONTH.message + day + "일";
    }
}

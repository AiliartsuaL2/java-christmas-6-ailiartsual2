package christmas.domain;

import static org.assertj.core.api.Assertions.*;

import christmas.global.ErrorMessage;
import java.util.List;
import org.junit.jupiter.api.Test;

class OrderTest {
    @Test
    void 생성_테스트() {
        //given
        String inputOrders = "시저샐러드-3,티본스테이크-5";

        //when
        List<Order> orders = Order.get(inputOrders);

        //then
        assertThat(orders.size()).isEqualTo(2);
    }

    @Test
    void 음료만_주문_시_주문_생성_불가능() {
        //given
        String inputOrders = "제로콜라-5";

        //when
        //then
        assertThatThrownBy(() -> Order.get(inputOrders))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(ErrorMessage.INPUT_ORDER_VALIDATION_EXCEPTION.getMessage());
    }

    @Test
    void 주문_총_개수가_20개_초과_인_경우_생성_불가능() {
        //given
        String inputOrders = "티본스테이크-5,시저샐러드-16";

        //when
        //then
        assertThatThrownBy(() -> Order.get(inputOrders))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(ErrorMessage.INPUT_ORDER_VALIDATION_EXCEPTION.getMessage());
    }

    @Test
    void 메뉴_개수가_0_인_경우_생성_불가능() {
        //given
        String inputOrders = "티본스테이크-0,아이스크림-0";

        //when
        //then
        assertThatThrownBy(() -> Order.get(inputOrders))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INPUT_ORDER_VALIDATION_EXCEPTION.getMessage());
    }

    @Test
    void 중복_메뉴_주문의_경우_생성_불가능() {
        //given
        String inputOrders = "티본스테이크-5,티본스테이크-10";

        //when
        //then
        assertThatThrownBy(() -> Order.get(inputOrders))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(ErrorMessage.INPUT_ORDER_VALIDATION_EXCEPTION.getMessage());
    }

    @Test
    void 할인_금액_조회_주말_인_경우_메인_할인() {
        //given
        String inputOrders = "티본스테이크-5,아이스크림-10";
        int mainCount = 5;
        int dessertCount = 10;

        int dayDiscountAmount = 2023;
        boolean isWeekend = true;

        int expectDayDiscountPrice = mainCount * dayDiscountAmount;

        //when
        List<Order> orders = Order.get(inputOrders);

        int dayDiscountPrice = 0;
        for (Order order : orders) {
            dayDiscountPrice += order.getDayDiscountedPrice(isWeekend);
        }

        //then
        assertThat(dayDiscountPrice).isEqualTo(expectDayDiscountPrice);
    }

    @Test
    void 할인_금액_조회_평일_인_경우_디저트_할인() {
        //given
        String inputOrders = "티본스테이크-5,아이스크림-10";
        int mainCount = 5;
        int dessertCount = 10;

        int dayDiscountAmount = 2023;
        boolean isWeekend = false;

        int expectDayDiscountPrice = dessertCount * dayDiscountAmount;

        //when
        List<Order> orders = Order.get(inputOrders);

        int dayDiscountPrice = 0;
        for (Order order : orders) {
            dayDiscountPrice += order.getDayDiscountedPrice(isWeekend);
        }

        //then
        assertThat(dayDiscountPrice).isEqualTo(expectDayDiscountPrice);
    }

    @Test
    void 할인_금액_조회_평일_디저트_주문을_하지_않은_경우() {
        //given
        String inputOrders = "티본스테이크-5,시저샐러드-10";
        int mainCount = 5;
        int dessertCount = 0;

        int dayDiscountAmount = 2023;
        boolean isWeekend = false;

        int expectDayDiscountPrice = dessertCount * dayDiscountAmount;

        //when
        List<Order> orders = Order.get(inputOrders);

        int dayDiscountPrice = 0;
        for (Order order : orders) {
            dayDiscountPrice += order.getDayDiscountedPrice(isWeekend);
        }

        //then
        assertThat(dayDiscountPrice).isEqualTo(expectDayDiscountPrice);
    }

    @Test
    void 할인_금액_조회_주말_메인_주문을_하지_않은_경우() {
        //given
        String inputOrders = "시저샐러드-5,아이스크림-10";
        int mainCount = 0;
        int dessertCount = 10;

        int dayDiscountAmount = 2023;
        boolean isWeekend = true;

        int expectDayDiscountPrice = mainCount * dayDiscountAmount;

        //when
        List<Order> orders = Order.get(inputOrders);

        int dayDiscountPrice = 0;
        for (Order order : orders) {
            dayDiscountPrice += order.getDayDiscountedPrice(isWeekend);
        }

        //then
        assertThat(dayDiscountPrice).isEqualTo(expectDayDiscountPrice);
    }

    @Test
    void 할인되지_않은_금액_조회() {
        //given
        String inputOrders = "시저샐러드-5,아이스크림-10";
        int saladPrice = Menu.CAESAR_SALAD.getPrice();
        int iceCreamPrice = Menu.ICE_CREAM.getPrice();

        int saladCount = 5;
        int iceCreamCount = 10;

        int expectNotDiscountedTotalPrice = saladPrice * saladCount + iceCreamPrice * iceCreamCount;

        //when
        List<Order> orders = Order.get(inputOrders);

        int notDiscountedTotalPrice = 0;
        for (Order order : orders) {
            notDiscountedTotalPrice += order.notDiscountedPrice();
        }

        //then
        assertThat(notDiscountedTotalPrice).isEqualTo(expectNotDiscountedTotalPrice);
    }
}

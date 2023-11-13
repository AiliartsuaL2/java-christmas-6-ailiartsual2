package christmas.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BillTest {
    List<Order> orders;
    VisitDate visitDate;
    Bill bill;

    @BeforeEach
    void init() {
        String inputOrders = "티본스테이크-1,양송이수프-3,해산물파스타-2,아이스크림-1,레드와인-3";
        String inputDay = "16";
        orders = Order.get(inputOrders);
        visitDate = VisitDate.get(inputDay);
        bill = Bill.create(visitDate, orders);
    }

    @Test
    void Bill_생성_테스트() {
        //given
        //when
        Bill bill = Bill.create(visitDate, orders);

        //then
        assertThat(bill).isNotNull();
    }

    @Test
    void Bill_총_주문_금액_정상_케이스() {
        //given
        int totalPrice = 328000;

        //when
        int totalOrdersPrice = bill.getTotalOrdersPrice();

        //then
        assertThat(totalOrdersPrice).isEqualTo(totalPrice);
    }

    @Test
    void Bill_크리스마스_할인_금액_정상_케이스() {
        //given
        int expectChristmasDiscount = ((visitDate.getDay()-1) * 100) + 1000;

        //when
        int christmasDiscount = bill.getChristmasDiscount();

        //then
        assertThat(christmasDiscount).isEqualTo(expectChristmasDiscount);
    }

    @Test
    void Bill_평일_주말_할인_금액_정상_케이스() {
        //given
        int mainMenuCount = 3;
        int expectDayDiscount = 2023 * mainMenuCount;

        //when
        int dayDiscount = bill.getDayDiscount();

        //then
        assertThat(dayDiscount).isEqualTo(expectDayDiscount);
    }

    @Test
    void Bill_특별_할인_정상_케이스() {
        //given
        boolean isSpecialDay = visitDate.isSpecialDay();
        int expectSpecialDiscount = isSpecialDay ? 1000 : 0;

        //when
        int specialDiscount = bill.getSpecialDiscount();

        //then
        assertThat(specialDiscount).isEqualTo(expectSpecialDiscount);
    }

    @Test
    void Bill_총_혜택_금액_정상_케이스() {
        //given
        int expectChristmasDiscount = ((visitDate.getDay()-1) * 100) + 1000;

        boolean isSpecialDay = visitDate.isSpecialDay();
        int expectSpecialDiscount = isSpecialDay ? 1000 : 0;

        int mainMenuCount = 3;
        int expectDayDiscount = 2023 * mainMenuCount;

        int totalPrice = 328000;
        int expectPresentPrice = totalPrice >= Bill.MINIMUM_PRESENT_AMOUNT ? 25000 : 0;

        int expectTotalBenefitAmount = expectChristmasDiscount + expectSpecialDiscount + expectDayDiscount + expectPresentPrice;

        //when
        int totalBenefitAmount = bill.getTotalBenefitAmount();

        //then
        assertThat(totalBenefitAmount).isEqualTo(expectTotalBenefitAmount);
    }

    @Test
    void Bill_최종_결제_금액_정상_케이스() {
        //given
        int totalPrice = 328000;

        int expectChristmasDiscount = ((visitDate.getDay()-1) * 100) + 1000;

        boolean isSpecialDay = visitDate.isSpecialDay();
        int expectSpecialDiscount = isSpecialDay ? 1000 : 0;

        int mainMenuCount = 3;
        int expectDayDiscount = 2023 * mainMenuCount;

        int expectTotalBenefitAmount = expectChristmasDiscount + expectSpecialDiscount + expectDayDiscount;
        int expectFinalAmount = totalPrice - expectTotalBenefitAmount;

        //when
        int finalAmount = bill.getFinalAmount();

        //then
        assertThat(finalAmount).isEqualTo(expectFinalAmount);
    }
}

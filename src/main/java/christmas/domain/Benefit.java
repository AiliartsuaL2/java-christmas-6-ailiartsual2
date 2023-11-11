package christmas.domain;

import java.util.List;

public class Benefit {
    public static final int DISCOUNT_AMOUNT = 2023;
    public static final int MINIMUM_PRESENT_AMOUNT = 120000;
    private final int christmasDiscount;
    private final int dayDiscount;
    private final int specialDiscount;
    private final boolean isPresent;

    public Benefit(int christmasDiscount, int dayDiscount, int specialDiscount, boolean isPresent) {
        this.christmasDiscount = christmasDiscount;
        this.dayDiscount = dayDiscount;
        this.specialDiscount = specialDiscount;
        this.isPresent = isPresent;
    }
    public static Benefit create(VisitDate visitDate, List<Order> orders) {
        int christmasDiscount = calculateChristmasDiscount(visitDate.getDay());
        int dayDiscount = calculateDayDiscount(visitDate.isWeekend(), orders);
        int specialDiscount = calculateSpecialDiscount(visitDate.isSpecialDay());
        boolean isPresent = checkIsPresent(orders);
        return new Benefit(christmasDiscount, dayDiscount, specialDiscount, isPresent);
    }

    private static int calculateChristmasDiscount(int day) {
        if(day > 25) {
            return 0;
        }
        int christmasDiscount = 1000;
        return christmasDiscount + (day-1) * 100;
    }

    private static int calculateDayDiscount(boolean isWeekend, List<Order> orders) {
        int dayDiscount = 0;
        for (Order order : orders) {
            dayDiscount += order.getDayDiscountedPrice(isWeekend);
        }
        return dayDiscount;
    }

    private static int calculateSpecialDiscount(boolean isSpecialDay) {
        if(isSpecialDay) {
            return 1000;
        }
        return 0;
    }

    private static boolean checkIsPresent(List<Order> orders) {
        int totalOrdersPrice = 0;
        for (Order order : orders) {
            totalOrdersPrice += order.notDiscountedPrice();
        }
        if(totalOrdersPrice > MINIMUM_PRESENT_AMOUNT) {
            return true;
        }
        return false;
    }
}

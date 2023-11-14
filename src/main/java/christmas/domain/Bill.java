package christmas.domain;

import java.util.List;

public class Bill {
    public static final int DISCOUNT_AMOUNT = 2023;
    public static final int MINIMUM_PRESENT_AMOUNT = 120000;
    public static final int MINIMUM_BENEFIT_AMOUNT = 10000;

    private final int christmasDiscount;
    private final int dayDiscount;
    private final int specialDiscount;
    private final List<Order> orders;

    public Bill(int christmasDiscount, int dayDiscount, int specialDiscount, List<Order> orders) {
        this.orders = orders;
        this.christmasDiscount = christmasDiscount;
        this.dayDiscount = dayDiscount;
        this.specialDiscount = specialDiscount;
    }

    public int getFinalAmount() {
        int finalAmount = getTotalPrice(this.orders);
        finalAmount -= this.christmasDiscount;
        finalAmount -= this.dayDiscount;
        finalAmount -= this.specialDiscount;
        return finalAmount;
    }

    public int getChristmasDiscount() {
        return christmasDiscount;
    }

    public int getDayDiscount() {
        return dayDiscount;
    }

    public int getSpecialDiscount() {
        return specialDiscount;
    }

    public int getTotalOrdersPrice() {
        return getTotalPrice(this.orders);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public static Bill create(VisitDate visitDate, List<Order> orders) {
        if(getTotalPrice(orders) < MINIMUM_BENEFIT_AMOUNT) {
            return new Bill(0,0,0,orders);
        }

        int christmasDiscount = calculateChristmasDiscount(visitDate.getDay());
        int dayDiscount = calculateDayDiscount(visitDate.isWeekend(), orders);
        int specialDiscount = calculateSpecialDiscount(visitDate.isSpecialDay());
        return new Bill(christmasDiscount, dayDiscount, specialDiscount, orders);
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

    private static int getTotalPrice(List<Order> orders) {
        int totalOrdersPrice = 0;
        for (Order order : orders) {
            totalOrdersPrice += order.notDiscountedPrice();
        }
        return totalOrdersPrice;
    }

    public int getTotalBenefitAmount() {
        int totalBenefitAmount = 0;
        totalBenefitAmount = this.christmasDiscount + this.dayDiscount + this.specialDiscount;
        if(getTotalPrice(this.orders) >= MINIMUM_PRESENT_AMOUNT) {
            totalBenefitAmount += 25000;
        }
        return totalBenefitAmount;
    }
}

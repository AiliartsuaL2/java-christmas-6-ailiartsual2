package christmas.domain;

public class Discount {
    private final int christmasDiscount;
    private final int dayDiscount;
    private final int specialDiscount;
    private final boolean isPresent;

    public Discount(int christmasDiscount, int dayDiscount, int specialDiscount, boolean isPresent) {
        this.christmasDiscount = christmasDiscount;
        this.dayDiscount = dayDiscount;
        this.specialDiscount = specialDiscount;
        this.isPresent = isPresent;
    }
}

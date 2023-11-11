package christmas.domain;

import java.util.List;

public class User {
    private final VisitDate visitDate;
    private final List<Order> orders;
    private final Discount discount;
    private final EventBadge eventBadge;

    public User(VisitDate visitDate, List<Order> orders, Discount discount, EventBadge eventBadge) {
        this.visitDate = visitDate;
        this.orders = orders;
        this.discount = discount;
        this.eventBadge = eventBadge;
    }
}

package christmas.domain;

import java.util.List;

public class User {
    private final VisitDate visitDate;
    private final List<Order> orders;
    private final Benefit benefit;
    private final EventBadge eventBadge;

    public User(VisitDate visitDate, List<Order> orders, Benefit benefit, EventBadge eventBadge) {
        this.visitDate = visitDate;
        this.orders = orders;
        this.benefit = benefit;
        this.eventBadge = eventBadge;
    }
}

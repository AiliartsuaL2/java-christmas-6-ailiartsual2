package christmas.domain;

import java.util.List;

public class User {
    private final String name;
    private final VisitDate visitDate;
    private final List<Order> orders;
    private final Discount discount;
    private final EventBadge eventBadge;

    public User(String name, VisitDate visitDate, List<Order> orders, Discount discount, EventBadge eventBadge) {
        this.name = name;
        this.visitDate = visitDate;
        this.orders = orders;
        this.discount = discount;
        this.eventBadge = eventBadge;
    }
}

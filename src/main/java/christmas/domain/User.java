package christmas.domain;

import java.util.List;

public class User {
    private final VisitDate visitDate;
    private final List<Order> orders;
    private final Bill bill;
    private final EventBadge eventBadge;

    public User(VisitDate visitDate, List<Order> orders, Bill bill) {
        this.visitDate = visitDate;
        this.orders = orders;
        this.bill = bill;
        this.eventBadge = EventBadge.create(bill.getTotalBenefitAmount());
    }
}

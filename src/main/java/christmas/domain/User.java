package christmas.domain;

public class User {
    private final VisitDate visitDate;
    private final Bill bill;
    private final EventBadge eventBadge;

    public User(VisitDate visitDate, Bill bill) {
        this.visitDate = visitDate;
        this.bill = bill;
        this.eventBadge = EventBadge.create(bill.getTotalBenefitAmount());
    }

    public VisitDate getVisitDate() {
        return visitDate;
    }

    public Bill getBill() {
        return bill;
    }

    public EventBadge getEventBadge() {
        return eventBadge;
    }
}

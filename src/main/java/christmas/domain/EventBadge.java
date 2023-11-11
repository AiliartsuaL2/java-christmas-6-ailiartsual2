package christmas.domain;

import java.util.Optional;

public enum EventBadge {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    private final String name;
    private final int minimumPrice;

    EventBadge(String name, int minimumPrice) {
        this.name = name;
        this.minimumPrice = minimumPrice;
    }

    public static Optional<EventBadge> getEventBadge(int totalBenefitAmount) {
        if(totalBenefitAmount >= SANTA.minimumPrice) {
            return Optional.ofNullable(SANTA);
        } if(totalBenefitAmount >= TREE.minimumPrice) {
            return Optional.ofNullable(TREE);
        } if(totalBenefitAmount >= STAR.minimumPrice) {
            return Optional.ofNullable(STAR);
        } return Optional.empty();
    }
}

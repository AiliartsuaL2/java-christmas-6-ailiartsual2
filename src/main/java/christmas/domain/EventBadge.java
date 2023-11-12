package christmas.domain;


public enum EventBadge {
    NOT_EXIST("없음",0),
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    private final String name;
    private final int minimumPrice;

    EventBadge(String name, int minimumPrice) {
        this.name = name;
        this.minimumPrice = minimumPrice;
    }

    public static EventBadge create(int totalBenefitAmount) {
        if(totalBenefitAmount >= SANTA.minimumPrice) {
            return SANTA;
        } if(totalBenefitAmount >= TREE.minimumPrice) {
            return TREE;
        } if(totalBenefitAmount >= STAR.minimumPrice) {
            return STAR;
        } return NOT_EXIST;
    }
}

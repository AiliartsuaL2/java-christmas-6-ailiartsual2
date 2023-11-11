package christmas.domain;

public enum CourseType {
    APPETIZER("에피타이저"),
    MAIN("메인"),
    DESSERT("디저트"),
    BEVERAGE("음료");

    private final String name;

    CourseType(String name) {
        this.name = name;
    }
}

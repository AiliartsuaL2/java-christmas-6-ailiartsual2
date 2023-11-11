package christmas.domain;

import java.util.Optional;

public enum Menu {
    MUSHROOM_SOUP(CourseType.APPETIZER, "양송이수프", 6000),
    TAPAS(CourseType.APPETIZER, "타파스", 5500),
    CAESAR_SALAD(CourseType.APPETIZER, "시저샐러드", 8000),
    T_BONE_STEAK(CourseType.MAIN, "티본스테이크", 55000),
    BARBECUE_RIBS(CourseType.MAIN, "바베큐립", 54000),
    SEA_FOOD_PASTA(CourseType.MAIN, "해산물파스타", 35000),
    CHRISTMAS_PASTA(CourseType.MAIN, "크리스마스파스타", 25000),
    CHOCOLATE_CAKE(CourseType.DESSERT, "초코케이크", 15000),
    ICE_CREAM(CourseType.DESSERT, "아이스크림", 5000),
    ZERO_COKE(CourseType.BEVERAGE, "제로콜라", 3000),
    RED_WINE(CourseType.BEVERAGE, "레드와인", 60000),
    CHAMPAGNE(CourseType.BEVERAGE, "샴페인", 25000);

    private final CourseType courseType;
    private final String name;
    private final int price;

    Menu(CourseType courseType, String name, int price) {
        this.courseType = courseType;
        this.name = name;
        this.price = price;
    }

    public static Optional<Menu> findMenuByName(String name) {
        for (Menu menu : Menu.values()) {
            if(menu.name.equals(name)) {
                return Optional.ofNullable(menu);
            }
        }
        return Optional.empty();
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

package christmas.domain;

import christmas.global.ErrorMessage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Order {
    private static final Pattern ORDER_COUNT_REGEX = Pattern.compile("^[1-9]\\d*$");

    private final Menu menu;
    private final int count;

    public Order(Menu menu, int count) {
        this.menu = menu;
        this.count = count;
    }

    public static List<Order> get(String inputOrders) {
        List<Order> orders = new ArrayList<>();
        String[] inputOrdersInfo = inputOrders.split(",");

        for (String inputOrderInfo : inputOrdersInfo) {
            String[] orderInfo = getOrderInfo(inputOrderInfo);
            String menuName = orderInfo[0];
            int count = getCount(orderInfo[1]);

            Order order = create(menuName, count);
            orders.add(order);
        }

        orderCheck(orders);
        return orders;
    }

    public int getDayDiscountedPrice(boolean isWeekend) {
        int orderPrice = (this.menu.getPrice() * this.count);
        if(isWeekend) {
            // 주말이면 MAIN 할인
            if(CourseType.MAIN.equals(this.menu.getCourseType())) {
                return orderPrice - Benefit.DISCOUNT_AMOUNT;
            }
            return orderPrice;
        }
        // 평일이면 디저트 할인
        if(CourseType.DESSERT.equals(this.menu.getCourseType())) {
            return orderPrice - Benefit.DISCOUNT_AMOUNT;
        }
        return orderPrice;
    }

    public int notDiscountedPrice() {
        return this.menu.getPrice() * count;
    }

    private static String[] getOrderInfo(String inputOrderInfo) {
        String[] orderInfo = inputOrderInfo.split("-");
        if (orderInfo.length != 2) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ORDER_VALIDATION_EXCEPTION.getMessage());
        }
        return orderInfo;
    }

    private static Order create(String menuName, int count) {
        Menu menu = Menu.findMenuByName(menuName).orElseThrow(
                () -> new IllegalArgumentException(ErrorMessage.INPUT_ORDER_VALIDATION_EXCEPTION.getMessage()));
        return new Order(menu, count);
    }

    private static int getCount(String readCount) {
        if(!ORDER_COUNT_REGEX.matcher(readCount).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ORDER_VALIDATION_EXCEPTION.getMessage());
        }
        int count = Integer.parseInt(readCount);
        return count;
    }

    private static void orderCheck(List<Order> orders) {
        if(orders.size() > 20) {
            throw new IllegalStateException(ErrorMessage.INPUT_ORDER_VALIDATION_EXCEPTION.getMessage());
        }

        Set<String> menuNames = new HashSet<>();
        for (Order order : orders) {
            menuNames.add(order.menu.getName());
        }
        if(menuNames.size() != orders.size()) {
            throw new IllegalStateException(ErrorMessage.INPUT_ORDER_VALIDATION_EXCEPTION.getMessage());
        }
    }
}

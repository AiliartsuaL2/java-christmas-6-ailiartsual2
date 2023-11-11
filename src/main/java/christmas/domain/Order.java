package christmas.domain;

import christmas.global.ErrorMessage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Order {
    private static final Pattern ORDER_COUNT_REGEX = Pattern.compile("");

    private final Menu menu;
    private final int count;

    public Order(Menu menu, int count) {
        this.menu = menu;
        this.count = count;
    }

    public static List<Order> get(String readOrders) {
        List<Order> createdOrders = new ArrayList<>();
        String[] readOrder = readOrders.split(",");

        for (String order : readOrder) {
            String[] orderInfo = order.split("-");
            String menuName = orderInfo[0];
            int count = getCount(orderInfo[1]);

            Order createdOrder = create(menuName, count);
            createdOrders.add(createdOrder);
        }

        orderCheck(createdOrders);
        return createdOrders;
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
        if(count < 1) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ORDER_VALIDATION_EXCEPTION.getMessage());
        }
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

package christmas.views;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Order;
import christmas.domain.VisitDate;
import java.util.List;

public class InputView {
    public VisitDate readVisitDay() {
        String readDay = Console.readLine();
        return VisitDate.get(readDay);
    }

    public List<Order> readOrders() {
        String readOrders = Console.readLine();
        return Order.get(readOrders);
    }
}

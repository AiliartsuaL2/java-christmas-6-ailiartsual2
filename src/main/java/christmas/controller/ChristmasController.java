package christmas.controller;

import christmas.domain.Bill;
import christmas.domain.Order;
import christmas.domain.User;
import christmas.domain.VisitDate;
import christmas.global.ExceptionHandler;
import christmas.views.InputView;
import java.util.List;

public class ChristmasController {
    public ChristmasController(InputView inputView) {
        this.inputView = inputView;
    }

    private final InputView inputView;

    public void run() {
        VisitDate visitDate = ExceptionHandler.input(inputView::readVisitDay);
        List<Order> orders = ExceptionHandler.input(inputView::readOrders);
        Bill bill = Bill.create(visitDate, orders);
        User user = new User(visitDate, orders, bill);

    }
}

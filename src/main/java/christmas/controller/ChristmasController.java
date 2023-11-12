package christmas.controller;

import christmas.domain.Bill;
import christmas.domain.Order;
import christmas.domain.User;
import christmas.domain.VisitDate;
import christmas.global.ExceptionHandler;
import christmas.views.InputView;
import christmas.views.OutputView;
import java.util.List;

public class ChristmasController {
    public ChristmasController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private final InputView inputView;
    private final OutputView outputView;

    public void run() {
        outputView.showBasicOutPutGreet();
        outputView.showBasicOutPutVisitDay();
        VisitDate visitDate = ExceptionHandler.input(inputView::readVisitDay);
        outputView.showBasicOutPutOrders();
        List<Order> orders = ExceptionHandler.input(inputView::readOrders);
        Bill bill = Bill.create(visitDate, orders);
        User user = new User(visitDate, orders, bill);
        outputView.showVisitDay(user.getVisitDate().getDay());
    }
}

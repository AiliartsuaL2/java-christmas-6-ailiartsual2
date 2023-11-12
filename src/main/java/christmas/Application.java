package christmas;

import christmas.controller.ChristmasController;
import christmas.views.InputView;
import christmas.views.OutputView;

public class Application {
    public static void main(String[] args) {
        ChristmasController christmasController = new ChristmasController(new InputView(), new OutputView());
        christmasController.run();
    }
}

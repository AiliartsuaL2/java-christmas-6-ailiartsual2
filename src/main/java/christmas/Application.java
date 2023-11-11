package christmas;

import christmas.controller.ChristmasController;
import christmas.views.InputView;

public class Application {
    public static void main(String[] args) {
        ChristmasController christmasController = new ChristmasController(new InputView());
        christmasController.run();
    }
}

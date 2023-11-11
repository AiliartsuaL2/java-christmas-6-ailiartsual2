package christmas.views;

import camp.nextstep.edu.missionutils.Console;
import christmas.global.ErrorMessage;
import java.util.regex.Pattern;

public class InputView {
    private static Pattern DAY_REGEX = Pattern.compile("^(?:[1-9]|1\\d|2[0-9]|3[0-1])$");

    public int readVisitDay() {
        String readDay = Console.readLine();
        dayValidation(readDay);
        return getDay(readDay);
    }

    public void readOrders() {

    }

    private void dayValidation(String readDay) {
        if(!DAY_REGEX.matcher(readDay).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_DAY_VALIDATION_EXCEPTION.getMessage());
        }
    }

    private int getDay(String readDay) {
        return 0;
    }
}

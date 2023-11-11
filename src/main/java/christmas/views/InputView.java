package christmas.views;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.VisitDate;

public class InputView {

    public VisitDate readVisitDay() {
        String readDay = Console.readLine();
        return VisitDate.getVisitDay(readDay);
    }
}

package christmas.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {
    @Test
    void 회원_생성_테스트() {
        //given
        VisitDate visitDate = VisitDate.get("12");
        List<Order> orders = Order.get("티본스테이크-1,시저샐러드-4");
        Bill bill = Bill.create(visitDate, orders);

        //when
        User user = new User(visitDate, bill);

        //then
        assertThat(user).isNotNull();
    }
}
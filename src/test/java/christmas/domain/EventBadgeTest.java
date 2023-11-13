package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class EventBadgeTest {
    @Test
    void 뱃지_생성_5000원_이상_10000원_미만_시_별_증정() {
        //given
        int totalBenefitAmount = 7500;

        //when
        EventBadge eventBadge = EventBadge.create(totalBenefitAmount);

        //then
        Assertions.assertThat(eventBadge).isEqualTo(EventBadge.STAR);
    }

    @Test
    void 뱃지_생성_10000원_이상_20000원_미만_시_트리_증정() {
        //given
        int totalBenefitAmount = 15000;

        //when
        EventBadge eventBadge = EventBadge.create(totalBenefitAmount);

        //then
        Assertions.assertThat(eventBadge).isEqualTo(EventBadge.TREE);
    }

    @Test
    void 뱃지_생성_20000원_이상_시_산타_증정() {
        //given
        int totalBenefitAmount = 25000;

        //when
        EventBadge eventBadge = EventBadge.create(totalBenefitAmount);

        //then
        Assertions.assertThat(eventBadge).isEqualTo(EventBadge.SANTA);
    }

    @Test
    void 뱃지_생성_5000원_미만_시_미_증정() {
        //given
        int totalBenefitAmount = 4500;

        //when
        EventBadge eventBadge = EventBadge.create(totalBenefitAmount);

        //then
        Assertions.assertThat(eventBadge).isEqualTo(EventBadge.NOT_EXIST);
    }
}

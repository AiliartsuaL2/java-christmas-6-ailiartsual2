package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.global.ErrorMessage;
import org.junit.jupiter.api.Test;

class VisitDateTest {
    @Test
    void 방문_일자_생성_테스트() {
        //given
        String inputDay = "12";

        //when
        VisitDate visitDate = VisitDate.get(inputDay);

        //then
        assertThat(Integer.parseInt(inputDay)).isEqualTo(visitDate.getDay());
    }

    @Test
    void 입력일_31일_이후_입력_시_예외_발생() {
        //given
        String inputDay = "32";

        //when
        //then
        assertThatThrownBy(() -> VisitDate.get(inputDay))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INPUT_DAY_VALIDATION_EXCEPTION.getMessage());
    }

    @Test
    void 입력일_1일_이전_입력_시_예외_발생() {
        //given
        String inputDay = "0";

        //when
        //then
        assertThatThrownBy(() -> VisitDate.get(inputDay))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INPUT_DAY_VALIDATION_EXCEPTION.getMessage());
    }

    @Test
    void 입력일_숫자_외_입력_시_예외_발생() {
        //given
        String inputDay = "a";

        //when
        //then
        assertThatThrownBy(() -> VisitDate.get(inputDay))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INPUT_DAY_VALIDATION_EXCEPTION.getMessage());
    }
}
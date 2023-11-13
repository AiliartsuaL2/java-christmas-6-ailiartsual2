package christmas.domain;

import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MenuTest {
    @Test
    void 존재_메뉴_검색_시_해당_enum() {
        //given
        String menuName = "양송이수프";

        //when
        Optional<Menu> menu = Menu.findMenuByName(menuName);

        //then
        Assertions.assertThat(menu.get()).isEqualTo(Menu.MUSHROOM_SOUP);
    }

    @Test
    void 미_존재_메뉴_이름_검색_시_empty() {
        //given
        String menuName = "양송이수프에요";

        //when
        Optional<Menu> menu = Menu.findMenuByName(menuName);

        //then
        Assertions.assertThat(menu.isEmpty()).isTrue();
    }
}

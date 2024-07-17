import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class SearchGitTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    public void searchGitTest() {
        open("https://github.com/");
        $(byTagAndText("button", "Solutions"))
                .hover();
        $$(".HeaderMenu-dropdown-link")
                .findBy(href("https://github.com/enterprise"))
                .shouldBe(visible)
                .click();
        $("#hero-section-brand-heading")
                .shouldHave(text("The AI-powered developer platform."));

    }
}

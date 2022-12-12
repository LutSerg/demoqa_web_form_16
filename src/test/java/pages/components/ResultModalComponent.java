package pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultModalComponent {
    public void verifyModalAppears() {
        $(".modal-dialog").should(appear);
        $(".modal-header").shouldHave(Condition.text("Thanks for submitting the form"));
    }

    public void verifyResults (String key, String value) {
        $(".table-responsive").$(byText(key))
                .parent().shouldHave(text(value));
    }
}

package pages.Component;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultComponent {
    private final SelenideElement tableInput = $(".table-responsive");
    private final SelenideElement closeNot = $("#example-modal-sizes-title-lg");

    public ResultComponent checkResult(String key, String value) {
        tableInput.$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }

    public ResultComponent closeNot() {
        closeNot.shouldNot(exist);
        return this;
    }
}

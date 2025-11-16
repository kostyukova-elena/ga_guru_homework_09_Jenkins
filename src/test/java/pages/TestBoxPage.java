package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxPage {

    private SelenideElement userNameInput = $("#userName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement currentAddressInput = $("#currentAddress");
    private SelenideElement permanentAddressInput = $("#permanentAddress");
    private SelenideElement submitInput = $("#submit");
    private SelenideElement outputInput = $("#output");

    public TestBoxPage openPage() {
        open("/text-box");
        return this;
    }

    public TestBoxPage setUserName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    public TestBoxPage setEmailName(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TestBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public TestBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public TestBoxPage submitForm() {
        submitInput.click();
        return this;
    }

    public TestBoxPage checkResult(String key, String value) {
        outputInput.$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }
}

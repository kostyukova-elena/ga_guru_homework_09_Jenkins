import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.Component.ResultComponent;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;

@Tag("demoqa")
public class DemoQAPageObjectsTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    ResultComponent resultComponent = new ResultComponent();

    @AfterEach
    void addAttachments(){
        Attach.screenshotAs("Last screenshot");
    }

    @Test
    void demoFormTest() {
        step("Открываем главную страницу", () -> {
            registrationPage.openPage();
        });

        step("Вводим имя пользователя", () -> {
            registrationPage.setFirstName("Sergey");
        });

        registrationPage.setLastName("Redko")
                .setUserEmail("redkoSS@mail.ru")
                .setGender("Male")
                .setPhoneNumber("8345265897")
                .setOfBirth("15", "April", "1990")
                .setSubjects("Maths")
                .setHobbies("Sports")
                .setHobbies("Reading")
                .setPicture("photo_2025.jpg")
                .setCurrentAddress("Russia")
                .setState("Haryana")
                .setCity("Panipat")
                .submitForm();

        resultComponent.checkResult("Student Name", "Sergey Redko")
                .checkResult("Student Email", "redkoSS@mail.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8345265897")
                .checkResult("Date of Birth", "15 April,1990")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports, Reading")
                .checkResult("Picture", "photo_2025.jpg")
                .checkResult("Address", "Russia")
                .checkResult("State and City", "Haryana Panipat");
    }

    @Test
    void demoFormTestMinimumData() {
        registrationPage.openPage()
                .setFirstName("Sergey")
                .setLastName("Redko")
                .setGender("Male")
                .setPhoneNumber("8345265897")
                .setState("Haryana")
                .setCity("Panipat")
                .submitForm();

        resultComponent.checkResult("Student Name", "Sergey Redko")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8345265897")
                .checkResult("State and City", "Haryana Panipat");
    }

    @Test
    void demoFormTestNegativeCheck() {
        registrationPage.openPage()
                .setFirstName("Sergey")
                .setLastName("Redko")
                .setUserEmail("redkoSSmail.ru")
                .setGender("Male")
                .setPhoneNumber("8345265897")
                .setState("Haryana")
                .setCity("Panipat")
                .submitForm();

        resultComponent.closeNot();
    }
}

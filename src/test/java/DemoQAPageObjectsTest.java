import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.Component.ResultComponent;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;

@Tag("demoqa")
public class DemoQAPageObjectsTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    ResultComponent resultComponent = new ResultComponent();

    @Test
    void demoFormTest() {
        step("Открываем главную страницу", () -> {
            registrationPage.openPage();
        });

        step("Вводим имя пользователя", () -> {
            registrationPage.setFirstName("Sergey");
        });

        step("Вводим фамилию пользователя", () -> {
            registrationPage.setLastName("Redko");
        });

        step("Вводим email пользователя", () -> {
            registrationPage.setUserEmail("redkoSS@mail.ru");
        });

        step("Выбираем пол", () -> {
            registrationPage.setGender("Male");
        });

        step("Вводим номер телефона", () -> {
            registrationPage.setPhoneNumber("8345265897");
        });

        step("Выбираем дату рождения", () -> {
            registrationPage.setOfBirth("15", "April", "1990");
        });

        step("Выбираем Hobby", () -> {
            registrationPage.setSubjects("Maths")
                    .setHobbies("Sports")
                    .setHobbies("Reading");
        });

        step("Загружаем файл", () -> {
            registrationPage.setPicture("photo_2025.jpg");
        });

        step("Вносим текущий адрес", () -> {
            registrationPage.setCurrentAddress("Russia");
        });

        step("Выбираем город", () -> {
            registrationPage.setState("Haryana");
        });

        step("Выбираем штат", () -> {
            registrationPage.setCity("Panipat");
        });

        step("Отправляем форму", () -> {
            registrationPage.submitForm();
        });

        step("Проверяем результат", () -> {
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
        });
    }

    @Test
    void demoFormTestMinimumData() {
        registrationPage.openPage()
                .setFirstName("Sergey")
                .setLastName("Redko")
                .setGender("Male")
                .setPhoneNumber("8345265897")
                .submitForm();

        resultComponent.checkResult("Student Name", "Sergey Redko")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8345265897");
    }

    @Test
    void demoFormTestNegativeCheck() {
        registrationPage.openPage()
                .setFirstName("Sergey")
                .setLastName("Redko")
                .setUserEmail("redkoSSmail.ru")
                .setGender("Male")
                .setPhoneNumber("8345265897")
                .submitForm();

        resultComponent.closeNot();
    }
}

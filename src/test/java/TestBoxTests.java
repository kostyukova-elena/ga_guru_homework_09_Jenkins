import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TestBoxPage;

@Tag("demoqa")
public class TestBoxTests extends TestBase {

    TestBoxPage testBoxPage = new TestBoxPage();

    @Test
    void demoTest() {
        testBoxPage.openPage()
                .setUserName("Ivanov Ivan")
                .setEmailName("Ivanov@mail.ru")
                .setCurrentAddress("Kazan")
                .setPermanentAddress("Moscow")
                .submitForm();

        testBoxPage.checkResult("Name:", "Ivanov Ivan")
                .checkResult("Email:", "Ivanov@mail.ru")
                .checkResult("Current Address :", "Kazan")
                .checkResult("Permananet Address :", "Moscow");
    }
}

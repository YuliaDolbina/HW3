import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PrFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void prFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Anna");
        $("#lastName").setValue("Ivanova");
        $("#userEmail").setValue("annushka@gmail.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("9065487765");
        $("#dateOfBirthInput").click();


        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1993");
        $$("div.react-datepicker__day").findBy(text("25")).click();

        $("#subjectsInput").setValue("en");
        $("#react-select-1-option-0").click();

        $("label[for=hobbies-checkbox-1]").click();

        $("#uploadPicture").uploadFromClasspath("pic.jpg");

        $("#currentAddress").setValue("Griboedova St. 1, 2");

        $("#react-select-1-input").setValue("NCR").pressEnter();
        $("#react-select-1-input").setValue("Delhi").pressEnter();
        $("#submit").click();


        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Anna Ivanova"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("annushka@gmail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9065487765"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("25 May, 1993"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("English"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sport"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("pic.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Griboedova St. 1, 2"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
    }


}

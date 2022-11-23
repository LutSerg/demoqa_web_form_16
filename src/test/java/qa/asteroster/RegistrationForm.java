package qa.asteroster;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationForm {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void registrationFormTest() {
     open("/automation-practice-form");

     $("#firstName").setValue("Bilbo");
     $("#lastName").setValue("Baggins");
     $("#userEmail").setValue("hobbit@shire.nz");
     $("#genterWrapper").$(byText("Male")).click();
     $("#userNumber").setValue("9998887755");
     $("#dateOfBirthInput").click();
     $(".react-datepicker__month-select").selectOption(4);
     $(".react-datepicker__year-select").click();
     $(".react-datepicker__year-select").selectOption("1990");
     $(".react-datepicker__month-container").$(".react-datepicker__day--010").click();
     $("#subjectsInput").click();
     $("#subjectsInput").setValue("history");
     $("#subjectsInput").pressEnter();
     $("#hobbiesWrapper").$(byText("Reading")).click();
     $("#uploadPicture").uploadFromClasspath("1.jpg");
     $("#currentAddress").setValue("Some text for some address");
     $("#state").click();
     $("#stateCity-wrapper").$(byText("NCR")).click();
     $("#city").click();
     $("#stateCity-wrapper").$(byText("Gurgaon")).click();
     $("#submit").click();
    }

}

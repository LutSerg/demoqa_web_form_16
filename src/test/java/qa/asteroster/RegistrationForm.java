package qa.asteroster;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import qa.asteroster.tests.TestBase;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationForm extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void registrationFormTest() {
     String userName = "Bilbo";
     String userLastName = "Baggins";
     String email = "hobbit@shire.nz";
     String gender = "Male";
     String phoneNumber = "9998887755";
     String subject = "history";
     String hobbies = "Reading";
     String address = "Some text for some address";
     String state = "NCR";
     String city = "Gurgaon";

     registrationFormPage.openPage()
            .setFirstName(userName)
            .setLastName(userLastName)
            .setEmail(email)
            .setGender(gender)
            .setPhoneNumber(phoneNumber)
            .setBirthDate("10", "May", "1990")
            .setSubject(subject)
            .setHobbie(hobbies)
            .uploadPhoto()
            .setAddress(address)
            .setState(state)
            .setCity(city)
            .submitForm();

     registrationFormPage.verifyResultModalAppears()
             .verifyResults("Student Name", userName + " " + userLastName)
             .verifyResults("Student Email", email)
             .verifyResults("Gender", gender)
             .verifyResults("Mobile", phoneNumber)
             .verifyResults("Date of Birth", "10 May,1990")
             .verifyResults("Subjects", subject)
             .verifyResults("Hobbies", hobbies)
             .verifyResults("Picture", "1.jpg")
             .verifyResults("Address", address)
             .verifyResults("State and City", state + " " + city);
    }
}

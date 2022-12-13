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
     String userName = "Bilbo",
            userLastName = "Baggins",
            email = "hobbit@shire.nz",
            gender = "Male",
            phoneNumber = "9998887755",
            subject = "history",
            hobbies = "Reading",
            address = "Some text for some address",
            state = "NCR",
            city = "Gurgaon",
            photo = "1.jpg";

     registrationFormPage.openPage()
            .setFirstName(userName)
            .setLastName(userLastName)
            .setEmail(email)
            .setGender(gender)
            .setPhoneNumber(phoneNumber)
            .setBirthDate("10", "May", "1990")
            .setSubject(subject)
            .setHobbie(hobbies)
            .uploadPhoto(photo)
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

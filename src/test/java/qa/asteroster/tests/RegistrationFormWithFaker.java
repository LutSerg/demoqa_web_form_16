package qa.asteroster.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

public class RegistrationFormWithFaker extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void registrationFormTest() {
        Faker faker = new Faker();
        String userName = faker.name().firstName(),
                userLastName = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                phoneNumber = faker.phoneNumber().subscriberNumber(10),
                address = faker.address().fullAddress(),
                gender = "Male",
                subject = "history",
                hobbies = "Reading",
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

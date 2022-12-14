package qa.asteroster.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

import java.util.Locale;
import java.util.Random;

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
                day = String.format("%02d",faker.number().numberBetween(1,31)),
                year = String.valueOf(faker.number().numberBetween(1970, 2022)),
                month = "July",
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
            .setBirthDate(day, month, year)
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
             .verifyResults("Date of Birth", day + " " + month + "," + year)
             .verifyResults("Subjects", subject)
             .verifyResults("Hobbies", hobbies)
             .verifyResults("Picture", photo)
             .verifyResults("Address", address)
             .verifyResults("State and City", state + " " + city);
    }
}

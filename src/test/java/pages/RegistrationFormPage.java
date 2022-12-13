package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultModalComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultModalComponent resultModalComponent = new ResultModalComponent();
    private final String TITLE_TEXT = "Student Registration Form";

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbieInput = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#stateCity-wrapper"),
            cityInput = $("#stateCity-wrapper"),
            submitForm = $("#submit");
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(Condition.text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setGender(String value) {
        genderInput.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setPhoneNumber(String value) {
        phoneInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setBirthDate (String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }
    public RegistrationFormPage verifyResultModalAppears() {
        resultModalComponent.verifyModalAppears();

        return this;
    }

    public RegistrationFormPage verifyResults (String key, String value) {
        resultModalComponent.verifyResults(key, value);

        return this;
    }

    public RegistrationFormPage setSubject(String value) {
        subjectInput.click();
        subjectInput.setValue(value);
        subjectInput.pressEnter();

        return this;
    }

    public RegistrationFormPage setHobbie (String value) {
        hobbieInput.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage uploadPhoto(String value) {
        pictureInput.uploadFromClasspath(value);

        return this;
    }

    public RegistrationFormPage setAddress (String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setState (String value) {
        $("#state").click();
        stateInput.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setCity (String value) {
        $("#city").click();
        cityInput.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage submitForm () {
        submitForm.click();

        return this;
    }
}

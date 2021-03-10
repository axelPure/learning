import com.codeborne.selenide.*;
import com.codeborne.selenide.conditions.Text;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class filltest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized=true;
    }


    @Test
    void fieldFill() {
        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String phoneNumber = faker.phoneNumber().subscriberNumber(10);
        String address = faker.address().fullAddress();

        //todo открываем сайт
        open("https://demoqa.com/automation-practice-form");
        //todo заполняем firstname
            $("#firstName").setValue(firstName);
        //todo заполняем lastname
            $("#lastName").setValue(lastName);
        //todo заполняем email
            $("#userEmail").setValue(email);
        //todo gender
            $(byText("Other")).click();
        //todo заполняем mobile
            $("#userNumber").setValue(phoneNumber);
        //todo заполняем DOB
          //todo год
            $("#dateOfBirthInput").click();
            $(".react-datepicker__year-select").click();
            $(byText("1990")).click();
          //todo месяц
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").click();
            $(byText("February")).click();
          //todo день
            $("#dateOfBirthInput").click();
            $(byText("4")).click();
        //todo заполняем Subjects
            $("#subjectsInput").setValue("h").pressEnter();
        //todo hobbies
            $(byText("Reading")).click();
        //todo scrolldown
            $("#stateCity-label").scrollTo();
        //todo заполняем address
            $("#currentAddress").setValue(address);
        //todo state and city
            $("#react-select-3-input").setValue("raj").pressEnter();
            $("#react-select-4-input").setValue("jai").pressEnter();
        //todo picture
            $(".form-control-file").uploadFromClasspath("img/hulk-hogan-696x392.jpg");
        //todo SUBMIT
        $("#submit").click();

        //todo asserts
        //todo проверяем модалку
        $("#example-modal-sizes-title-lg").shouldHave(Condition.text("Thanks for submitting the form"));
        //todo проверяем name
        $$(".table-responsive").shouldHave(CollectionCondition.texts(firstName + " " + lastName));
        //todo проверяем email
        $$(".table-responsive").shouldHave(CollectionCondition.texts(email));
        //todo проверяем gender
        $$(".table-responsive").shouldHave(CollectionCondition.texts("Other"));
        //todo проверяем mobile
        $$(".table-responsive").shouldHave(CollectionCondition.texts(phoneNumber));
        //todo проверяем DOB
        $$(".table-responsive").shouldHave(CollectionCondition.texts("04" + " february" + ",1990"));
        //todo проверяем Subjects
        $$(".table-responsive").shouldHave(CollectionCondition.texts("Hindi"));
        //todo проверяем hobbies
        $$(".table-responsive").shouldHave(CollectionCondition.texts("Reading"));
        //todo проверяем address
        $$(".table-responsive").shouldHave(CollectionCondition.texts(address));
        //todo проверяем state and city
        $$(".table-responsive").shouldHave(CollectionCondition.texts("Rajasthan" + " Jaipur"));
        //todo проверяем picture
        $$(".table-responsive").shouldHave(CollectionCondition.texts("hulk-hogan-696x392.jpg"));
//sleep(15000);
    }
}

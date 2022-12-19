package ru.kiforchuk.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebElement;
import ru.kiforchuk.pages.Header;
import ru.kiforchuk.pages.UserDataOrder;

import java.util.List;

import static org.junit.Assert.assertTrue;

//Негативное тестирование заказа с невалидными данными
@RunWith(Parameterized.class)
public class NegativeOrderWithNonValidUserDataTest extends AbstractTest {
    private final String firstName;
    private final String secondName;
    private final String address;
    private final String phoneNumber;

    public NegativeOrderWithNonValidUserDataTest(String firstName, String secondName, String address, String phoneNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"И", "Иванов", "Москва", "+7777777777"},
                {"Иван", "Римский-Корсаков", "Москва", "+7777777777"},
                {"Иван", "Иванов", "Moscow", "+7777777777"},
                {"Иван", "Иванов", "Москва", "42"}
        };
    }

    /**
     * Проверяет, что при введении невалидных данных и попытке продолжить офрмление заказа появляется сообщение об ошибке
     */
    @Test
    public void createOrderWithNonValidParam() {
        //Открывает главную страницу
        driver.get(UrlConstants.SCOOTER_MAIN_PAGE_URL);

        //Кликает на кнопоку "Заказать"
        Header headerObj = new Header(driver);
        headerObj.clickUpOrderButton();

        //Заполняет данные пользователя и кликает "Далее"
        UserDataOrder userDataOrderObj = new UserDataOrder(driver);
        userDataOrderObj.sendAllFieldsAndClickContinue(firstName, secondName, address, "Локомотив", phoneNumber);

        //Проверяет появилось ли сообщение с ошибкой
        boolean isErrorMassage = false;
        List<WebElement> errorsMessages = userDataOrderObj.getListOfErrorMessage();
        for (WebElement e : errorsMessages) {
            if (e.isDisplayed()){
                isErrorMassage = true;
                break;
            }
        }
        assertTrue("При попытке продолжить оформление заказа с невалидным значением в обязательном поле, не появилось сообщение об ошибке", isErrorMassage);
    }
}

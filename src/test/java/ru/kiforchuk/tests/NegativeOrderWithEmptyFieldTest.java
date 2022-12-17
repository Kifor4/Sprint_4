package ru.kiforchuk.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebElement;
import ru.kiforchuk.pages.Header;
import ru.kiforchuk.pages.RentInformationOrder;
import ru.kiforchuk.pages.UserDataOrder;

import java.util.List;

import static org.junit.Assert.assertTrue;

//Негативное тестирование заказа с пустыми полями
@RunWith(Parameterized.class)
public class NegativeOrderWithEmptyFieldTest extends AbstractTest {
    //Индекс пустого поля (0 - Имя, 1 - фамилия, 2 - адрес, 3 - метро, 4 - телефон, 5 - дата доставки, 6 - срок аренды)
    private final int emptyIndex;
    private final String firstName;
    private final String secondName;
    private final String address;
    private final String undergroundStation;
    private final String phoneNumber;
    private final String deliveryDateField;
    private final int periodIndex;

    public NegativeOrderWithEmptyFieldTest(int emptyIndex, String firstName, String secondName, String address, String undergroundStation, String phoneNumber, String deliveryDateField, int periodIndex) {
        this.emptyIndex = emptyIndex;
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.undergroundStation = undergroundStation;
        this.phoneNumber = phoneNumber;
        this.deliveryDateField = deliveryDateField;
        this.periodIndex = periodIndex;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {0, "Иван", "Иванов", "Москва", "Локомотив", "+7777777777", "31.12.2022", 6},
                {1, "Иван", "Иванов", "Москва", "Локомотив", "+7777777777", "31.12.2022", 6},
                {2, "Иван", "Иванов", "Москва", "Локомотив", "+7777777777", "31.12.2022", 6},
                {3, "Иван", "Иванов", "Москва", "Локомотив", "+7777777777", "31.12.2022", 6},
                {4, "Иван", "Иванов", "Москва", "Локомотив", "+7777777777", "31.12.2022", 6},
                {5, "Иван", "Иванов", "Москва", "Локомотив", "+7777777777", "31.12.2022", 6},
                {6, "Иван", "Иванов", "Москва", "Локомотив", "+7777777777", "31.12.2022", 6},
        };
    }

    @Test
    public void createOrderWithEmptyField() {
        //Открывает главную страницу
        driver.get(UrlConstants.SCOOTER_MAIN_PAGE_URL);

        //Кликает на кнопоку "Заказать"
        Header headerObj = new Header(driver);
        headerObj.clickUpOrderButton();

        //Заполняет данные пользователя и кликает "Далее"
        UserDataOrder userDataOrderObj = new UserDataOrder(driver);
        if (emptyIndex != 0) {
            userDataOrderObj.sendFirstName(firstName);
        }
        if (emptyIndex != 1) {
            userDataOrderObj.sendSecondName(secondName);
        }
        if (emptyIndex != 2) {
            userDataOrderObj.sendAddress(address);
        }
        if (emptyIndex != 3) {
            userDataOrderObj.selectUndergroundStation(undergroundStation);
        }
        if (emptyIndex != 4) {
            userDataOrderObj.sendPhoneNumber(phoneNumber);
        }
        userDataOrderObj.clickContinueButton();

        //Заполняет информацию об аренде и кликает "Заказать"
        if(emptyIndex > 4) {
            RentInformationOrder rentInformationOrderObj = new RentInformationOrder(driver);
            if (emptyIndex != 5) {
                rentInformationOrderObj.sendDeliveryDate(deliveryDateField);
            }
            if (emptyIndex != 6) {
                rentInformationOrderObj.choosePeriod(periodIndex);
            }
            rentInformationOrderObj.clickOrderButton();
        }

        //Проверяет появилось ли сообщение с ошибкой
        boolean isErrorMassage = false;
        List<WebElement> errorsMessages = userDataOrderObj.getListOfErrorMessage();
        for (WebElement e : errorsMessages) {
            if (e.isDisplayed()) {
                isErrorMassage = true;
                break;
            }
        }

        assertTrue("При попытке продолжить оформление заказа с пустым обязательным полем, не появилось сообщение об ошибке", isErrorMassage);
    }
}
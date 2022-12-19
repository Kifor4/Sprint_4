package ru.kiforchuk.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.kiforchuk.pages.*;

import static org.junit.Assert.assertTrue;

//Тестирование заказа
@RunWith(Parameterized.class)
public class PositiveOrderTest extends AbstractTest {
    private final Boolean isUpButton;
    private final String firstName;
    private final String secondName;
    private final String address;
    private final String undergroundStation;
    private final String phoneNumber;
    private final String deliveryDateField;
    private final int periodIndex;

    public PositiveOrderTest(Boolean isUpButton, String firstName, String secondName, String address, String undergroundStation, String phoneNumber, String deliveryDateField, int periodIndex) {
        this.isUpButton = isUpButton;
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
                {true, "Иван", "Иванов", "Москва", "Локомотив", "+7777777777", "31.12.2022", 6},
                {false, "Петр", "Петров", "Москва", "Кропоткинская", "+7777777777", "30.12.2022", 2}
        };
    }

    /**
     * Проверяет, что заказ коректно оформляется после заполнения всех необходимых полей
     */
    @Test
    public void positiveCreateOrderTest() {
        //Открывает главную страницу
        driver.get(UrlConstants.SCOOTER_MAIN_PAGE_URL);

        //Кликает на одну из кнопок "Заказать" в зависимости от параметра
        if (isUpButton) {
            Header headerObj = new Header(driver);
            headerObj.clickUpOrderButton();
        } else {
            MainPage mainPageObj = new MainPage(driver);
            mainPageObj.clickDownOrderButton();
        }


        //Заполняет данные пользователя и кликает "Далее"
        UserDataOrder userDataOrderObj = new UserDataOrder(driver);
        userDataOrderObj.sendAllFieldsAndClickContinue(firstName, secondName, address, undergroundStation, phoneNumber);

        //Заполняет информацию об аренде и кликает "Заказать"
        RentInformationOrder rentInformationOrderObj = new RentInformationOrder(driver);
        rentInformationOrderObj.sendNecessaryFieldsAndClickOrder(deliveryDateField, periodIndex);

        //Кликает "Да"
        ConfirmationOrder confirmationOrderObj = new ConfirmationOrder(driver);
        confirmationOrderObj.clickYesButton();

        //Проверяет видно ли окно подтверждения заказа
        boolean isProcessedOrderTextDisplayed = confirmationOrderObj.checkProcessedOrderText();
        assertTrue("Ошибка при оформлении заказа", isProcessedOrderTextDisplayed);
    }
}
package ru.kiforchuk.tests;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import ru.kiforchuk.pages.ConfirmationOrder;
import ru.kiforchuk.pages.Header;
import ru.kiforchuk.pages.RentInformationOrder;
import ru.kiforchuk.pages.UserDataOrder;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//Негативное тестирование заказа с пустыми обязательными полями
public class NegativeOrderWithEmptyFieldTest extends AbstractTest {
    private String firstName = "Иван";
    private String secondName = "Иванов";
    private String address = "Москва";
    private String undergroundStation = "Локомотив";
    private String phoneNumber = "+77777777777";
    private String deliveryDateField = "31.12.2022";
    private int periodIndex = 1;

    /**
     * Пустое поле Имя
     */
    @Test
    public void createOrderWithEmptyFirstNameField() {
        //Открывает главную страницу
        driver.get(UrlConstants.SCOOTER_MAIN_PAGE_URL);

        //Кликает на кнопоку "Заказать"
        Header headerObj = new Header(driver);
        headerObj.clickUpOrderButton();

        //Заполняет данные пользователя и кликает "Далее"
        UserDataOrder userDataOrderObj = new UserDataOrder(driver);
        userDataOrderObj.sendSecondName(secondName);
        userDataOrderObj.sendAddress(address);
        userDataOrderObj.selectUndergroundStation(undergroundStation);
        userDataOrderObj.sendPhoneNumber(phoneNumber);
        userDataOrderObj.clickContinueButton();

        //Проверяет появилось ли сообщение с ошибкой
        boolean isErrorMassage = false;
        List<WebElement> errorsMessages = userDataOrderObj.getListOfErrorMessage();
        for (WebElement e : errorsMessages) {
            if(e.getText().equals("Введите корректное имя")) {
                isErrorMassage = e.isDisplayed();
            }
        }

        assertTrue("При попытке продолжить оформление заказа с пустым полем Имя, не появилось сообщение об ошибке", isErrorMassage);
    }

    /**
     * Пустое поле Фамилия
     */
    @Test
    public void createOrderWithEmptySecondNameField() {
        //Открывает главную страницу
        driver.get(UrlConstants.SCOOTER_MAIN_PAGE_URL);

        //Кликает на кнопоку "Заказать"
        Header headerObj = new Header(driver);
        headerObj.clickUpOrderButton();

        //Заполняет данные пользователя и кликает "Далее"
        UserDataOrder userDataOrderObj = new UserDataOrder(driver);
        userDataOrderObj.sendFirstName(firstName);
        userDataOrderObj.sendAddress(address);
        userDataOrderObj.selectUndergroundStation(undergroundStation);
        userDataOrderObj.sendPhoneNumber(phoneNumber);
        userDataOrderObj.clickContinueButton();

        //Проверяет появилось ли сообщение с ошибкой
        boolean isErrorMassage = false;
        List<WebElement> errorsMessages = userDataOrderObj.getListOfErrorMessage();
        for (WebElement e : errorsMessages) {
            if(e.getText().equals("Введите корректную фамилию")) {
                isErrorMassage = e.isDisplayed();
            }
        }

        assertTrue("При попытке продолжить оформление заказа с пустым полем Фамилия, не появилось сообщение об ошибке", isErrorMassage);
    }

    /**
     * Пустое поле Адрес
     */
    @Test
    public void createOrderWithEmptyAddressField() {
        //Открывает главную страницу
        driver.get(UrlConstants.SCOOTER_MAIN_PAGE_URL);

        //Кликает на кнопоку "Заказать"
        Header headerObj = new Header(driver);
        headerObj.clickUpOrderButton();

        //Заполняет данные пользователя и кликает "Далее"
        UserDataOrder userDataOrderObj = new UserDataOrder(driver);
        userDataOrderObj.sendFirstName(firstName);
        userDataOrderObj.sendSecondName(secondName);
        userDataOrderObj.selectUndergroundStation(undergroundStation);
        userDataOrderObj.sendPhoneNumber(phoneNumber);
        userDataOrderObj.clickContinueButton();

        //Проверяет появилось ли сообщение с ошибкой
        boolean isErrorMassage = false;
        List<WebElement> errorsMessages = userDataOrderObj.getListOfErrorMessage();
        for (WebElement e : errorsMessages) {
            if(e.getText().equals("Введите корректный адрес")) {
                isErrorMassage = e.isDisplayed();
            }
        }

        assertTrue("При попытке продолжить оформление заказа с пустым полем Адрес, не появилось сообщение об ошибке", isErrorMassage);
    }

    /**
     * Пустое поле Метро
     */
    @Test
    public void createOrderWithEmptyUndergroundStationField() {
        //Открывает главную страницу
        driver.get(UrlConstants.SCOOTER_MAIN_PAGE_URL);

        //Кликает на кнопоку "Заказать"
        Header headerObj = new Header(driver);
        headerObj.clickUpOrderButton();

        //Заполняет данные пользователя и кликает "Далее"
        UserDataOrder userDataOrderObj = new UserDataOrder(driver);
        userDataOrderObj.sendFirstName(firstName);
        userDataOrderObj.sendSecondName(secondName);
        userDataOrderObj.sendAddress(address);
        userDataOrderObj.sendPhoneNumber(phoneNumber);
        userDataOrderObj.clickContinueButton();

        //Проверяет появилось ли сообщение с ошибкой
        boolean isErrorMassage = false;
        List<WebElement> errorsMessages = userDataOrderObj.getListOfErrorMessage();
        for (WebElement e : errorsMessages) {
            if(e.getText().equals("Выберите станцию")) {
                isErrorMassage = e.isDisplayed();
            }
        }

        assertTrue("При попытке продолжить оформление заказа с пустым полем Метро, не появилось сообщение об ошибке", isErrorMassage);
    }

    /**
     * Пустое поле Телефон
     */
    @Test
    public void createOrderWithEmptyPhoneNumberField() {
        //Открывает главную страницу
        driver.get(UrlConstants.SCOOTER_MAIN_PAGE_URL);

        //Кликает на кнопоку "Заказать"
        Header headerObj = new Header(driver);
        headerObj.clickUpOrderButton();

        //Заполняет данные пользователя и кликает "Далее"
        UserDataOrder userDataOrderObj = new UserDataOrder(driver);
        userDataOrderObj.sendFirstName(firstName);
        userDataOrderObj.sendSecondName(secondName);
        userDataOrderObj.sendAddress(address);
        userDataOrderObj.selectUndergroundStation(undergroundStation);
        userDataOrderObj.clickContinueButton();

        //Проверяет появилось ли сообщение с ошибкой
        boolean isErrorMassage = false;
        List<WebElement> errorsMessages = userDataOrderObj.getListOfErrorMessage();
        for (WebElement e : errorsMessages) {
            if(e.getText().equals("Введите корректный номер")) {
                isErrorMassage = e.isDisplayed();
            }
        }

        assertTrue("При попытке продолжить оформление заказа с пустым полем Телефон, не появилось сообщение об ошибке", isErrorMassage);
    }

    /**
     * Пустое поле Дата доставки
     */
    @Test
    public void createOrderWithEmptyDeliveryDateField() {
        //Открывает главную страницу
        driver.get(UrlConstants.SCOOTER_MAIN_PAGE_URL);

        //Кликает на кнопоку "Заказать"
        Header headerObj = new Header(driver);
        headerObj.clickUpOrderButton();

        //Заполняет данные пользователя и кликает "Далее"
        UserDataOrder userDataOrderObj = new UserDataOrder(driver);
        userDataOrderObj.sendAllFieldsAndClickContinue(firstName, secondName, address, undergroundStation, phoneNumber);

        //Заполняем информацию о заказе и кликаем "Заказать"
        RentInformationOrder rentInformationOrder = new RentInformationOrder(driver);
        rentInformationOrder.choosePeriod(periodIndex);
        rentInformationOrder.clickOrderButton();

        //На этом этапе сообщений об ошибках не высвечивается, проверяет, что оформление дальше не идет
        assertFalse("Продолжается оформление заказа с пустым полем Дата доставки", new ConfirmationOrder(driver).checkConfirmationText());
    }

    /**
     * Пустое поле Срок аренды
     */
    @Test
    public void createOrderWithEmptyPeriodField() {
        //Открывает главную страницу
        driver.get(UrlConstants.SCOOTER_MAIN_PAGE_URL);

        //Кликает на кнопоку "Заказать"
        Header headerObj = new Header(driver);
        headerObj.clickUpOrderButton();

        //Заполняет данные пользователя и кликает "Далее"
        UserDataOrder userDataOrderObj = new UserDataOrder(driver);
        userDataOrderObj.sendAllFieldsAndClickContinue(firstName, secondName, address, undergroundStation, phoneNumber);

        //Заполняем информацию о заказе и кликаем "Заказать"
        RentInformationOrder rentInformationOrder = new RentInformationOrder(driver);
        rentInformationOrder.sendDeliveryDate(deliveryDateField);
        rentInformationOrder.clickOrderButton();

        //На этом этапе сообщений об ошибках не высвечивается, проверяет, что оформление дальше не идет
        assertFalse("Продолжается оформление заказа с пустым полем Срок аренды", new ConfirmationOrder(driver).checkConfirmationText());
    }
}
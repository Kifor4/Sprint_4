package ru.kiforchuk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

//Класс страницы заполнения пользовательских данных
public class UserDataOrder extends AbstractPage {
    //Имя
    private By firstNameField = By.xpath(".//input[@placeholder='* Имя']");
    //Фамилия
    private By secondNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //Адрес
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Станция метро (поле)
    private By undergroundStationField = By.xpath(".//input[@placeholder='* Станция метро']");
    //Станция метро (для клика)
    private By undergroundStationClick = By.className("Order_Text__2broi");
    //Телефон
    private By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    private By continueButton = By.xpath(".//button[text()='Далее']");
    //Сообщение об ошибки при заполнении поля
    private By errorMessage = By.className("Input_ErrorMessage__3HvIb");
    //Сообщение об ошибке в поле метро
    private By undergroundErrorMassage = By.className("Order_MetroError__1BtZb");

    public UserDataOrder(WebDriver driver) {
        super(driver);
    }

    /**
     * Вводит переданное значение в поля "Имя".
     *
     * @param firstName - строка с именем клиента (Кириллица).
     */
    public void sendFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    /**
     * Вводит переданное значение в поля "Фамилия" (Кириллица).
     *
     * @param secondName - строка с фамилией клиента.
     */
    public void sendSecondName(String secondName) {
        driver.findElement(secondNameField).sendKeys(secondName);
    }

    /**
     * Вводит переданное значение в поля "Адрес: куда привезти заказ".
     *
     * @param address - строка с адрессом доставки (Кириллица).
     */
    public void sendAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    /**
     * Вводит переданное значение в поля "Станция метро".
     * @param undergroundStation - строка со станцией метро Москвы
     */
    public void selectUndergroundStation(String undergroundStation) {
        driver.findElement(undergroundStationField).sendKeys(undergroundStation);
        driver.findElement(undergroundStationClick).click();
    }

    /**
     * Вводит переданное значение в поля "Телефон: на него позвонит курьер".
     * @param phoneNumber - строка с валидным номером телефона ('+\d{10-12}' || \d{11-13} )
     */
    public void sendPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    /**
     * Кликает на кнопку "Далее"
     */
    public void clickContinueButton() {
        clickButtonWithScrollAndWait(driver.findElement(continueButton));
    }

    /**
     * Заполняет все поля и нажимает на кнопку "Далее"
     * @param firstName - имя (Кириллица)
     * @param secondName - фамилия (Кириллица)
     * @param address - адрес (Кириллица)
     * @param undergroundStation - станция метро Москвы
     * @param phoneNumber - номер телефона ('+\d{10-12}' || \d{11-13} )
     */
    public void sendAllFieldsAndClickContinue(String firstName, String secondName, String address, String undergroundStation, String phoneNumber) {
        sendFirstName(firstName);
        sendSecondName(secondName);
        sendAddress(address);
        selectUndergroundStation(undergroundStation);
        sendPhoneNumber(phoneNumber);
        clickContinueButton();
    }

    public List<WebElement> getListOfErrorMessage() {
        List<WebElement> errorMessages = driver.findElements(errorMessage);
        errorMessages.addAll(driver.findElements(undergroundErrorMassage));
        return errorMessages;
    }

}
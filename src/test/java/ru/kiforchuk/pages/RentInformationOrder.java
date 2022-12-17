package ru.kiforchuk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Класс страницы заполнения информации об аренде
public class RentInformationOrder extends AbstractPage {
    //Дата доставки
    private By deliveryDateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Срок аренды
    private By periodField = By.className("Dropdown-control");
    //Выпадающий список срока аренды
    private By periodDropDownOptions = By.className("Dropdown-option");

    //Кнопка "Заказать", подтверждающая заказ
    private By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");


    public RentInformationOrder(WebDriver driver) {
        super(driver);
    }

    /**
     * Вводит переданное значение в поле "Когда привезти самокат".
     * @param deliveryDate - строка с датой формата ДД.ММ.ГГГГ.
     */
    public void sendDeliveryDate(String deliveryDate) {
        driver.findElement(deliveryDateField).sendKeys(deliveryDate);
    }

    /**
     * Выбирает период аренды в поле "Срок аренды".
     * @param index - индекс варианта.
     */
    public void choosePeriod(int index){
        driver.findElement(periodField).click();
        driver.findElements(periodDropDownOptions).get(index).click();
    }

    /**
     * Кликает на кнопку "Заказать", подтверждающую заказ.
     */
    public void clickOrderButton() {
        clickButtonWithScrollAndWait(driver.findElement(orderButton));
    }

    /**
     * Заполняет необходимые поля и нажимает на кнопку "Заказать".
     * @param deliveryDate - строка с датой формата ДД.ММ.ГГГГ.
     * @param periodIndex - индекс варианта.
     */
    public void sendNecessaryFieldsAndClickOrder(String deliveryDate, int periodIndex) {
        choosePeriod(periodIndex);
        sendDeliveryDate(deliveryDate);
        clickOrderButton();
    }
}
package ru.kiforchuk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Класс шапки приложения
public class Header extends AbstractPage {
    //Кнопка "Заказать"
    private By upOrderButton = By.className("Button_Button__ra12g");


    //Кнопка "Статус заказ"
    private By orderStatusButton = By.className("Header_Link__1TAG7");


    //Поле ввода номер заказа
    private By orderNumberField = By.xpath(".//input[@placeholder='Введите номер заказа']");

    //Кнопка "Go!"
    private By goButton = By.xpath(".//button[text()='Go!']");

    //Лого Самокат
    private By logoScooter = By.xpath(".//img[@alt='Scooter']");

    //Лого Yandex
    private By logoYandex = By.xpath(".//img[@alt='Yandex']");

    public Header(WebDriver driver) {
        super(driver);
    }

    /**
     * Кликает верхнюю кнопку "Заказать"
     */
    public void clickUpOrderButton() {
        clickButtonWithScrollAndWait(driver.findElement(upOrderButton));
    }

    /**
     * Кликает кнопку "Статус заказа"
     */
    public void clickOrderStatusButton() {
        clickButtonWithScrollAndWait(driver.findElement(orderStatusButton));
    }

    /**
     * Вводит переданное значение в поле "Введите номер заказа"
     *
     * @param orderNumber - строка с номером заказа
     */
    public void sendOrderNumber(String orderNumber) {
        waitElementToBeClickable(driver.findElement(orderNumberField));
        driver.findElement(orderNumberField).sendKeys(orderNumber);
    }

    /**
     * Кликает кнопку "Go!"
     */
    public void clickGoButton() {
        clickButtonWithScrollAndWait(driver.findElement(goButton));
    }

    /**
     * Выполняет поиск заказа по номеру
     *
     * @param orderNumber - строка с номером заказа
     */
    public void searchOrderByNumber(String orderNumber) {
        clickOrderStatusButton();
        sendOrderNumber(orderNumber);
        clickGoButton();
    }

    /**
     * Кликает на лого "Самокат"
     */
    public void clickLogoScooter() {
        clickButtonWithScrollAndWait(driver.findElement(logoScooter));
    }

    /**
     * Кликает на лого "Yandex"
     */
    public void clickLogoYandex() {
        clickButtonWithScrollAndWait(driver.findElement(logoYandex));
    }
}
package ru.kiforchuk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmationOrder extends AbstractPage {
    //Кнопка "Да"
    private By yesButton = By.xpath(".//button[text() = 'Да']");

    // Надпись об успешном оформлении
    private By processedOrder = By.className("Order_ModalHeader__3FDaJ");

    // Надпись с вопросом о подтверждении
    private By confirmationText = By.xpath(".//div[text()='Хотите оформить заказ?'");

    public ConfirmationOrder(WebDriver driver) {
        super(driver);
    }


    /**
     * Кликает на кнопку "Да".
     */
    public void clickYesButton() {
        clickButtonWithScrollAndWait(driver.findElement(yesButton));
    }

    /**
     * Проверяет видно ли сообщение об успешном оформлении заказа.
     * @return true - сообщение видно, false - сообщение не видно.
     */
    public boolean checkProcessedOrderText() {
        WebElement element = driver.findElement(processedOrder);
        return element.isDisplayed() && element.getText().contains("Заказ оформлен");
    }

    /**
     * Проверяет видно ли сообщение с вопросом о подтверждении.
     * @return true - сообщение видно, false - сообщение не видно.
     */
    public boolean checkConfirmationText() {
        try{
            return driver.findElement(confirmationText).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
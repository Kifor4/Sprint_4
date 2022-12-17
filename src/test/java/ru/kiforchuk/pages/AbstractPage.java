package ru.kiforchuk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Ожидает возможности кликнуть на элемент.
     *
     * @param element - WebElement, содержащий необходимую кнопку.
     */
    protected void waitElementToBeClickable(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitElementToBeClickable(By elementLoger) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(elementLoger)));
    }

    protected void waitElementToBeVisibility(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitElementToBeVisibility(By elementLoger) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(elementLoger)));
    }

    /**
     * Скроллит до кнопку, ждет возможности кликнуть и кликает.
     * @param button
     */
    protected void clickButtonWithScrollAndWait(WebElement button) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", button);
        waitElementToBeClickable(button);
        button.click();
    }
}
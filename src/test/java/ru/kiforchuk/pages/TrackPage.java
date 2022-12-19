package ru.kiforchuk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

//Страница отслеживания заказа
public class TrackPage extends AbstractPage{
    //Картинка "Такого заказа нет"
    private By notFoundImg = By.xpath(".//Img [@alt='Not found']");

    public TrackPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Проверяет видно ли изображение "Такого заказа нет"
     * @return true - видно | false - не видно
     */
    public boolean checkNotFoundImg() {
        try {
            waitElementToBeVisibility(notFoundImg);
            return driver.findElement(notFoundImg).isDisplayed();
        } catch (WebDriverException e) {
            return false;
        }
    }
}
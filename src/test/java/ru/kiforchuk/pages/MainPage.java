package ru.kiforchuk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Класс главной страницы
public class MainPage extends AbstractPage {
    //Кнопки-вопросы в секции "Вопросы о важном"
    private By importantQuestionsAccordionButtons = By.className("accordion__button");

    //Открывающиеся ответы в секции "Вопросы о важном"
    private By importantQuestionsAccordionPanels = By.className("accordion__panel");

    //Нижняя кнопка "Заказать"
    private By downOrderButton = By.xpath(".//div[@class='Home_ThirdPart__LSTEE']//button[text()='Заказать']");


    public MainPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Кликает на кнопку-вопрос в секции "Вопросы о важном".
     *
     * @param index - индекс кнопки.
     */
    public void clickImportantQuestionsAccordionButtonByIndex(int index) {
        clickButtonWithScrollAndWait(driver.findElements(importantQuestionsAccordionButtons).get(index));
    }

    /**
     * Возвращает информацию о том виден ли ответ в секции "Вопросы о важном".
     *
     * @param index - индекс ответа.
     * @return true - ответ виден, false - ответ не виден.
     */
    public boolean checkImportantQuestionsAccordionPanelIsDisplayed(int index) {
        return driver.findElements(importantQuestionsAccordionPanels).get(index).isDisplayed();
    }

    /**
     * Возвращает количество кнопок-вопросов найденных на странице.
     *
     * @return количество кнопок-вопросов.
     */
    public int getImportantQuestionsAccordionButtonsCount() {
        return driver.findElements(importantQuestionsAccordionButtons).size();
    }

    /**
     * Кликает по нижней кнопоке "Заказать".
     */
    public void clickDownOrderButton() {
        clickButtonWithScrollAndWait(driver.findElement(downOrderButton));
    }
}
package ru.kiforchuk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Класс главной страницы
public class MainPage extends AbstractPage {
    //Кнопки-вопросы в секции "Вопросы о важном"
    private By importantQuestionsAccordionButtons = By.className("accordion__button");

    //Открывающиеся ответы в секции "Вопросы о важном"
    private By importantQuestionsAccordionPanels = By.className("accordion__panel");

    //Нижняя кнопка "Заказать"
    private By downOrderButton = By.xpath(".//div[@class='Home_ThirdPart__LSTEE']//button[text()='Заказать']");

    //Карта с значениями полей ключ - вопрос, значение - ответ
    private Map<String, String> rightQuestionAnswerTextsMap;


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
     * Возвращает текст кнопки-вопроса
     * @param index - индекс кнопки
     * @return текст кнопки вопроса
     */
    public String getActualQuestionTextByIndex(int index) {
        return driver.findElements(importantQuestionsAccordionButtons).get(index).getText();
    }

    /**
     * Проверяет, что текс вопроса есть в карте (Текст вопроса совпадает с требуемым)
     * @param index - индекс кнопки
     * @return true - вопрос есть в карте, false - вопроса нет в карте
     */
    public boolean checkQuestionTextMatchingByIndex(int index) {
        if (rightQuestionAnswerTextsMap == null) {
            initializationQuestionAnswerTextsMap();
        }
        return rightQuestionAnswerTextsMap.containsKey(getActualQuestionTextByIndex(index));
    }

    /**
     * Проверяет, что текст ответа совпадает с требуемым
     * @param index - индекс кнопки
     * @return true - ответы совпадают, false - ответы не совпадают
     */
    public boolean checkDisplayedAnswerTextMatchingByQuestion(int index) {
        if (rightQuestionAnswerTextsMap == null) {
            initializationQuestionAnswerTextsMap();
        }
        List<WebElement> answersList = driver.findElements(importantQuestionsAccordionPanels);
        for (WebElement answer : answersList) {
            if (answer.isDisplayed()) {
                String rightAnswer = rightQuestionAnswerTextsMap.get(getActualQuestionTextByIndex(index));
                String actualAnswer = answer.getText();
                return rightAnswer.equals(actualAnswer);
            }
        }
        return false;
    }

    /**
     * Кликает по нижней кнопоке "Заказать".
     */
    public void clickDownOrderButton() {
        clickButtonWithScrollAndWait(driver.findElement(downOrderButton));
    }

    public void initializationQuestionAnswerTextsMap() {
        rightQuestionAnswerTextsMap = new HashMap<>();
        rightQuestionAnswerTextsMap.put("Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
        rightQuestionAnswerTextsMap.put("Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.");
        rightQuestionAnswerTextsMap.put("Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.");
        rightQuestionAnswerTextsMap.put("Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.");
        rightQuestionAnswerTextsMap.put("Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.");
        rightQuestionAnswerTextsMap.put("Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.");
        rightQuestionAnswerTextsMap.put("Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.");
        rightQuestionAnswerTextsMap.put("Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области.");
    }
}
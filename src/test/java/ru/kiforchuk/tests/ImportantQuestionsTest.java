package ru.kiforchuk.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.kiforchuk.pages.MainPage;

import static org.junit.Assert.assertTrue;


//Тестирование выпадающего списка в разделе "Вопросы о важном".
@RunWith(Parameterized.class)
public class ImportantQuestionsTest extends AbstractTest {

    //индекс кнопки-вопроса
    private final int index;

    public ImportantQuestionsTest(int index) {
        this.index = index;
    }

    /**
     * Возвращает параметры, в зависимости от количества найденных кнопок.
     * @return одномерный массив объектов-параметров
     */
    @Parameterized.Parameters
    public static Object[] getTestData() {
        //Драйвер для создания параметров
        WebDriver paramDriver = new ChromeDriver();
        //Объект главной страницы для создания параметров
        MainPage paramMainPageObj = new MainPage(paramDriver);
        //Открываем ссылку
        paramDriver.get(UrlConstants.SCOOTER_MAIN_PAGE_URL);
        //Считаем количество кнопок-вопросов
        int buttonCount = paramMainPageObj.getImportantQuestionsAccordionButtonsCount();
        //Закрываем драйвер
        paramDriver.quit();
        //Создаем, заполняем и возвращаем массив параметров
        Object[] params = new Object[buttonCount];
        for (int i = 0; i < params.length; i++) {
            params[i] = i;
        }
        return params;
    }


    /**
     * Проверяет становится ли виден выпадающий элемент-ответ после нажатия на кнопку-вопрос.
     */
    @Test
    public void checkIsDisplayAnswerAfterClickQuestionButton() {
        //Открывает главную страницу
        driver.get(UrlConstants.SCOOTER_MAIN_PAGE_URL);

        //Кликает на кнопку-вопрос
        MainPage mainPageObj = new MainPage(driver);
        mainPageObj.clickImportantQuestionsAccordionButtonByIndex(index);

        //Проверяет видел ли ответ
        boolean isAnswerDisplayed = mainPageObj.checkImportantQuestionsAccordionPanelIsDisplayed(index);
        assertTrue("Ответ не виден" , isAnswerDisplayed);
    }
}
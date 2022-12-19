package ru.kiforchuk.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
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
     *
     * @return одномерный массив объектов-параметров
     */
    @Parameterized.Parameters
    public static Object[] getTestData() {
        return new Object[]{0, 1, 2, 3, 4, 5, 6, 7};
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
        assertTrue("Не виден ответ для вопроса №" + (index + 1) + "после нажатия", isAnswerDisplayed);

        //Проверяем совпадает ли текст
        assertTrue("Текст вопроса№ " + (index + 1) + " не совпадает с требуемым", mainPageObj.checkQuestionTextMatchingByIndex(index));
        assertTrue("Текст открытого ответа не совпадает с требуемым или не соответствует выбранному вопросу №" + (index + 1), mainPageObj.checkDisplayedAnswerTextMatchingByQuestion(index));
    }
}
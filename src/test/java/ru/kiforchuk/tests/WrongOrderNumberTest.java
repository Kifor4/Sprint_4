package ru.kiforchuk.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.kiforchuk.pages.Header;
import ru.kiforchuk.pages.TrackPage;

import static org.junit.Assert.assertTrue;

//Проверка поиска неправильного номера заказа
@RunWith(Parameterized.class)
public class WrongOrderNumberTest extends AbstractTest{
    private final String wrongOrderNumber;

    public WrongOrderNumberTest(String wrongOrderNumber) {
        this.wrongOrderNumber = wrongOrderNumber;
    }

    @Parameterized.Parameters
    public static Object[] getTestData() {
        return new Object[] {"11111", "007"};
    }

    /**
     * Проверяет отображается ли сообщение об отсутствии заказа, при вводе неверного номера
     */
    @Test
    public void checkNoOrderMessageAfterSearchWrongNumber() {
        //Открывает главную страницу
        driver.get(UrlConstants.SCOOTER_MAIN_PAGE_URL);

        //Ищем заказ по номеру
        Header headerObj = new Header(driver);
        headerObj.searchOrderByNumber(wrongOrderNumber);

        //Проверяем отображается ли сообщение
        TrackPage trackPageObj = new TrackPage(driver);
        assertTrue("При поиске несуществующего заказа по номеру отсутствует сообщение, что заказа не существует", trackPageObj.checkNotFoundImg());
    }
}
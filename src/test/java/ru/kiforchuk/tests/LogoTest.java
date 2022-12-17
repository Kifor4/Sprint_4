package ru.kiforchuk.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.kiforchuk.pages.Header;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

//Тестирование логотипов
@RunWith(Parameterized.class)
public class LogoTest extends AbstractTest{
    //Стартовый адрес
    private final String startUrl;

    public LogoTest(String startUrl) {
        this.startUrl = startUrl;
    }

    @Parameterized.Parameters
    public static Object[] getTestData() {
        return new Object[] {
                "https://qa-scooter.praktikum-services.ru/track?5555",
                "https://qa-scooter.praktikum-services.ru/order"
        };
    }

    /**
     * Проверяет, что при нажатии на лого "Самокат" открывается главная страница
     */
    @Test
    public void checkLogoScooterSendsToMainPage() {
        //Открывает страницу самоката заданную параметром
        driver.get(startUrl);

        //Кликает лого "Самокат"
        Header headerObj = new Header(driver);
        headerObj.clickLogoScooter();

        //Получает текущий url и делает проверку
        String url = driver.getCurrentUrl();
        assertEquals("Не перенесло на главную страницу самоката", UrlConstants.SCOOTER_MAIN_PAGE_URL, url);
    }

    /**
     * Проверяет что при нажатии на лого "Yandex" открывается главная страница яндекса.
     * Работает только с ChromeDriver.
     */
    @Test
    public void checkLogoYandexOpenYandexMainPageInNewTab() {
        //Открывает страницу самоката заданную параметром
        driver.get(startUrl);

        //Кликает лого "Yandex"
        Header headerObj = new Header(driver);
        headerObj.clickLogoYandex();

        //Сохраняет список вкладок
        List<String> tabs = new ArrayList<> (driver.getWindowHandles());
        //Меняет вкладку
        driver.switchTo().window(tabs.get(1));

        //Получает текущий url и отрезает параметры
        String url = driver.getCurrentUrl();
        url = url.split("\\?")[0];

        //Проверяет, что стало 2 вкладки
        assertEquals("Не открылась новая вкладка", 2, tabs.size());
        //Проверяет, что открыта страница яндекса
        assertEquals("Не открылась главная страница яндекса", UrlConstants.YANDEX_MAIN_PAGE_URL, url);
    }
}
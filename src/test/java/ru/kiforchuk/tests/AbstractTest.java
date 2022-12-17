package ru.kiforchuk.tests;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Родитель для классов-тестов
public abstract class AbstractTest {
    //WebDriver
    protected WebDriver driver = new ChromeDriver();

    /**
     * Закрываем браузер
     */
    @After
    public void tearDown() {
        driver.quit();
    }
}
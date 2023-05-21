package ru.yandex.praktikum.pageobject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static ru.yandex.praktikum.config.AppConfig.APP_URL;


@RunWith(Parameterized.class)
public class DropDownTest {
    private WebDriver webdriver;
    private final String expectedAnswerText;
    public DropDownTest(String expectedAnswerText) {
        this.expectedAnswerText = expectedAnswerText;
    }
    private static final Object[][] expectedAnswerTexts = new Object[][] {
            {"Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
            {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
            {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
            {"Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
            {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
            {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
            {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
            {"Да, обязательно. Всем самокатов! И Москве, и Московской области."}
    };

    @Parameterized.Parameters
    public static Object[][] getExpectedAnswerTexts() {
        return expectedAnswerTexts;
    }

    @Test
    public void isExpectedTextDisplayedInDropdownAfterClickInFirefox() {
        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        webdriver = new FirefoxDriver();
        webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webdriver.get(APP_URL);
        MainPage objMainPage = new MainPage(webdriver);
        objMainPage.scrollToDropdown();
        objMainPage.closePopupButton();

        for (int i = 0; i < expectedAnswerTexts.length; i++) {
            objMainPage.clickQuestion(i);
            List<WebElement> answerTextElements = objMainPage.getAnswer();
            String actualAnswerText = answerTextElements.get(i).getText();
            String expectedAnswerText = (String) expectedAnswerTexts[i][0];
            assertEquals(expectedAnswerText, actualAnswerText);
        }
    }

    @Test
    public void isExpectedTextDisplayedInDropdownAfterClickInChrome() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        webdriver = new ChromeDriver();
        webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webdriver.get(APP_URL);
        MainPage objMainPage = new MainPage(webdriver);
        objMainPage.scrollToDropdown();
        objMainPage.closePopupButton();

        for (int i = 0; i < expectedAnswerTexts.length; i++) {
            objMainPage.clickQuestion(i);
            List<WebElement> answerTextElements = objMainPage.getAnswer();
            String actualAnswerText = answerTextElements.get(i).getText();
            String expectedAnswerText = (String) expectedAnswerTexts[i][0];
            assertEquals(expectedAnswerText, actualAnswerText);
        }
    }
   @After
   public void teardown() { webdriver.quit(); }
}
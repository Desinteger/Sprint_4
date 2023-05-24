package ru.yandex.praktikum.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.praktikum.page_object.MainPage;
import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import static ru.yandex.praktikum.config.AppConfig.APP_URL;

public class DropDownTest {
    private WebDriver webdriver;

    private final static String expectedText1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private final static String expectedText2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private final static String expectedText3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private final static String expectedText4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private final static String expectedText5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private final static String expectedText6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private final static String expectedText7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private final static String expectedText8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";


    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        webdriver = new FirefoxDriver();
        webdriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webdriver.get(APP_URL);
        MainPage objMainPage = new MainPage(webdriver);
        objMainPage.scrollToDropdown();
        objMainPage.closePopupButton();
    }

    @Test
    public void isExpectedTextDisplayedInDropdownAfterClickInFirefox1 () {
        MainPage objMainPage = new MainPage(webdriver);
        objMainPage.clickQuestion(0);
        assertEquals(objMainPage.getAnswerText(0), expectedText1);
    }

    @Test
    public void isExpectedTextDisplayedInDropdownAfterClickInFirefox2 () {
        MainPage objMainPage = new MainPage(webdriver);
        objMainPage.clickQuestion(1);
        assertEquals(objMainPage.getAnswerText(1), expectedText2);
}

    @Test
    public void isExpectedTextDisplayedInDropdownAfterClickInFirefox3() {
        MainPage objMainPage = new MainPage(webdriver);
        objMainPage.clickQuestion(2);
        assertEquals(objMainPage.getAnswerText(2), expectedText3);
    }

    @Test
    public void isExpectedTextDisplayedInDropdownAfterClickInFirefox4() {
        MainPage objMainPage = new MainPage(webdriver);
        objMainPage.clickQuestion(3);
        assertEquals(objMainPage.getAnswerText(3), expectedText4);
    }

    @Test
    public void isExpectedTextDisplayedInDropdownAfterClickInFirefox5() {
        MainPage objMainPage = new MainPage(webdriver);
        objMainPage.clickQuestion(4);
        assertEquals(objMainPage.getAnswerText(4), expectedText5);
    }
    @Test
    public void isExpectedTextDisplayedInDropdownAfterClickInFirefox6() {
        MainPage objMainPage = new MainPage(webdriver);
        objMainPage.clickQuestion(5);
        assertEquals(objMainPage.getAnswerText(5), expectedText6);
    }

    @Test
    public void isExpectedTextDisplayedInDropdownAfterClickInFirefox7() {
        MainPage objMainPage = new MainPage(webdriver);
        objMainPage.clickQuestion(6);
        assertEquals(objMainPage.getAnswerText(6), expectedText7);
}

    @Test
    public void isExpectedTextDisplayedInDropdownAfterClickInFirefox8() {
        MainPage objMainPage = new MainPage(webdriver);
        objMainPage.clickQuestion(7);
        assertEquals(objMainPage.getAnswerText(7), expectedText8);
    }
   @After
   public void teardown() { webdriver.quit(); }
}
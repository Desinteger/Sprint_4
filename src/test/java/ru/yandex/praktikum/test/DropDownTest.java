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

    @Before
    public void setUp () {
        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        webdriver = new FirefoxDriver();
        webdriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webdriver.get(APP_URL);
        MainPage objMainPage = new MainPage(webdriver);
        objMainPage.scrollToDropdown();
        objMainPage.closePopupButton();
    }
    @Test
    public void isExpectedTextDisplayedInDropdownAfterClickInFirefox() {
        MainPage objMainPage = new MainPage(webdriver);

        objMainPage.clickQuestion(0);
        assertEquals(objMainPage.getAnswerText(0), "Сутки — 400 рублей. Оплата курьеру — наличными или картой.");

        objMainPage.clickQuestion(1);
        assertEquals(objMainPage.getAnswerText(1), "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.");

        objMainPage.clickQuestion(2);
        assertEquals(objMainPage.getAnswerText(2), "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.");

        objMainPage.clickQuestion(3);
        assertEquals(objMainPage.getAnswerText(3), "Только начиная с завтрашнего дня. Но скоро станем расторопнее.");

        objMainPage.clickQuestion(4);
        assertEquals(objMainPage.getAnswerText(4), "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.");

        objMainPage.clickQuestion(5);
        assertEquals(objMainPage.getAnswerText(5), "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.");

        objMainPage.clickQuestion(6);
        assertEquals(objMainPage.getAnswerText(6), "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.");

        objMainPage.clickQuestion(7);
        assertEquals(objMainPage.getAnswerText(7), "Да, обязательно. Всем самокатов! И Москве, и Московской области.");
    }
   @After
   public void teardown() { webdriver.quit(); }
}
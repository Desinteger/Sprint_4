package ru.yandex.praktikum.pageobject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import static org.junit.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import static ru.yandex.praktikum.config.AppConfig.APP_URL;

@RunWith(Parameterized.class)
public class OrderTest {
    private WebDriver webdriver;
    private final By orderButton;
    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;

    public OrderTest(By orderButton, String name, String surname, String address, String metroStation, String phoneNumber) {
        this.orderButton = orderButton;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
                {By.className("Button_Button__ra12g"), "Томас", "Андерсон", "Проспект Пифии, 28, 9", "Бульвар Рокоссовского", "+79998008886"},
                {By.xpath(".//div[5]/button"), "Тайлер", "Дёрден", "Тестовая наб., 7, 333", "Черкизовская", "+79063348987"},
        };
    }

    @Test
    public void isOrderPossibleInChrome() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        webdriver = new ChromeDriver();
        webdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        webdriver.get(APP_URL);
        MainPage objMainPage = new MainPage(webdriver);
        objMainPage.closePopupButton();
        objMainPage.clickOrderButton(orderButton);
        OrderUserPage objUserPage = new OrderUserPage(webdriver);
        objUserPage.setName(name);
        objUserPage.setSurname(surname);
        objUserPage.setAdress(address);
        objUserPage.setMetro(metroStation);
        objUserPage.setPhoneNumber(phoneNumber);
        objUserPage.clickContinueButton();
        OrderRentPage objRentPage = new OrderRentPage(webdriver);
        objRentPage.setDate();
        objRentPage.setRentalPeriod();
        objRentPage.setScooterColour();
        objRentPage.clickOrderButton();
        objRentPage.clickYesButton();
        assertTrue(objRentPage.isOrderProcessed());
    }

    @Test
    public void isOrderPossibleInFirefox() {
        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        webdriver = new FirefoxDriver();
        webdriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webdriver.get(APP_URL);
        MainPage objMainPage = new MainPage(webdriver);
        objMainPage.closePopupButton();
        objMainPage.clickOrderButton(orderButton);
        OrderUserPage objUserPage = new OrderUserPage(webdriver);
        objUserPage.setName(name);
        objUserPage.setSurname(surname);
        objUserPage.setAdress(address);
        objUserPage.setMetro(metroStation);
        objUserPage.setPhoneNumber(phoneNumber);
        objUserPage.clickContinueButton();
        OrderRentPage objRentPage = new OrderRentPage(webdriver);
        objRentPage.setDate();
        objRentPage.setRentalPeriod();
        objRentPage.setScooterColour();
        objRentPage.clickOrderButton();
        objRentPage.clickYesButton();
        assertTrue(objRentPage.isOrderProcessed());
    }

    @After
    public void teardown() { webdriver.quit(); }
}



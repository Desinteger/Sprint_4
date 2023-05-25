package ru.yandex.praktikum.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import ru.yandex.praktikum.page_object.MainPage;
import ru.yandex.praktikum.page_object.OrderRentPage;
import ru.yandex.praktikum.page_object.OrderUserPage;

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
                {MainPage.orderButtonUpLocator, "Томас", "Андерсон", "Проспект Пифии, 28, 9", "Бульвар Рокоссовского", "+79998008886"},
                {MainPage.orderButtonDownLocator, "Тайлер", "Дёрден", "Тестовая наб., 7, 333", "Черкизовская", "+79063348987"},
        };
    }

    @Before
    public void setUp () {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        webdriver = new ChromeDriver();
        webdriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webdriver.get(APP_URL);
    }

    @Test
    public void isOrderPossibleInChrome() {
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



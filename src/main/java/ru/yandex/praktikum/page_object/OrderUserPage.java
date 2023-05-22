package ru.yandex.praktikum.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class OrderUserPage {
    private WebDriver webdriver;
    private By nameField = By.cssSelector("input[placeholder=\"* Имя\"]");
    private By surnameField = By.cssSelector("input[placeholder=\"* Фамилия\"]");
    private By adressField = By.cssSelector("input[placeholder=\"* Адрес: куда привезти заказ\"]");
    private By metroField = By.className("select-search__input");
    private By phoneField = By.cssSelector("input[placeholder=\"* Телефон: на него позвонит курьер\"]");
    private By continueButton = By.xpath(".//button[contains(text(),'Далее')]");
    public OrderUserPage(WebDriver webdriver) { this.webdriver = webdriver; }

    public void setName(String name) { webdriver.findElement(nameField).sendKeys(name); }
    public void setSurname(String surname) {
        webdriver.findElement(surnameField).sendKeys(surname);
    }
    public void setAdress(String adress) {
        webdriver.findElement(adressField).sendKeys(adress);
    }
    public void setMetro(String metroStation) {
        webdriver.findElement(metroField).click();
        By metroOption = By.xpath("//div[@class='Order_Text__2broi' and text()='" + metroStation + "']");
        webdriver.findElement(metroOption).click();
    }
    public void setPhoneNumber(String phoneNumber) { webdriver.findElement(phoneField).sendKeys(phoneNumber); }
    public void clickContinueButton() { webdriver.findElement(continueButton).click(); }
}

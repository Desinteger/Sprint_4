package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class OrderUserPage {
    private WebDriver webdriver;
    private By nameField = By.xpath(".//div[2]/div[1]/input");
    private By surnameField = By.xpath(".//div[2]/input");
    private By adressField = By.xpath(".//div[3]/input");
    private By metroField = By.className("select-search__input");
    private By phoneField = By.xpath(".//div[5]/input");
    private By continueButton = By.xpath(".//div[2]/div[3]/button");
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

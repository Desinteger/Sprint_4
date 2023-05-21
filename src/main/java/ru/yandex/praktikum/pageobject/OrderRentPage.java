package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderRentPage {
    private WebDriver webdriver;
    private By dateField = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    private By dateOption = By.xpath(".//div[contains(@class, 'react-datepicker__day--020') and text()='20']");
    private By rentalPeriod = By.className("Dropdown-control");
    private By rentalOption = By.xpath(".//div[contains(@class, 'Dropdown-option') and text()='двое суток']");
    private By scooterColour = By.id("black");
    private By orderButton = By.xpath(".//div[3]/button[2]");
    private By yesButton = By.xpath(".//div[5]/div[2]/button[2]");
    private By successOrderWindow = By.xpath(".//div[contains(text(),'Заказ оформлен')]");

    public OrderRentPage(WebDriver webdriver) {  this.webdriver = webdriver;  }
    public void setDate() {
        webdriver.findElement(dateField).click();
        webdriver.findElement(dateOption).click();
    }

    public void setRentalPeriod() {
        webdriver.findElement(rentalPeriod).click();
        webdriver.findElement(rentalOption).click();
    }
    public void setScooterColour() { webdriver.findElement(scooterColour).click(); }
    public void clickOrderButton() { webdriver.findElement(orderButton).click(); }
    public void clickYesButton(){ webdriver.findElement(yesButton).click();}
    public boolean isOrderProcessed(){
        return webdriver.findElement(successOrderWindow).isDisplayed();
    }

}

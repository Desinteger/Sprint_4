package ru.yandex.praktikum.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver webdriver;
    private By dropDown = By.className("accordion__button");
    private By popupButton = By.className("App_CookieButton__3cvqF");
    public static final By orderButtonUpLocator = By.xpath(".//button[@class='Button_Button__ra12g']");
    public static final By orderButtonDownLocator = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    public MainPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }
    public void scrollToDropdown() {
        WebElement element = webdriver.findElement(dropDown);
        ((JavascriptExecutor)webdriver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void closePopupButton(){ webdriver.findElement(popupButton).click();  }

    public void clickQuestion(int questionIndex) {
        By questionLocator = By.id("accordion__heading-" + questionIndex);
        WebElement questionElement = webdriver.findElement(questionLocator);
        questionElement.click();
    }

    public String getAnswerText(int questionIndex) {
        By answerLocator = By.id("accordion__panel-" + questionIndex);
        WebElement answerElement = webdriver.findElement(answerLocator);
        return answerElement.getText();
    }

    public void clickOrderButton(By orderButton) {
        webdriver.findElement(orderButton).click();
    }
}

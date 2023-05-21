package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.util.List;

public class MainPage {
    private WebDriver webdriver;
    private By question = By.className("accordion__button");
    private By answer = By.className("accordion__panel");
    private By popupButton = By.className("App_CookieButton__3cvqF");
    public MainPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }
    public void scrollToDropdown() {
        WebElement element = webdriver.findElement(question);
        ((JavascriptExecutor)webdriver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void closePopupButton(){ webdriver.findElement(popupButton).click();  }

    public void clickQuestion(int index) {
        List<WebElement> questionElements = webdriver.findElements(question);
        questionElements.get(index).click();
    }

    public List<WebElement> getAnswer() {
        return webdriver.findElements(answer);
    }
    public void clickOrderButton(By orderButton) {
        webdriver.findElement(orderButton).click();
    }
}

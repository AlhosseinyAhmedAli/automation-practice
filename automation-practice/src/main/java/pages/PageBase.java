package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class PageBase {
    protected WebDriver driver;
    public  JavascriptExecutor jse;
    public Select select;
    protected Actions action ;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    protected void fluentWaitForElement(WebElement webElement) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOf(webElement));
    }
    protected void hover(WebElement webElement) {
        fluentWaitForElement(webElement);
        action.moveToElement(webElement).perform();
    }
}
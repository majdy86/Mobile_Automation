package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePageObject {

    /**
     * Constructor
     */
    public BasePageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /**
     * @param element
     * @param driver
     */
    public void clickUsingJavaScriptExecutor(WebElement element, WebDriver driver) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
        executor.executeScript("arguments[0].click();", element);
    }
}

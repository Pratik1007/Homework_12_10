package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility {
    WebDriver driver;

    public Utility(WebDriver driver) {
        this.driver = driver;
    }

    //    method for click on element with By class
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    //    method for click on web element
    public void clickOnElement(WebElement element) {
        element.click();
    }

    //    method for send text in element
    public void sendTextToElement(By by, String str) {
        driver.findElement(by).sendKeys(str);
    }

    //    method for check if element is displayed or not
    public boolean isElementDisplayed(By by) {
        if (driver.findElement(by).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }
}

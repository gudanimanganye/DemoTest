package automation.webUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class WebActions {

    public void passData(WebElement element, WebDriver driver, String vValue){

        try{
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(5000))
                    .pollingEvery(Duration.ofMillis(1000))
                    .ignoring(WebDriverException.class);
            wait.until(ExpectedConditions.elementToBeClickable(element));

            element.clear();
            element.sendKeys(vValue);

        } catch (Exception e) {
            System.out.println(e.getMessage() + "Not Found");
        }
    }

    public void clickObject(WebElement element, WebDriver driver) {

        try {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(5000))
                    .pollingEvery(Duration.ofMillis(1000))
                    .ignoring(WebDriverException.class);
            wait.until(ExpectedConditions.elementToBeClickable(element));

            element.click();

        } catch (Exception e) {
            System.out.println(e.getMessage() + "Not Found");
        }
    }
}

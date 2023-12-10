package automation.pageObjects;

import automation.reports.ExtentReport;
import automation.webPageObjects.LoginPage;
import automation.webUtilities.WebActions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WebFunctions extends WebActions {

    ExtentReport report = new ExtentReport();

    public void login(WebDriver driver, String Username, String Password, ExtentTest node){

        LoginPage login = new LoginPage(driver);

        try {
            passData(login.username, driver, Username);
            passData(login.password, driver, Password);
            clickObject(login.loginBtn, driver);

            String filename = report.CaptureScreenShoot(driver);

            //validation
            if(login.welcomeMessage.isDisplayed()){

                node.pass("login was successful", MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
            } else {
                node.fail("login was unsuccessful", MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
                Assert.fail("login was unsuccessful");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage() + "Not Found");
        }

    }
}

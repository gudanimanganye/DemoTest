package automation.webTests;

import automation.pageObjects.WebFunctions;
import automation.reports.ExtentReport;
import automation.webUtilities.WebUtilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AppUnderTest {

    WebUtilities web = new WebUtilities();
    WebFunctions functions = new WebFunctions();

    ExtentReport report = new ExtentReport();

    ExtentReports reports;


    String sUrl, sBrowser;

    @BeforeClass
    @Parameters({"adactinUrl", "Browser"})
    public void init(String adactinUrl, String Browser){

        sUrl = adactinUrl;
        sBrowser = Browser;

        web.setWebDriver(web.initializeWebDriver(sBrowser));
        reports = report.initializeExtentReports("src/reports/report.html");


    }

    @Test
    public void runTests() {

        ExtentTest test = reports.createTest("Book Hotel").assignAuthor("Gudani");
        ExtentTest node = test.createNode("Test Cases");

        try {
            web.navigate(sUrl);
            functions.login(WebUtilities.getWebDriver(), "user010115", "1234567890", node);

        } catch (Exception e) {
            System.out.println(e.getMessage() + "Found Found");
        }
    }

    @AfterClass
    public void tearDown() {

        try {

            reports.flush();
            Thread.sleep(5000);
            WebUtilities.getWebDriver().close();
            WebUtilities.getWebDriver().quit();

        } catch (Exception e) {
            System.out.println(e.getMessage() + "Found Found");
        }
    }
}

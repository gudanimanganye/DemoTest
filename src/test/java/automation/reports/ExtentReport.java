package automation.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class ExtentReport {

    ExtentSparkReporter sparkReporter;
    ExtentReports reports;

    public ExtentReports initializeExtentReports(String reportName){

        sparkReporter = new ExtentSparkReporter(reportName);
        reports = new ExtentReports();
        reports.attachReporter(sparkReporter);

        return reports;
    }

    public String CaptureScreenShoot(WebDriver driver) throws IOException {

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte [] fileContent = FileUtils.readFileToByteArray(new File(String.valueOf(file)));
        String encodedString = Base64.getEncoder().encodeToString(fileContent);

        return encodedString;
    }
}

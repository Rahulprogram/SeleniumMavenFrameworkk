package Resources;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;

public class ExtentReportNG {
    public static ExtentReports getReportObject() {


        String path = System.getProperty("user.dir") + "\\src\\reports\\index1.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("AutomationTest");
        reporter.config().setDocumentTitle("Test Result");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Rahul");

        return extent;
    }
}

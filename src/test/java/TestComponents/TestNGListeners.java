package TestComponents;

import Resources.ExtentReportNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners extends BaseTest implements ITestListener
{
    ExtentTest test;
    ExtentReports extent = ExtentReportNG.getReportObject();
    ThreadLocal<ExtentTest> extenttest= new ThreadLocal<ExtentTest>();
    @Override
    public void onTestStart(ITestResult result)
    {
      test= extent.createTest(result.getMethod().getMethodName());
      extenttest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
         test.log(Status.PASS,"Test Passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        //screenshot code
        //response if API is failed
        extenttest.get().fail(result.getThrowable());
        try {
            driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception  e1) {
            e1.printStackTrace();

        }

        String filepath=getScreenshot(result.getMethod().getMethodName(),driver);
        extenttest.get().addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());


    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onFinish(ITestContext context)
    {
        extent.flush();

    }

}

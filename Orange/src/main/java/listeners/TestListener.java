package listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import reports.ExtentLogger;
import reports.ExtentReportManager;

public class TestListener implements ITestListener {

    private static ExtentReports extent;

    @Override
    public void onStart(ITestContext context) {
        extent = ExtentReportManager.initReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        ExtentLogger.setTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass("✅ Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail("❌ Test Failed: " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip("⚠️ Test Skipped: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        try {
			ExtentReportManager.flushReport();
		} catch (IOException e) {
			e.printStackTrace();
		}
        ExtentLogger.remove();
    }
}
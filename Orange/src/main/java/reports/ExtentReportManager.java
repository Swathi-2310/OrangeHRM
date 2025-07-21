package reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import constants.FrameworkConstants;

public final class ExtentReportManager {

    private static ExtentReports extent;

    private ExtentReportManager() {}

    public static ExtentReports initReport() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportPath());
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setReportName("Automation Test Report");
            spark.config().setDocumentTitle("Test Results");
            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Tester", "Vijay");
            extent.setSystemInfo("Environment", "QA");
        }
        return extent;
    }

    public static void flushReport() throws IOException {
        if (extent != null) {
            extent.flush();
            Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportPath()).toURI());
        }
    }

    public static ExtentReports getExtent() {
        return extent;
    }
}
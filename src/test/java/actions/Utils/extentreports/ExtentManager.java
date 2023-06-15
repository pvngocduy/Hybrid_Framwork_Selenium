package actions.Utils.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import actions.commons.GlobalConstant;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(GlobalConstant.PROJECT_PATH + "/extentV5/ExtentReport.html");
        reporter.config().setReportName("Demo Extent Report");
        reporter.config().setDocumentTitle("Demo Extent Report");
        reporter.config().setTimelineEnabled(true);
        reporter.config().setEncoding("utf-8");
        reporter.config().setTheme(Theme.DARK);

        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Company", "Duy Pham");
        extentReports.setSystemInfo("Project", "Learn Selenium");
        extentReports.setSystemInfo("JDK version", GlobalConstant.JAVA_VERSION);
        return extentReports;
    }
}

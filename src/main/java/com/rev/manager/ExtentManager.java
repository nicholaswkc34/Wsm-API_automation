package com.rev.manager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private ExtentSparkReporter sparkReporter;
    private ExtentReports extentReports;

    public ExtentManager() {
        String todayDate = java.time.LocalDate.now().toString();

        sparkReporter = new ExtentSparkReporter("report/TestReport-says-" + todayDate + ".html");
        sparkReporter.config().setReportName("Says Automation Testing Report");
        sparkReporter.config().setDocumentTitle("Says Automation Testing Report");
        sparkReporter.config().setTheme(Theme.DARK);
        extentReports = new ExtentReports();
        extentReports.setSystemInfo("Company Name","Rev Media Group");
        extentReports.setSystemInfo("Test Lead","Nicholas Wong");

        extentReports.attachReporter(sparkReporter);

    }

    public ExtentReports getExtentReports() {
        return extentReports;
    }





}

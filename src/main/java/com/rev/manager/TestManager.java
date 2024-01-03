package com.rev.manager;

import com.aventstack.extentreports.ExtentTest;

public abstract class TestManager {

    protected EmailManager emailManager;
    protected ExtentManager extentManager;
    protected BrokenLinkChecker brokenLinkChecker;

    protected ExtentTest extentTest;

    // ==========================================================================


    public TestManager() {
        emailManager = new EmailManager();
        extentManager = new ExtentManager();
        brokenLinkChecker = new BrokenLinkChecker();
    }





}

//================================================================================================================
/*
Aqua Web Training
https://www.youtube.com/watch?v=u94Pf9--Vc4


Test page load time
((JavascriptExecutor)driver).executeScript("var performance = window.performance || {};" +
            "var timings = performance.timing || {};"+
            "return timings;");

Find Broken Image
$("#valid-image img").shouldBe(image);


Just click the link and verify that the new page gets the expected title or URL.
Get all links on the page, and execute http get request for everyone of them:
$$("a").asFixedIterable().forEach(link -> {
  httpClient.get(link.attr("href")); // use your favorite http client here
});

webdriver().shouldHave(title("Login page"));




 */


package com.rev.testManager;

import com.codeborne.selenide.testng.ScreenShooter;
import com.rev.manager.BrokenLinkChecker;
import com.rev.manager.TestManager;
import com.rev.manager.ZipFileManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.naming.spi.ResolveResult;


@Listeners({ScreenShooter.class})
public class GenericTestManager extends TestManager {

    BrokenLinkChecker brokenLinkChecker;
    ZipFileManager zipFileManager;
    RequestSpecification requestSpecification;
    Response response;

    @BeforeSuite
    public void init() {
        brokenLinkChecker = new BrokenLinkChecker();
        zipFileManager = new ZipFileManager();
    }
        
    @AfterClass
    public void tearDown() {
        // Write to html file
        extentManager.getExtentReports().flush();
        //zipFileManager.zipFile();
        //emailManager.sendEmail();
    }

    private String getToken() {
        RestAssured.baseURI = "https://raudhahku.com.my/api/v1/oauth/token";

        requestSpecification = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("grant_type", "client_credentials");
        requestParams.put("client_id", 1);
        requestParams.put("client_secrets", "Gsv7brPlt5fIpqa1ebFc5A1uHwDJBPY6TRaMm8wa");

        requestSpecification.header("Content-Type", "application/json");
        requestSpecification.body(requestParams.toString());
        response = RestAssured.post();
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        return response.body().jsonPath().getString("data.access_token");
    }

    @Test
    public void testGetPrayerTimes() {
        RestAssured.baseURI = "https://cms.waktusolat.digital/esolatjson.php?zon=ngs01&bulan=1&tahun=2024";

        requestSpecification = RestAssured.given();
        response = requestSpecification.get();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void testGetAllLanguages() {
        String access_token = getToken();
        System.out.println(access_token);
        RestAssured.baseURI = "https://raudhahku.com.my/api/v1/languages";

        requestSpecification = RestAssured.given();
        requestSpecification.header("Authorization", access_token);
        response = requestSpecification.get();

        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }












































}

/*
https://developers.google.com/gmail/api/guides



mvn dependency:tree or gradle dependencies

Maven surefire Debug Mode
mvn -X -DforkCount=0 -Dselenide.browser=chrome test
X = debug mode for maven

https://github.com/soydivision/Selenide-quick-FAQ

https://www.jrebel.com/blog/using-selenide-for-ui-acceptance-testing

Jira Integration
https://www.browserstack.com/guide/how-to-integrate-jira-with-selenium


https://bitbucket.org/atlassian/jira-rest-java-client/src/master/




back()
forward()
switchTo().Frame();
switchTo().defaultContent();
switchTo().window(1);
switchTo().alert();
alert.accept();
alert.dismiss();


closeWindow();
closeWebDriver();
Thread.sleep(3000);
WebDriverRunner.clearBrowserCache();
WebDriverRunner.url();
WebDriverRunner.getBrowserDownloadFolder();

Basic Auth
Using overload open();

Select HTML or Finding Selenide Elements
https://www.youtube.com/watch?v=DWD-2OJ4F4Q

actions().moveToElement().build().perform();

Drag and Drop
actions().clickAndHold(sourceElement).moveToElement(targetElement).release().build.perform();
actions().dragAndDrop().build().perform();

Right Click
actions().contextClick();


Configuration.timeout = 8000;

Network Behind Proxy
System.setProperty("wdm.proxy", url);    // url as "http://host:port"
System.setProperty("wdm.proxyUser", url);
System.setProperty("wdm.proxyPass", url);

webdriver().shouldHave(url("https://auth.google.com"));



 */


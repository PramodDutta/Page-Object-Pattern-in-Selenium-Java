package TASK_1_VWO.testcase;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import TASK_1_VWO.webpages.HeatMapPage;
import TASK_1_VWO.webpages.HomePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MainTestClass {


    WebDriver driver;


    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }




    @Test
    public void test_task1() throws InterruptedException {
        HomePage homepage = new HomePage(driver);

        System.out.println(homepage.getBrowserTitle());
        homepage.heatMap_btnClick_step1();
        System.out.println("1" + homepage.getBrowserTitle());  //DONotDelete-Task - Heatmaps
        homepage.clikc_heatmap_thubbtn_step2();
        System.out.println("2" + homepage.getBrowserTitle());  //DONotDelete-Task - Heatmaps


        // Task 1.1
        // Verification of Ttitle
        //

        try {
            Assert.assertEquals(driver.getTitle(), "DONotDelete-Task - Heatmaps");
        } catch (Exception ex) {
            Assert.fail();
        }


        HeatMapPage heatmapPage = new HeatMapPage(driver);
        System.out.println(heatmapPage.getBrowserTitle());//


        try {
            Assert.assertEquals(heatmapPage.getBrowserTitle(), "DONotDelete-Task - Heatmaps");

        } catch (Exception ex) {
            Assert.fail();
        }

        // Task 1.2
        // Verification of Element Page to Load
        //

        String elementPageTitle = heatmapPage.switchToOtherWindow_step3();
        System.out.println(elementPageTitle);

        try {
            Assert.assertEquals(elementPageTitle, "Lorem Ipsum - All the facts - Lipsum generator");

        } catch (Exception ex) {
            Assert.fail();
        }
        String actual = heatmapPage.switchElementsFrame_VerfiyHighLight_step4();



        // Task 1.3
        // Verification of HighLight
        //
        try {
            Assert.assertEquals(actual, "display: block");
        } catch (Exception ex) {
            Assert.fail();
        }


    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println(testResult.getStatus());
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String s  = "ScreenshotFail" + dateFormat.format(date) + ".png";
             s =  s.replace("/","");
             s =  s.replace(" ","");
             s =  s.replace(":","");

            System.out.print(s);

            FileUtils.copyFile(scrFile, new File(s));

        }
    }
}

package TASK_1_VWO.testcase;


import java.util.concurrent.TimeUnit;

import TASK_1_VWO.webpages.HeatMapPage;
import TASK_1_VWO.webpages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

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
        homepage.heatMap_btnClick_step1();
        homepage.clikc_heatmap_thubbtn_step2();

        //	Assert.assertEquals(driver.getTitle(),"");


        HeatMapPage heatmapPage = new HeatMapPage(driver);
        heatmapPage.switchToOtherWindow_step3();
        String actual = heatmapPage.switchElementsFrame_VerfiyHighLight_step4();

        //	Assert.assertEquals(actual,"block");


    }

    @Test
    public void test_task2() throws InterruptedException {
        HomePage homepage = new HomePage(driver);
        homepage.heatMap_btnClick_step1();
        homepage.clikc_heatmap_thubbtn_step2();

        //	Assert.assertEquals(driver.getTitle(),"");


        HeatMapPage heatmapPage = new HeatMapPage(driver);
        heatmapPage.switchToOtherWindow_step3();
        String actual = heatmapPage.switchElementsFrame_VerfiyHighLight_step4();
        // Verify Property for HighLight!!
        Assert.assertEquals(actual,"display: block");


    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}

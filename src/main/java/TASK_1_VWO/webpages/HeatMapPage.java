package TASK_1_VWO.webpages;

/**
 * Created by pramo_000 on 06-04-2016.
 */
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HeatMapPage
{
    private WebDriver driver;

    public String getBrowserTitle(){

        if( driver.getTitle()!=null)
        {
            return driver.getTitle();
        }
        else
        {
            return "";

        }
    }

    public HeatMapPage (WebDriver driver){
        this.driver=driver;
        driver.manage().window().maximize();
        waitForPageLoaded();
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }



    public String switchToOtherWindow_step3()
    {
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        return driver.getTitle();
    }


    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    public String switchElementsFrame_VerfiyHighLight_step4() throws InterruptedException
    {
        driver.switchTo().defaultContent(); // you are now outside both frames
        driver.switchTo().frame("heatmap-iframe");

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        By s2 = By.xpath("//*[@id='option-section']/div[6]");
        waitForVisibilityOf(s2);
        driver.findElement(s2).click();

        driver.switchTo().defaultContent(); // you are now outside both frames
        driver.switchTo().frame("element-list-iframe");

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id='element-list--content']/tr[2]/td[1]")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.switchTo().defaultContent();
        WebElement e =  driver.findElement(By.xpath("//*[@id='_vwo_glass']"));
        System.out.println(e.getAttribute("style"));

        String temp = e.getAttribute("style");
        String[] temp1 = temp.split(";");
        System.out.println("Display :- "+temp1[0]);


        return temp1[0];



    }


    public void waitForVisibilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}


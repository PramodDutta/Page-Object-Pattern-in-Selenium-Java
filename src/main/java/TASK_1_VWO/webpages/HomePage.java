package TASK_1_VWO.webpages;

/**
 * Created by pramo_000 on 06-04-2016.
 */import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver = null;
    public static final String BASE_URL = "http://app.vwo.com/#/campaign/108/summary?token=eyJhY2NvdW50X2lkIjoxNTA3MzQsImV4cGVyaW1lbnRfaWQiOjEwOCwiY3JlYXRlZF9vbiI6MTQ0NDgxMjQ4MSwidHlwZSI6ImNhbXBhaWduIiwidmVyc2lvbiI6MSwiaGFzaCI6IjJmZjk3OTVjZTgwNmFmZjJiOTI5NDczMTc5YTBlODQxIn0";

    public HomePage(WebDriver driver)
    {

        this.driver = driver;
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);


    }

    public void waitForVisibilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

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

    @FindBy(how = How.XPATH,using = "/html/body/div[5]/div/div[2]/ul/li[3]/a/span")
    private WebElement heatmap_btn;


    public void heatMap_btnClick_step1()
    {

        if(heatmap_btn.isDisplayed())
        {
            heatmap_btn.click();
        }
        else
        {
            System.out.println("Element Heatmap is Not Found!!");
        }

    }


    @FindBy(how = How.CLASS_NAME,using = "heatmap-thumb")
    private WebElement heatmap_thub_click;

    public void clikc_heatmap_thubbtn_step2()
    {
        if(heatmap_thub_click.isDisplayed())
        {
            heatmap_thub_click.click();
        }
        else
        {
            System.out.println("Heatmap Thumb is Not Found!!");
        }

    }






}

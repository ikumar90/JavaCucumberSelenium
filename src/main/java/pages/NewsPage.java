package pages;

import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class NewsPage {

    public static WebDriver driver;
    public static String key=null;

    @FindBy(xpath="//div[@id='sp_message_container_414203' and @style='display: block; height: 100%; top: auto;']")
    public static WebElement frames;

    @FindBy(xpath="//button[@title='Manage my cookies']")
    public static WebElement managecookies;

    @FindBy(xpath="//button[contains(text(),'Reject all')]")
    public static WebElement reject;

    @FindBy(xpath = "xpath(\"//div[@class='fc-item__standfirst']/ancestor::div[@class='fc-item__content ']/following-sibling::a\")")
    public static WebElement headline;

    @FindBy(xpath ="//span[contains(text(),'Close')]")
    public static WebElement closeBtn;

    public void NewsPage(){
        PageFactory.initElements(driver,this);
    }

    public static void navigateNewsPage()
    {

            TestBase.sleep(3000);
            driver.findElement(By.xpath("//div[@id='sp_message_container_414203' and @style='display: block; height: 100%; top: auto;']")).click();
            driver.switchTo().frame("sp_message_iframe_414203");
            TestBase.sleep(1000);
            managecookies.click();
            driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
            driver.switchTo().defaultContent();
            driver.switchTo().frame("sp_message_iframe_106842");
            reject.click();
            driver.switchTo().defaultContent();
            headline.click();
            TestBase.sleep(100);
            JavascriptExecutor js=(JavascriptExecutor)driver;
            js.executeScript("arguments[0].click",closeBtn);
            TestBase.sleep(200);
            String url=driver.getCurrentUrl();
        URL urlnw= null;
        try {
            urlnw = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        key= urlnw.getPath();
            System.out.println(key);
            driver.close();

    }

}

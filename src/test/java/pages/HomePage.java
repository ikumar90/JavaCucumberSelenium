package pages;

import common.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.FileReaderHelper;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class HomePage extends TestBase {
    @FindBy(xpath = "//div[@id='sp_message_container_414203' and @style='display: block; height: 100%; top: auto;']")
    public WebElement autoframe;

     @FindBy(xpath = "/html/body/div/div[3]/div[2]/div/div[1]/p/p")
     public WebElement choice;

    @FindBy(xpath = "//button[@title='Yes, I’m happy']")
    public WebElement yes;

    @FindBy(xpath = "//h1[contains(text(),'News')]")
    public WebElement news;

    @FindBy(xpath = "//div[@class='fc-item__standfirst']/ancestor::div[@class='fc-item__content ']/following-sibling::a")
    public WebElement latestnews;

    @FindBy(xpath = "//span[contains(text(),'Close')]")
    public WebElement closeBtn;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }
    public static String key;

    public void loadHomePage(){
        FileReaderHelper fileReader=new FileReaderHelper();
        driver.get(fileReader.LoadUrl());
    }

    public void clkAutoFrame() {
        sleep(5000);
        autoframe.click();
        driver.switchTo().frame("sp_message_iframe_414203");
        String ele = choice.getText();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(yes));
        yes.click();
        driver.switchTo().defaultContent();
    }
    public  void latestNewsPage(){
        latestnews.click();
        sleep(4000);
        ClickOn(closeBtn);
        String url=driver.getCurrentUrl();
        URL urlnw= null;
        try {
            urlnw = new URL(url);
            key= urlnw.getPath();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
    }

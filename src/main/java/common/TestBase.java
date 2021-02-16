package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class TestBase {

   public static WebDriver driver;
   public static Properties prop;
   public static String key=null;

   public static void initialization() {
      try {
         prop = new Properties();
         String path = System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties";
         System.out.println(path);
         FileInputStream fis = new FileInputStream(path);
         prop.load(fis);
      } catch (IOException e) {
         e.printStackTrace();
      }

      String browserName = String.valueOf(prop.getProperty("browser"));
      if (browserName.equals("chrome")) {
         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().deleteAllCookies();
      }
      }
      public static void loadPage(){
         driver.get(prop.getProperty("url"));
         driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
         sleep(5000);
         driver.findElement(By.xpath("//div[@id='sp_message_container_414203' and @style='display: block; height: 100%; top: auto;']")).click();
         driver.switchTo().frame("sp_message_iframe_414203");
         sleep(1000);
         driver.findElement(By.xpath("//button[@title='Manage my cookies']")).click();
         driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
         driver.switchTo().defaultContent();
         driver.switchTo().frame("sp_message_iframe_106842");
         driver.findElement(By.xpath("//button[contains(text(),'Reject all')]")).click();
         driver.switchTo().defaultContent();
         sleep(100);
         WebElement headline=driver.findElement(By.xpath("//div[@class='fc-item__standfirst']/ancestor::div[@class='fc-item__content ']/following-sibling::a"));
         headline.click();
         sleep(100);
         WebElement closeBtn=driver.findElement(By.xpath("//span[contains(text(),'Close')]"));
         JavascriptExecutor js=(JavascriptExecutor)driver;
         js.executeScript("arguments[0].click",closeBtn);
         sleep(200);
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

         public static void sleep(long milliSec){
         try {
            Thread.sleep(3000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
      public static void  loadGoogle(){
      initialization();
      driver.get(prop.getProperty("google"));
       WebElement keyword=driver.findElement(By.name("q"));
         keyword.sendKeys(key);
         keyword.submit();

   }
   public static void closeBrowser(){
      driver.quit();
   }

}





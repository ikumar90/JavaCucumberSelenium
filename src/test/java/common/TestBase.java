package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.FileReaderHelper;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {

   public static WebDriver driver;

   public void ClickOn(WebElement element){
      JavascriptExecutor js= (JavascriptExecutor) driver;
      js.executeScript("arguments[0].click",element);
      }
   public static void initialization(){
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().deleteAllCookies();
      driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
   }

   public static void closeBrowser(){
      driver.close();
      driver.quit();
   }

   public static void sleep(long millisec){
      try {
         Thread.sleep(6000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
   }







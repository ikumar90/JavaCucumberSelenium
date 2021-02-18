package pages;

import common.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.FileReaderHelper;


public class GoogleSearchPage extends TestBase{
    @FindBy(name = "q")
    public static WebElement input;
    TestBase base=new TestBase();
    public GoogleSearchPage(){
        PageFactory.initElements(driver, this);
    }
    public static void launchGoogle() {
        FileReaderHelper fileReaderHelper = new FileReaderHelper();
        driver.get(fileReaderHelper.LaunchGoogle());
    }
    public static void searchPage(){
        input.sendKeys(HomePage.key);
        input.submit();
    }
}

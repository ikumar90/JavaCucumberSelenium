package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class googleSearchPage {
    public static WebDriver driver;

    @FindBy(name = "q")
    public static WebElement keyword;

    public static void searchGoogle() {
        keyword.sendKeys(NewsPage.key);
        keyword.submit();
    }
}

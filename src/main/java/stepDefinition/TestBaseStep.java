package stepDefinition;

import common.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.NewsPage;
import pages.googleSearchPage;

public class TestBaseStep {

    public static WebDriver driver;

    @Before
    public static void LaunchUrl(){
        TestBase.initialization();
    }

    @Test
    @Given("I navigate to first news article")
    public void i_navigate_to_first_news_article() {
        TestBase.loadPage();
        }

    @Test
    @Given("search in the google news")
    public void search_in_the_google_news() {
        TestBase.loadGoogle();
    }

    @After
    @Given("Close the browser")
    public void close_the_browser() {
       TestBase.closeBrowser();
    }

}


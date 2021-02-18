package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;

import static common.TestBase.driver;

public class HomePageStep {

    HomePage homePage=new HomePage();
    @Given("the news page is loaded")
    public void the_news_page_is_loaded() {
      homePage.loadHomePage();
    }
    @Given("go to first news in the news page")
    public void go_to_first_news_in_the_news_page() {
       homePage.clkAutoFrame();
    }
    @When("the first news is clicked and validated")
    public void the_first_news_is_clicked_and_validated() {
       homePage.latestNewsPage();
    }
}

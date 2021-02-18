package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.GoogleSearchPage;

public class GoogleSearchPageStep {
    GoogleSearchPage googleSearchPage=new GoogleSearchPage();
    @Given("search in the google news")
    public void search_in_the_google_news() {
        googleSearchPage.searchPage();
    }
    @When("I navigate to Google page")
    public void i_navigate_to_google_page() {
        googleSearchPage.launchGoogle();
    }

}

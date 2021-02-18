Feature: Validate the news
  Scenario: Validate the news in the guardian page
   Given the news page is loaded
    And  go to first news in the news page
    When the first news is clicked and validated
    And I navigate to Google page
    Then search in the google news

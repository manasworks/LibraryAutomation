@smoke @regression
Feature: As a data consumer, I want UI and DB book information are match.

  Scenario: Verify book information with DB
    Given user log in as a librarian
    And user goes to "Books" page
    When user searches for "Kod Da Vinchi" book
    Then book information must match with the Database
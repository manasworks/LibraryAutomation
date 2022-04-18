@smoke @regression
Feature: As a librarian, I want to know who is the most popular user

  Scenario: verify who is the most popular user who reads the most
    Given user log in as a librarian
    When user goes to "Books" page
    And user selects "500" records from dropdown
    And user gets most popular user who reads the most
    And execute a query to find the most popular user from DB
    Then verify that most popular user from UI is matching to DB
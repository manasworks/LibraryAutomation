@smoke @regression
Feature: As a librarian, I want to know the genre of books are being borrowed the most

  Scenario: verify the common book genre that’s being borrowed
    Given user log in as a librarian
    When user goes to "Books" page
    And user selects "500" records from dropdown
    And user gets most popular book genre
    And execute a query to find the most popular book genre from DB
    Then verify that most popular genre from UI is matching to DB
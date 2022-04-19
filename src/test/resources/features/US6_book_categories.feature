@smoke @regression
Feature: As a data consumer, I want UI and DB book categories match.

  Scenario: verify book categories with DB
    Given user log in as a librarian
    When user goes to "Books" page
    And take all book categories in UI
    And execute a query to get book categories
    Then verify book categories must match the book_categories table from DB
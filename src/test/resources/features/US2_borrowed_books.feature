@smoke @regression
Feature: As a librarian, I want to know the amount of borrowed books

  Background:
    Given user log in as a librarian

  Scenario: verify the amount of borrowed books
    When user take borrowed books number
    Then borrowed books number information must match with DB
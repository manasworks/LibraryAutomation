@regression
Feature: Login Functionality

  Background:
    Given user on the login page

  Scenario Outline: Login with valid credentials as Student and Librarian
    When user enters "<username>" and "<password>"
    And user click "Sign in" button
    Then Verify user see the "Library" page
    Examples:
      | username            | password |
      | student6@library    | NXhpXJdC |
      | student58@library   | WS3rm9xG |
      | librarian58@library | gxiYGKjy |
      | librarian32@library | 72kOI6Zl |

  Scenario Outline: Login with invalid credentials
    When user enters "<username>" and "<password>"
    And user click "Sign in" button
    Then Verify user see the error message
    Examples:
      | username            | password            |
      | student5@library    | *                   |
      | stude               | NXhpXJdC            |
      | !                   | librarian58@library |
      | admin               | admin               |
      | librarian32@library | Uplz5iPS            |


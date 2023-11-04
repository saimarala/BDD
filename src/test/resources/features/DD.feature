Feature: Data driven
  As a user of the OpenCart website
  I want to be able to log in with my account

  Background:
    Given : Open the app

  Scenario Outline: successful login with valid credentials
    #Given : Open the app
    * : I have entered valid credentials "<username>" and "<password>"
    When : I click on the login button
    Then : I should be logged in successfully

    Examples:
      | username | password  |
      | Admin    | admin123 |
      | Admin    | admin123  |
      | Admin    | admin123  |

  Scenario: PIM
    #Given : Open the app
    Given : I have enter login credentials
    |username|password|
    | Admin    | admin123 |
    * : I click on the login button
    When : Click on PIM
    Then : Should be display PIM page

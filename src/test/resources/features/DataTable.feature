Feature: Data driven
  As a user of the OpenCart website
  I want to be able to log in with my account

  Background:
    Given : Open the app


  Scenario Outline: Unsuccessful login with invalid or empty credentials
    And : I have entered invalid "<username>" and "<password>"
    When : I click on the login button
    #Then : I should be logged in successfully

    Examples:
      | username | password  |
      | Admin    | admin1234 |
      | Admin    | admin12   |
      | Admin    | admin123  |
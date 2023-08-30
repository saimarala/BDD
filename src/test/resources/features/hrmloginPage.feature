Feature: Orange hrm login
  As a user of the OpenCart website
  I want to be able to log in with my account
  Scenario: Successful login with valid credentials
    Given : Open the app
    And : I have entered a valid username and password
    When : I click on the login button
    Then : I should be logged in successfully
    When : Click on admin
    Then : Should be display admin page

Feature: Orange hrm home page
  As a user of the OpenCart website
  I want to be able to log in with my account

  Background:
    Given : Open the app
    And : I have entered a valid username and password
    When : I click on the login button
    Then : I should be logged in successfully

  Scenario: Successful login with valid credentials

    When : Click on admin
    Then : Should be display admin page

  Scenario: PIM
    When : Click on PIM
    Then : Should be display PIM page

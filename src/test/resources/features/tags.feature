@all
Feature: tags
  As a user of the OpenCart website
  I want to be able to log in with my account

  Background:
    Given : Open the test app
 @smoke
  Scenario: smoke
    Given : start smoke
    When : click on login
    Then : login success

  @regression
  Scenario: regression
    Given : start regression
    When : click on login
    Then : login success

    @E2E
  Scenario: E2E
    Given : start e2e
    When : click on login
    Then : login success
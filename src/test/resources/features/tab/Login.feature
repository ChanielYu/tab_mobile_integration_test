@android
Feature: Login Test

  Background: Enter home screen
    Given Splash screen launched
    And I grant location permission
    And I ignore update
    And I confirm over 18

  Scenario: Login
    When I pass whats new screen
    And I am in Home screen
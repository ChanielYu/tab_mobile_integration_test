Feature: Login Test

  Background: Enter home screen

  @android
  Scenario: Splash screen
    Given Splash screen launched
    And I grant location permission
    # We have done this in other steps
    #And I ignore update
    And I confirm over 18

  @ios
  Scenario: Splash screen
    Given Splash screen launched

  @android @ios
  Scenario: Login
    When I pass whats new screen
    And I am in Home screen
    And User is not logged in
    Then I click login button
    When I am in Login screen
    Then I login with user "1274185" password "tabtest12"

  @android @ios
  Scenario: Verify login
    When I am in Home screen
    Then User is logged in
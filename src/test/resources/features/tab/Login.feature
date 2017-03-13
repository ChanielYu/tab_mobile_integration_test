Feature: Login Test
  Background: Pass splash screen
    Given Splash screen launched
    Then I grant location permission
    And I confirm over 18

  @android @ios
  Scenario: Login
    When I pass whats new screen
    And I am in Home screen
    And User is not logged in
    Then I click login button
    When I am in Login screen
    Then I login with user "1274185" password "tabtest12"
    When I am in Home screen
    Then User is logged in

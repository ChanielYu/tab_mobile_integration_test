Feature: Left Home menu test

  Background:
    Given Splash screen launched
    And I grant location permission
    # We have done this in other steps
    #And I ignore update
    And I confirm over 18

  @android @ios
  Scenario: non logged in user
    When I pass whats new screen
    And I am in Home screen
    Then Open left menu
    When Login/Join Now is displayed
    And Home/Racing/Sport/Watch links are displayed
    And TAB links are displayed
    And Other links are displayed
    And links are valid

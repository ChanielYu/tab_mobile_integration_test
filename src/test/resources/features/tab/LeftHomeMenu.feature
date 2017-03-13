@android
Feature: Left Home menu test
  Background: Enter home screen
    Given Left menu is open
  Scenario: non logged in user
    Then  Login/Join Now is displayed
    And   Home/Racing/Sport/Watch links are displayed
    And TAB links are displayed
    And Other links are displayed
    And links are valid

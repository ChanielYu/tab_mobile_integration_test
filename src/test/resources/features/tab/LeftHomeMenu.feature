@android
Feature: Left Home menu test
  Background: Enter home screen
    Given Left menu is open
  Scenario: non logged in user
    When  user is not logged in
    Then  Login/Join Now is displayed
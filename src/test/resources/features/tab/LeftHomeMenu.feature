@android
Feature: Left Home menu test
  Background: Enter home screen
    Given Left menu is open
  Scenario: non logged in user
    Then  Login/Join Now is displayed
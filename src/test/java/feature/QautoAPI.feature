Feature: API features

  Scenario: 1 Authorization checks
    Given Register new user in the system
    When Login with new User credentials
    Then Logout with logged in user
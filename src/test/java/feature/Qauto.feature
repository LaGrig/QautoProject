Feature: Homepage feature

  Scenario: Verify homepage objects are presents
    Given I navigate to the Home page
    Then Check if current URL is HomePage URL

  Scenario: Check if all page elements on page are present
    Given I navigate to the Home page
    Then Check all page element on page are present

  Scenario: Check login as Guest is possible
    Given I navigate to the Home page
    When Click on Guest Login button
    Then Check if I logged in as Guest

    Scenario: Check login as Registered User is possible
      Given I navigate to the Home page
      When  Home page is loaded
      Then Click on "Sign in" button
      Then Fill in User login credentials
      And  Submit "Sign in" form
      Then Check if I Signed in as Registered User

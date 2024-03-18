Feature: Homepage feature

  Scenario: 1 Verify Home page opens fine
    Given I navigate to the Home page
    Then Check if current URL is HomePage URL

  Scenario: 2 Check if all page elements on Home page are presents
    Given I navigate to the Home page
    Then Check all page element on Home page are present

      #Не работает проверка элементов на странице в headless
  Scenario: 3 Check if login and logout as Guest is possible
    Given I navigate to the Home page
    When Click on Guest Login button
    Then Check if I logged in as Guest
    Then User logout and Home Page Url check

      #Не работает проверка элементов на странице
  Scenario: 4 Check if login and logout as Registered User is possible
    Given I navigate to the Home page
    When Click on Sign in button
    And Fill in User login credentials
    Then Submit Sign in form
    And Check if I logged in as User
    Then User logout and Home Page Url check


  Scenario: 5 Check New User registration
    Given I navigate to the Home page
    When Click on SingUp button
    And Fill in New user credentials2
    And Click Register button
    Then Check if current URL is UserPage-Garage URL
    And Profile User name is present on Profile page
Feature: Login functionality

  Scenario Outline: Valid login
    Given browser is open
    When I enter valid username "Admin" and password "admin123"
    And I click on login
    Then I should be redirected to the dashboard
    When I navigate to the Admin tab
    And I get the current number of records
    And I add a new user with usernameInput "TestUser123" and employeeInput "Test" and passwordInput "helloA+1"
    Then the number of records should increase by 1
    When I search for the user "TestUser123"
    And I delete the user "TestUser123"
    Then the number of records should decrease by 1
    


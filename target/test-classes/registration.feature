Feature: Functional Scenarios of herokuapp
  @Test1
  Scenario: Login validation with valid username and invalid password
    Given User is on Login Page
    When  User enters valid "tomsmith" and invalid "password"
    Then  Verify User login status

  @Test2
  Scenario: Login validation with invalid username and valid password
    Given User is on Login Page
    When  User enters invalid "tomsmithkat" and valid "SuperSecretPassword!"
    Then  Verify User login status

  @Test3
  Scenario: Login validation with valid username and valid password
    Given User is on Login Page
    When  User enters valid "tomsmith" and valid "SuperSecretPassword!"
    Then  Verify User login status


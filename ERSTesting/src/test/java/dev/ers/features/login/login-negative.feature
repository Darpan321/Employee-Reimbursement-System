Feature: Login

  Scenario: Login Correct Username Wrong Password
    Given The user is on the login page
    When The user types in fam@ers.com into the emailid input
    When The user types in fam123 into the password input
    When The user clicks on the login button
    Then The user should see an alert saying they have the wrong password

  Scenario: Login Wrong Username Correct Password
    Given The user is on the login page
    When The user types in fam@ers into the emailid input
    When The employee types in fam1 into the password input
    When The employee clicks on the login button
    Then The employee should see an alert saying no user with that emailid found
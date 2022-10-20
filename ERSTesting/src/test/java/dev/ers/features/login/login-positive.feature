Feature: Login

  Scenario Outline: Login with correct credentials
    Given The user is on the login page
    When  The user types "<emailid>" into emailid input
    When The user types "<password>" into password input
    When The user clicks on the login button
    Then the user should be on the "<role>" page
    Then The user should see their name "<fname>" on the home page

    Examples:
      | emailid          | password   | role             | fname |
      | fam@ers.com      | fam12345   | FinancialManager | fam   |
      | dp@gmail.com     | dp12345    | Employee         | dell  |
      | rock@gmail.com   | rock12345  | Employee         | rock  |
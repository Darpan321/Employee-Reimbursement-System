Feature: Navigation

# Depending on how the associates code this one, all or most of the scenarios should fail. Naming conventions
# Naming conventions in this feature file do not match the actual web pages

  Background: Logged in as a FinancialManager
    Given The financialmanager is logged in as a financialmanager
    Given The financialmanager is on the home page

  Scenario: Home Page Links Visible
    Then The financialmanager should see links for Home, Reimbursement and Logout

  Scenario: Back Navigation
    When The financialmanager clicks on Reimbursement
    Then The title of the page should be Manager Reimbursement
    When The financialmanager clicks the browser back button
    Then The financialmanager should be on the home page and the title of page is Manager Homepage

  Scenario Outline: All Links Viable
    When The manager clicks on "<link>"
    Then The title of page should be "<title>"

    Examples:
      | link           | title                 |
      | Home           | Manager Homepage      |
      | Reimbursement  | Manager Reimbursement |
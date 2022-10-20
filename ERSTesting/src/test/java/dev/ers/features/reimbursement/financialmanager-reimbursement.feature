Feature: View Reimbursements
  Background:
    Given The financialmanager is on the reimbursement page

  Scenario: View Reimbursement details
    When The financialmanager presses on view
    Then financialmanager should be redirected to Manager View Reimbursement page
    Then financialmanager should see reimbursement details
    When The financialmanager presses the browser back button
    Then The financialmanager should be on the home page and the title of page is Manager Reimbursement

  Scenario: Update reimbursement status to approved
    When The financialmanager presses on view
    Then financialmanager should be redirected to Manager View Reimbursement page
    Then financialmanager should see reimbursement details
    Then financialmanager presses on Approve
    Then financialmanager enters a reason to approve
    Then financialmanager presses on Update

  Scenario: Update reimbursement status to rejected
    When The financialmanager presses on view
    Then financialmanager should be redirected to Manager View Reimbursement page
    Then financialmanager should see reimbursement details
    Then financialmanager presses on Reject
    Then financialmanager enters a reason to reject
    Then financialmanager presses on Update
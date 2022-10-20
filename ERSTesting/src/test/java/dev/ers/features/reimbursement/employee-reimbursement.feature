Feature: View Reimbursements
  Background:
    Given The employee is on the reimbursement page

  Scenario: View Reimbursement details
    When The employee presses on view
    Then employee should be redirected to Manager View Reimbursement page
    Then employee should see reimbursement details
    When The employee clicks the browser back button
    Then The employee should be on the home page and the title of page is Employee Reimbursement
  Scenario: View Reimbursement Amount
    When The employee is on the reimbursement page
    Then The employee views reimbursement amount
  Scenario: Submit a Reimbursement request
    When The employee presses on submit request
    Then employee should be redirected to Employee Reimbursement page
    Then employee types in "2022-11-10" into the date
    Then employee types in "05:00" into the time
    Then employee types in "California" into the location
    Then employee types in "New Description" into the description
    Then employee types in "120" into the cost
    Then employee types in "No Grading Format" into the grading format
    Then employee selects "2" for event type from drop down
    Then employee types in "Want to Attend" into the justification
    Then employee clicks on submit
    Then A alert should appear

  Scenario: Update reimbursement
    When The employee presses on update
    Then employee should be redirected to Employee Reimbursement page
    Then employee should see all details inputted
    Then employee types in "2022-11-11" into the date
    Then employee types in "03:00" into the time
    Then employee types in "Los Angeles" into the location
    Then employee types in "New Description Updated" into the description
    Then employee types in "130" into the cost
    Then employee types in "No Grading Format" into the grading format
    Then employee selects "2" for event type from drop down
    Then employee types in "Want to Attend Updated" into the justification
    Then employee clicks on submit
    Then A alert should appear
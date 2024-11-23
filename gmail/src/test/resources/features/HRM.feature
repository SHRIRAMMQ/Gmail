Feature: HRM Application automation using Cucumber

  @smoke @regression
  Scenario: AddEmployee
    When addEmployee

  @smoke
  Scenario: EditEmployee
    When editEmployee

  @regression
  Scenario: DeleteEmployee
    When deleteEmployee

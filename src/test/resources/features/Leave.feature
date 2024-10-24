Feature: Leave Module Testing

  Scenario: Login as Admin and Navigate to Lave Section
    Given I am on the OrangeHRM login page
    When I enter valid admin credentials
    And I navigate to the Laave section
    Then I should see the Leave page title

  Scenario Outline: Apply for a leave and ensure detailed validation in My Leave section
    Given I am on the OrangeHRM login page
    When I enter valid admin credentials
    And I navigate to the Leave section
    And I apply leave with type "<LeaveType>" start from "<FromDate>" to "<ToDate>" with partial days "<PartialDays>", duration "<Duration>", and comments "<Comments>"
    Then I should see the leave record on My Leave

    Examples:
      | LeaveType  | FromDate  | ToDate     | PartialDays | Duration           | Comments             |
      | CAN - FMLA | 2024-26-10 | 2024-28-10 | All Days    | Half Day - Morning | Apply Leave All Days |
Feature: Admin Module Testing

  Scenario: Login as Admin and Navigate to Admin Section
    Given I am on the OrangeHRM login page
    When I enter valid admin credentials
    And I navigate to the Admin section
    Then I should see the Admin page title

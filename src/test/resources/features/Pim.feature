Feature: PIM Module Testing

  Scenario: Login as Admin and Navigate to PIM Section
    Given I am on the OrangeHRM login page
    When I enter valid admin credentials
    And I navigate to the PIM section
    Then I should see the PIM page title
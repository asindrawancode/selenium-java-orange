Feature: Leave Module Testing

  Scenario: Login as Admin and Navigate to Lave Section
    Given I am on the OrangeHRM login page
    When I enter valid admin credentials
    And I navigate to the Laave section
    Then I should see the Leave page title
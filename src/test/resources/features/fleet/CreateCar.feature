Feature: As user, I want to be able to create new cars

  @add_car
  Scenario: 1. Add some car
    Given user is on the login page
    And user logs in as a "store manager"
    And user navigates to "Fleet" and "Vehicles"
    And user clicks on create car button
    When user adds new vehicle information
    | License Plate | SDET |
    | Model Year    | 2021 |
    And user clicks on save and close button

    @negative_SO
  Scenario Outline: 1. Add some car
    Given user is on the login page
    And user logs in as a "<role>"
    And user navigates to "Fleet" and "Vehicles"
    And user clicks on create car button
    When user adds new vehicle information
      | License Plate | <License Plate> |
      | Model Year    | <Model Year> |
    And user clicks on save and close button

    Examples: test data
      | License Plate | Model Year | role          |
      | Florida       | 2020       | store manager |
      | QA            | 2021       | store manager |
      | SDET          | 2025       | store manager |

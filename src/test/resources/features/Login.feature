@login
Feature: As user, I want to be able to login under different roles

  # Background is a test pre-condition
  # will be executed before every scenario in the particular feature file
    Background:
      Given user is on the login page

    Scenario: Login as a sales manager
      When user logs in
      Then user should see dashboard page

    @parametrized_test
    Scenario: Parametrized login
      When user logs in as a "store manager"
      Then user should see dashboard page

      @s_o @with_two_columns
 Scenario Outline: Parametrized login as <role>
    When user logs in as a "<role>"
    Then user should see "<page_title>" page
  Examples:
   | role          | page_title      |
   | sales manager | Dashboard       |
   | store manager | Dashboard       |
   | driver        | Quick Launchpad |

    @negative_login
    Scenario: Invalid password
      When user logs in with "storemanager85" username and "wrong" password
      Then user verifies that "Invalid user name or password." message is displayed

      @negative_scenario_outline
      Scenario Outline: Invalid password
        When user logs in with "<username>" username and "<password>" password
        Then user verifies that "<message>" message is displayed

        Examples: data set
        | username | password | message                       |
        | wrong    | bad      | Invalid user name or password. |
        | worng    | bad      | Invalid user name or password. |
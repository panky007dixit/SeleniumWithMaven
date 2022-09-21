Feature: First feature file

  Scenario: First scenario in first feature file
    Given I click on login link
    When I enter valid username and password
    Then I am able to login successfully

  Scenario Outline: Exception Handle Test
    Given I test exception for <Count>
    And exception is validated successfully
    @round1
    Examples:
    |Count|
    |0|
    |1|
    @round2
    Examples:
      |Count|
      |1|
      |1|
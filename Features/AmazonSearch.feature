Feature: Amazon Search Feature

@quick_example
Scenario: Search QA books
* Do the full test

@test
Scenario: Search QA books
Given I access amazon page
When I search for QA books
Then I get more than 1 results


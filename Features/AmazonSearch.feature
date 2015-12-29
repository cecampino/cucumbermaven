Feature: Amazon Search Feature

@review
Scenario: Search QA books
Given I access amazon page
When I search for QA books
Then I get more than 1 results
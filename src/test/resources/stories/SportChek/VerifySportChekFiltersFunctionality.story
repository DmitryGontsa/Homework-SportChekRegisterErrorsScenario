Meta:
@SportChek_tests

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: User verify filters functionality with 'dropping all filters' test case.

Given user opened 'Sportchek products main page'
When user clicks to item by brand 'ROSSIGNOL'
Then user verify products titles according chosen brand displayed: 'Rossignol'
And user clicks to 'CLEAR ALL' button
And user verify that all filters dropped and certain quantity items present displayed: '61 ITEMS'
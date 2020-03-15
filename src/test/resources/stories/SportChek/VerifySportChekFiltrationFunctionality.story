Meta:
@SportChek_tests

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify products titles according to the chosen brand on SportChek website

Given user opened 'SportChek' website
When user selected product item by BRANDS 'ATOMIC'
Then user checks products titles by chosen brand displayed: 'Atomic'
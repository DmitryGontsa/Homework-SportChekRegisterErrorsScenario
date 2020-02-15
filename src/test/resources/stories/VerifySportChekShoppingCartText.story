Meta:
@SportChek_tests

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify Shopping Cart text, when user hover mouse on shopping cart icon.

Given user opened web site, using next url: 'https://www.sportchek.ca/'

When user hovering mouse on shopping cart icon

Then user checks following message displayed: 'YOUR SHOPPING CART IS CURRENTLY EMPTY.'
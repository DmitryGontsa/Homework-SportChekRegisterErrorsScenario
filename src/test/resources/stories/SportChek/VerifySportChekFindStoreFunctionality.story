Meta:
@SportChek_tests

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify error message, when user type the name of non-existent store.

Given user is opened web site, using following url: 'https://www.sportchek.ca/'

When user clicks 'Your Store: Choose now' button
And user type next store name in search input: 'Vidivan'
And user clicks on search button

Then user checks following error message displayed: 'We're sorry, there are no stores near your location. Please try reentering location'
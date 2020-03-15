Meta:
@SportChek_tests

Narrative: User checks Sorting By Rating functionality
           Expected sorting:
           100 - five stars
           80 - four stars
           60 - three stars
           40 - two stars

Scenario: Verify sorting by rating functionality of SportChek products items

Given user opened 'Sportchek Products Page'
When user selected 'Sort By' button
And user selected 'Rating From High to Low' item
Then user checks Products Items sorted by 'Rating From High to Low' displayed: '100, 100, 100, 100, 80, 80, 80, 60, 40'
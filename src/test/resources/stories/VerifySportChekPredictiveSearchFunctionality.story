Meta:
@SportChek_tests

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify predictive search, when user type product title.

Given user is opened site, using following url: 'https://www.sportchek.ca/'

When user type product name in search field: 'Nike'

Then user checks predictive search, with following menu items are displayed:
| menuItems          |
| Nike               |
| nike shoes         |
| nike hoodie        |
| nike pants         |
| nike socks         |
| nike shorts        |
| nike running shoes |
| nike sandals       |

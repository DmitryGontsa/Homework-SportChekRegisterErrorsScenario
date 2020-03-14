Meta:
@SportChek_tests

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify product items on Shopping Cart page, with randomly functionality.

Given user opened 'Product Page' on Sportchek website
When user selected product size
And user clicked on 'ADD TO CART' button
And user clicked on 'SHOPPING CART' icon
Then user verify product items on Shopping Cart page, with following data displayed:
| productTitle                                | productColour | productSize | productQuantity | productPrice | productEstimatedTotalPrice |
| Helly Hansen Boys' Cascade Insulated Jacket | QUIET SHADE   | 8           | 1               | 132.98       | 132.98                     |
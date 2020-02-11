Meta:
@SportChek_tests

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify users error message on Register Popup Panel,
when user try to type own registration data.

Given user opened site, using following url: 'https://www.sportchek.ca/'

When user clicks 'Sign In/Create Account' button
And user clicks 'Register Now' button on Sign In Popup Panel
And user is trying to register on Register Popup Panel, using following data:
| Email          | ConfirmEmail          | Password          | ConfirmPassword          |
| <EmailExample> | <ConfirmEmailExample> | <PasswordExample> | <ConfirmPasswordExample> |

Then user checks following errors messages displayed:
{transformer=FROM_LANDSCAPE}
| EmailError           | <EmailErrorExample>           |
| ConfirmEmailError    | <ConfirmEmailErrorExample>    |
| PasswordError        | <PasswordErrorExample>        |
| ConfirmPasswordError | <ConfirmPasswordErrorExample> |

Examples:
| EmailExample | ConfirmEmailExample | PasswordExample | ConfirmPasswordExample | EmailErrorExample                                                | ConfirmEmailErrorExample                                         | PasswordErrorExample                        | ConfirmPasswordErrorExample                 |
| XX           | YY                  | ZZ              | ZZ                     | Please enter your email address in this format: name@example.com | Please enter your email address in this format: name@example.com | Your password must be 8-40 characters long. | Your password must be 8-40 characters long. |
| abc          | def                 | ghi             | jkl                    | Please enter your email address in this format: name@example.com | Please enter your email address in this format: name@example.com | Your password must be 8-40 characters long. | Your password must be 8-40 characters long. |
| 123          | 456                 | 789             | 101112                 | Please enter your email address in this format: name@example.com | Please enter your email address in this format: name@example.com | Your password must be 8-40 characters long. | Your password must be 8-40 characters long. |
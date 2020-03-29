Meta:
@API_tests

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal


Scenario: Verify user is able to create new Profile

Given user creates new 'Profile', using Api:
| name                      | rating | demand |
| Java Programming Language | High   | 90%    |
Then new profile should be created



Scenario: Verify user is able to update existing Profile

Given user creates new 'Profile', using Api:
| name                    | rating | demand |
| C# Programming Language | High   | 80%    |
When user update existing profile, using following data:
| name                        | rating | demand |
| Python Programming Language | High   | 90%    |
Then following profile should be updated



Scenario: Verify user is able to filter all Profiles, by filter data

Given user creates new 'Profile', using Api:
| name                     | rating | demand |
| C++ Programming Language | Middle | 65%    |
And user creates new 'Profile', using Api:
| name                      | rating | demand |
| Java Programming Language | High   | 90%    |
And user creates new 'Profile', using Api:
| name                      | rating | demand |
| Java Programming Language | High   | 90%    |
And user creates new 'Profile', using Api:
| name                      | rating | demand |
| Java Programming Language | High   | 90%    |

When user filters retrieved Profiles by next filter params:
| name                      | rating |
| Java Programming Language | High   |
Then each filtered Profile should contain such data only:
| name                      | rating |
| Java Programming Language | High   |





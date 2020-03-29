Meta:
@API_tests

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal


Scenario: Verify user is able to create new Comment

Given user creates new 'Comment', using API:
| body                                 | level | postId |
| Automation testing with BDD approach | High  | 7789   |
Then new comment should be created



Scenario: Verify user is able to update existing Comment

Given user creates new 'Comment', using API:
| body                                             | level  | postId |
| Automation testing with usual Selenium WebDriver | Middle | 7778   |
When user update existing comment, using following data:
| body                                           | level | postId |
| Automation testing with Serenity BDD framework | High  | 7778   |
Then following comment should be updated



Scenario: Verify user is able to filter all Comments, by filter data

Given user creates new 'Comment', using API:
| body                            | level | postId |
| Automation testing with Cypress | High  | 7777   |
And user creates new 'Comment', using API:
| body                                           | level | postId |
| Automation testing with Serenity BDD framework | High  | 7778   |
And user creates new 'Comment', using API:
| body                                           | level | postId |
| Automation testing with Serenity BDD framework | High  | 7778   |
And user creates new 'Comment', using API:
| body                                           | level | postId |
| Automation testing with Serenity BDD framework | High  | 7778   |

When user filters retrieved Comments by next filter params:
| body                                           | level |
| Automation testing with Serenity BDD framework | High  |
Then each filtered Comment should contain such data only:
| body                                           | level |
| Automation testing with Serenity BDD framework | High  |
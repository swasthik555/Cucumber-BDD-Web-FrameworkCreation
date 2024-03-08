Feature: Application Login

Scenario: Login with valid credentials
Given Open the Browser
And Navigate to the Login page
When User enters a username as "spacestudio555@gmail.com" and a password as "8971059266" into the fields
And User clicks on the Login button
Then Verify the user is able to successfully login
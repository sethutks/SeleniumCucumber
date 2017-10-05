Feature: Login into the Leaftaps Application

Background:
Given Launch the chrome browser 
And Enter URL http://leaftaps.com/opentaps
And Maximize
And Set timeout

Scenario: Login to Leaftaps (Positive)
When Enter User Name DemoSalesManager
And Enter Password crmsfa
And Click Login
Then Verify the Welcome Message

Scenario: Login to Leaftaps (Negative)
When Enter User Name DemoSalesManager1
And Enter Password crmsfa1
And Click Login
But Login should not be successful
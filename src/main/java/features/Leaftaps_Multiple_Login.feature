Feature: Login into the Leaftaps Application

Background:
Given Launch the chrome browser 
And Enter URL http://leaftaps.com/opentaps
And Maximize
And Set timeout

Scenario Outline: Login to Leaftaps (Positive)
When Enter User Name <userName>
And Enter Password <password>
And Click Login
Then Verify the Welcome Message

Examples:
|userName			|password	|
|DemoSalesManager	|crmsfa		|
|DemoCSR			|crmsfa		|
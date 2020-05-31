Feature: Create New changeRequest using Rest Assured(ServiceNow)

Scenario: Create ChangeRequest(with No Body)

Given End Point is loaded
And Basic Authorization is initiated
When Content-Type is JSON
And Send request as Post
Then Confirm the response status code is 201

Scenario: Create ChangeRequest(With Body as Json String)

Given End Point is loaded
And Basic Authorization is initiated
When Content-Type is JSON
And Send Body as String in JSON format
And Send request as Post
Then Confirm the response status code is 201

Scenario: Create ChangeRequest(With Body as XML String)

Given End Point is loaded
And Basic Authorization is initiated
When Content-Type is XML
And Send Body as String in XML format
And Send request as Post
Then Confirm the response status code is 201

Scenario Outline: Create ChangeRequest(With different files)

Given End Point is loaded
And Basic Authorization is initiated
When Content-Type is JSON
And Send Body as File<file>
And Send request as Post
Then Confirm the response status code is 201

Examples:
|file|
|data1.json|
|data2.json|

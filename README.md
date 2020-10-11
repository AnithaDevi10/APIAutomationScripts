# APIAutomationScripts

Various Public API's that are being exposed, are being tested by using API credentials(like using OAUTH2.0 token,Client Secret Id) that are 
being used(different level of privileges being used for different set of users) for different people like sandbox testers,third party API developers,paid
regular users of API's.


Consider a scenario where you are using the Book My Show app. Now, obviously, this application needs a lot of Input data, as the data present in the 
application is never static. Either it is movies getting released on a frequent basis, or various cities showing different languages movies at various times
of the day. It’s never static which implies the fact that data is always changing in these applications.

Now, where do you think we get this data from?

Well, this data is received from the Server or most commonly known as a Web-server. So, the client requests the server for the required information, via an API, 

and then, the server sends a response to the client.

Over here, the response sent to the client is in the form of an HTML Web Page. But, do you think this is an apt response that you would expect when you
send a request?

Well, I am assuming the fact that you would say NO. Since,  you would prefer the data to be returned in the form of a structured format, rather
than the complete Web page.

So, for such reasons, the data returned by the server, in response to the request of the client is either in the format of JSON or XML. Both JSON and XML 
formats have a proper hierarchical structure of data.

Now, this sounds quite simple, right?

But, the only issue which is present in this framework until now is that you have to use a lot of methods to get the required information. 
To the fact, using these methods to retrieve information, becomes quite cumbersome when you require complex data.

So, this is where REST API comes into the picture. The REST API creates an object, and thereafter sends the values of an object in response to the client. 
It breaks down a transaction in order to create small modules. Now, each of these modules is used to address a specific part of the transaction. 
This approach provides more flexibility but requires a lot of effort to be built from the very scratch.


# SkyGiraffe  Slack app

### What is Skygiraffe Slack app?

SkyGiraffe’s Slackbot allows you to interact with our REST Endpoint directly through Slack.

This connectivity facilitates access to enterprise data and business functions through the Slack interface in a completely secure manner. A few use cases as shown in the video below illustrate both the simplicity and wide scope of functionality that can be exposed on Slack with this SkyGiraffe bot.

>For example:

<<VIDEO>>

### What do I need to know about the SkyGiraffe platform to get started?

Think of SkyGiraffe as a **black-box enterprise data connector** that enables the following:

* Enterprise Authentication: Allows you have a single endpoint that integrates with enterprise Identity providers such as AD, ADFS, Okta, and other custom providers while passing on permissions for on-prem and cloud enterprise data sources. 
* Data Connectivity: Pulls and updates data from backend systems, e.g., Oracle, SAP, Salesforce, MSSQL, REST APIs, Office 365, Google apps and many other systems. 
* Create Applications: Build simple and complex workflows that involve one or more systems and enables read and write operations with the SkyGiraffe studio. 

### OK, I have some background now. How do I get started?

* Please email support@skygiraffe.com to receive a link to SkyGiraffe Studio. You must have Windows to install the Studio. 
* Follow the installer to properly install the Studio (5 min).  
* Log in the Studio and add your first data source (further instructions here). 
* You can start with a test data source to start developing your Slackbots. Eventually, this will be your actual data source, but to get started, you can use Google Sheets as a test. You can mock up some data there and connect to it via our generic REST API for Google sheets found here (github link for google sheets generic REST API code). 
* Once you have completed the above 2 steps, please see this video below to create your first SkyGiraffe app. 

<<VIDEO>>

* You can test your app by downloading the SkyGiraffe app from the Apple/Google store and logging in with the username/password that you used to set up the studio.
	* [iOS app](https://itunes.apple.com/us/app/skygiraffe/id716844831?mt=8)
	* [Android app](https://play.google.com/store/apps/details?id=com.skygiraffe.operationaldata&hl=en) 

### So I’ve built an app in SkyGiraffe...How do I get SkyGiraffe functionality that I created on Slack?

Cool. Here are the steps for that.

* Go https://api.slack.com/apps/new and enter the required information.  
* Go to ‘App Credentials’ and enter the redirect url - https:/slack2.skygiraffe.com/ 
* Go to Interactive Messages and provide the same URL as above:
* Next, go to slash commands and enter details. You can choose any slash command that you like, for example, “/mysg”. But make sure the redirect URL is the same as in the above steps.

You are now ready to test. The sequence of steps for testing will assume your slash command is called “/mysg”.

1. Enter command /mysg in slack. 
2. You will be asked to authorize SkyGiraffe so that it can use Slack API. 
3. You will then be asked to enter your SkyGiraffe credentials. 
4. The Slack client will open in a browser and you can start with the command /mysg apps. This returns all SkyGiraffe applications you have access to, as interactive buttons. 

The result will look something like this:

![SkyGiraffe applications on Slack] (path)
5. You can start clicking on these buttons to carry on the with the workflow. 


###Sounds good but how do I get started with my own deployment?

That’s exactly why we have open sourced this code! Fork it, enhance it if you want, and get going.

All you will need is:

1. JAVA (we used 1.8) 
2. Web container - Tomcat to deploy your JAVA code 
3. REDIS - for caching purposes 
4. Certificate authority certified SSL certificate 
5. Public URL that Slack can reach over SSL 

Once you have these components and have built the war file from the code, follow the same steps from the test Slackbot deployment. The only difference being that you have your own URL instead of ours.

Please contact us at support@skygiraffe.com with any questions or concerns.

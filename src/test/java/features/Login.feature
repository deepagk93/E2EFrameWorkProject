Feature: Application login 

Scenario Outline: Home page default login 
	Given Initialize Browser with chrome 
	And Navigate to the url "https://rahulshettyacademy.com/" 
	And Click on login link in Home Page 
	When User enters <username> and <password> for the site 
#	Then Verify that user is suceesfully logged in 
	And Close Browser 
	
	Examples: 
		|username					|password	|
		|deepa.gmenon93@gmail.com	|Analytics |
		|test99@gmail.com	|123456 |		
		

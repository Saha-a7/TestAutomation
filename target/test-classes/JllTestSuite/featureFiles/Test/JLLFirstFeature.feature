Feature: JLL Launching the website first


	@jll1
  Scenario Outline: Launching the JLL site and accept the cookies
  	

   Given TestCaseID Is "<TC_ID>" and TestDataSheet Is "<TestDataSheet>"
    And   open Browser and enter url 
    When Accept the cookies
    Then Click on the Country drop down
  
  Examples:
	|TC_ID|      |TestDataSheet|
	|JLL_FirstTest| |JLL|
	
	
	




  
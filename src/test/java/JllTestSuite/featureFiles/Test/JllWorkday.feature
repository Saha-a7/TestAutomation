Feature: Validate the Workday component

	@jll2
  Scenario Outline: Workday
  
    Given TestCaseID Is "<TC_ID>" and TestDataSheet Is "<TestDataSheet>"
    And   open Browser and enter url 
    When  Accept the cookies
    Then Click on Career nav item
    Then Locate the HtmlForm component
    And Click on I am Looking for field
    And Validate Country dropdown is preset to users current site
     

   Examples:
	|TC_ID|      |TestDataSheet|
	|JLL_Workday|   |JLL|

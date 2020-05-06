# Feature Definition Template

Feature: Validate API’s are fit for purpose in the use of the exchange rate for financial reasons

	Background:
		Given Go rest API is up and running
  Scenario: assert the succes status of the latest date data response
    When I hit the api with get request and end point as "/latest"
    Then API returned the status code as 200
 @smoke
  Scenario: assert the correct response - content of the latest date data response
    When I hit the api with get request and end point as "/latest?base=USD"
    Then base value should be "USD"

  Scenario: assert the correct response while passing incorrect or incomplete url of the latest date data 
    When I hit the api with get request and end point as "/latest?base=XXX"
    Then API returned the status code as 400
    And error message displayed as "Base 'XXX' is not supported."
    
   Scenario: assert the succes status of the past conversion rates response
   	When I hit the api with get request and end point as "/2010-01-12"
    Then API returned the status code as 200

  Scenario: assert the correct response - content of the past conversion rates response
    When I hit the api with get request and end point as "/2010-01-12?base=INR"
    Then base value should be "INR"

  Scenario: assert the current date in response while passing future date 
    When I hit the api with get request and end point as "/2040-01-12"
    Then API should return current date rates 
#Author: your.email@your.domain.com

# Scaenrio Outline - same scaenrio multple times with different combinations of endpoints
# Background - Given statement is same for all sceanrios
# tags - used as per the requirement

Feature: Status code verfiaction
  Background:
		Given Go rest API is up and running
 
  Scenario Outline: Get status code
    When I hit the api with get request and end point as "<endpoint>"
    Then API returned the status code as "<status>"
 @smoke
    Examples: 
      | endpoint  | status |
      | /latest |    HTTP/1.1 200 OK |
      | /latest?base=USD |    HTTP/1.1 200 OK |
     
 
      
     
     

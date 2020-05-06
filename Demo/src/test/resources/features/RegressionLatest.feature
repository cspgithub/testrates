#Author: cspandey3000@gmail.com

Feature: Regression - Success Status Code for Latest and Past Date
 ##### for latest date rates
  Scenario: To Verify the success status for Get the latest foreign exchange reference rates api URL(Provided in Test Data Column)
    Given Go rest API is up and running
    When I hit the api with get request and end point as "/latest"
    Then API returned the status code as 200
 @smoke
  Scenario: To Verify the success status for Latest Foreign Exchange Rates with Symbols api URL(Provided in Test Data Column)
    Given Go rest API is up and running
    When I hit the api with get request and end point as "/latest?symbols=USD,GBP"
    Then API returned the status code as 200

  Scenario: To Verify the success status for Latest Foreign Exchange Rates with Base
    Given Go rest API is up and running
    When I hit the api with get request and end point as "/latest?base=USD"
    Then API returned the status code as 200

  Scenario: To Verify the success status for Latest Foreign Exchange Rates with Symbols and Base api
    Given Go rest API is up and running
    When I hit the api with get request and end point as "/latest?base=USD&symbols=GBP"
    Then API returned the status code as 200

  ##### for past date rates
  Scenario: To Verify the success status for Specific date Foreign Exchange rates api URL(Provided in Test Data Column)
    Given Go rest API is up and running
    When I hit the api with get request and end point as "/2010-01-12"
    Then API returned the status code as 200

  Scenario: To Verify the success status for Specific date Foreign Exchange Rates with Symbols api URL(Provided in Test Data Column)
    Given Go rest API is up and running
    When I hit the api with get request and end point as "/2010-01-12?symbols=USD,GBP"
    Then API returned the status code as 200

  Scenario: To Verify the success status for Specific date Foreign Exchange Rates with Base api URL(Provided in Test Data Column)
    Given Go rest API is up and running
    When I hit the api with get request and end point as "/2010-01-12?base=USD"
    Then API returned the status code as 200

  Scenario: To Verify the success status for Specific date Foreign Exchange Rates with Symbols and Baseapi URL(Provided in Test Data Column)
    Given Go rest API is up and running
    When I hit the api with get request and end point as "/2010-01-12?base=USD&symbols=GBP"
    Then API returned the status code as 200

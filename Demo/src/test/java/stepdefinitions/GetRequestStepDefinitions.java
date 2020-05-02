package stepdefinitions;

import context.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

//extending TestBase Class - essential function related to load properties,local date function etc...
public class GetRequestStepDefinitions extends TestBase {

	TestContextAPI testContext;

	public GetRequestStepDefinitions(TestContextAPI testContext) {
		this.testContext = testContext;
	}
	
	
	@Given("Go rest API is up and running")
	public void go_rest_API_is_up_and_running() {
		testContext.req_spec = given().baseUri(server);
	}

	@When("I hit the api with get request and end point as {string}")
	public void i_hit_the_api_with_get_request_and_end_point_as(String endPoint) {
		//URL details will be printed in test report
		testContext.scn.write("URL hit is : "+ server+endPoint );
		testContext.resp = testContext.req_spec.when().get(endPoint);
		//Response details will be printed in test report
		testContext.scn.write("Response of the request is: " + testContext.resp.asString() + "<br>");
	}

	@Then("API returned the status code as {int}")
	public void api_returned_the_status_code_as(Integer statusMsg) {
		testContext.resp.then().assertThat().statusCode(statusMsg);
		
		testContext.scn.write("Validated the status code,status code is : " + statusMsg + "<br>");
	}

	@Then("base value should be {string}")
	public void base_value_should_be(String baseValue) {
		
		testContext.resp.then().assertThat().body("base", equalTo(baseValue));
		testContext.scn.write("Validated the base value,base value is : " + baseValue + "<br>");
	}

	@Then("error message displayed as {string}")
	public void error_message_displayed_as(String errorMssg) {
		testContext.resp.then().assertThat().body("error", equalTo(errorMssg));
		testContext.scn.write("Validated the error message,error message content is : " + errorMssg + "<br>");
		
	}

	@Then("API should return current date rates")
	public void api_should_return_current_date_rates() {
		testContext.resp.then().assertThat().body("date", equalTo(currentLocaldate()));
	}


	
	

	
	
	

}

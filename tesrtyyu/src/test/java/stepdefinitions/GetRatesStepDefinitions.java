package stepdefinitions;

public class GetRatesStepDefinitions {

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
		testContext.resp = testContext.req_spec.when().get(endPoint);
		testContext.scn.write("Response of the request is: " + testContext.resp.asString() + "<br>");
	}

	@Then("API returned the status code as {int}")
	public void api_returned_the_status_code_as(Integer statusMsg) {
		testContext.resp.then().assertThat().statusCode(statusMsg);
	}

	@Then("base value should be {string}")
	public void base_value_should_be(String baseValue) {
		testContext.resp.then().assertThat().body("base", equalTo(baseValue));
	}

	@Then("error message displayed as {string}")
	public void error_message_displayed_as(String errorMssg) {
		testContext.resp.then().assertThat().body("error", equalTo(errorMssg));
	}

	@Then("API should return current date rates")
	public void api_should_return_current_date_rates() {
		testContext.resp.then().assertThat().body("date", equalTo(currentLocaldate()));
	}


	
	

	
	
	

}
	
}

package com.parameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class NnumberOfQueryParameterTest {
	
	@Test
	public void quesry() {
		
		given()
		.pathParam("username", "viekyfadatare")
		.queryParam("sort", "created")
		.queryParam("per_page", "20")

		.when()
		.get("https://api.github.com/users/{username}/repos")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
	}

}

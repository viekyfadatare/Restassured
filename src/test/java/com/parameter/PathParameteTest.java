package com.parameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameteTest {
	
	@Test
	public void path() {
		
	given()
	.pathParam("projectId", "TY_PROJ_1003")
	.when()
	.delete("http://localhost:8084/projects/{projectId}")
	.then()
	.assertThat().statusCode(204)
	.log().all();
		
	}

}

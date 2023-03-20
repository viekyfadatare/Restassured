package practice_CRUD_Without_BDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

public class GetAllProject {

	@Test
	public void getAllProject() {

		// step 1 :
		int expect = 200;
		Response resp = RestAssured.get("http://localhost:8084/Projects");

		// Step 2 :

		System.out.println(resp.prettyPeek());
		int actStatus = resp.getStatusCode();
		Assert.assertEquals(actStatus, expect);

		
	}

}

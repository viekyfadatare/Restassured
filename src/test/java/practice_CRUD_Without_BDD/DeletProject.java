package practice_CRUD_Without_BDD;

import org.junit.Assert;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeletProject {
	
	@Test
	
	public void deletProject() {
		
		
		int expStatus = 204;
		
		Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_004");
		
		int actStstus = resp.getStatusCode();
		
		Assert.assertEquals(expStatus, actStstus);
		
		System.out.println(resp.prettyPrint());
		
		
		
	}

}

package practice_CRUD_Without_BDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProject {
	
	@Test
	public void getSingleProject() {
		
		Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_001");
		
		
		
		System.out.println(resp.prettyPeek());
	}

}

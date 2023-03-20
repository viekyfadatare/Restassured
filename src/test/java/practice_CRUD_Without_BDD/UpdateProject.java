package practice_CRUD_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {

	@Test
	public void updateProject() {
		
		// step : creat test data 
		
		JSONObject jObj = new JSONObject();
		
		
		jObj.put("createdBy", "Chaitra");
		jObj.put("projectName", "APTY");
		jObj.put("status", "Completed");
		jObj.put("TeamSize", 12);
		
		// step2 : 
		RequestSpecification req = RestAssured.given();
		
		req.contentType(ContentType.JSON);
		req.body(jObj);
		
		// step3 : 
		Response resp = req.put("http://locolhost:8084/projects/TY_PROJ_002");
		
		// steps 4 : verification
		
		ValidatableResponse validate = resp.then();
		
		validate.assertThat().statusCode(200);
		validate.log().all();
		
		
		
	}
	
}

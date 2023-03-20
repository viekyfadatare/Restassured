package practice_CRUD_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Craete_Project {
	
	@Test
	
	public void createProject() {
		// steps1 : create test data 
		
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Dabbu");
		jObj.put("projectName", "Shailink");
		jObj.put("status", "Complete");
		jObj.put("TeamSize", 10);
		
		
		// Step 2 : provoid request Specification 
		
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jObj);
		
		
		
		// step 3 : perform the action
		
		Response resp = req.post("http://localhost:8084/addProject");
		
		// Step 4 : print in console  and perform verification
		
		System.out.println(resp.asString());
		System.out.println(resp.prettyPrint());
		System.out.println(resp.prettyPeek());
		System.out.println(resp.contentType());
		System.out.println(resp.getStatusCode());
		
		
		 
	}

}

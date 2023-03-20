package practice_CRUD_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddProJect {

	@Test

	public void addProject() {

	
		JSONObject jObj = new JSONObject();

		jObj.put("createdBy", "Vikya");
		jObj.put("projectName", "Zoho");
		jObj.put("status", "OnStart");
		jObj.put("TeamSize", 5);

		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jObj);

		Response resp = req.post("http://localhost:8084/addProject");

		System.out.println(resp.asString());
		System.out.println(resp.prettyPrint());
		System.out.println(resp.prettyPeek());
		System.out.println(resp.getContentType());
		System.out.println(resp.getStatusCode());

	}

}

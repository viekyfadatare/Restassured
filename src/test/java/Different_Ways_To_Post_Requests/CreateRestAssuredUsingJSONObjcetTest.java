package Different_Ways_To_Post_Requests;

import org.json.simple.JSONObject;  
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import  static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateRestAssuredUsingJSONObjcetTest {
	
	@Test
	
	public void create() {
		
		Random ran = new Random();
		
		int ranNumber = ran.nextInt(500);
		
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Dabbu123");
		jObj.put("projectName", "Shelu"+ranNumber);
		jObj.put("status", "Created");
		jObj.put("TeamSize", 10);
		
		given()
		.body(jObj)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}

}

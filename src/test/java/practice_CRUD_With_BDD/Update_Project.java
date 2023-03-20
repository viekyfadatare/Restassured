package practice_CRUD_With_BDD;

import java.util.Random; 

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Update_Project {

	@Test
	public void update() {

		Random ran = new Random();

		int ranNumber = ran.nextInt(5000);

		JSONObject jObj = new JSONObject();

		jObj.put("createdBy", "DabbuShailesh");
		jObj.put("projectName", "pink"+ranNumber);
		jObj.put("status", "created");
		jObj.put("teamSize", 20);
		
		given()
		.body(jObj)
		.contentType(ContentType.JSON)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_2002")
		.then()
		.assertThat().statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
		
	}

}

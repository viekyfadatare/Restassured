package practice_CRUD_With_BDD;

import org.json.simple.JSONObject; 
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import java.util.Random;

public class Create_the_Projects {
	
	@Test
	public void craete() {
		
		
		
		JSONObject jObj = new JSONObject();
		
		jObj.put("createdBy", "DabbuShailesh");
		jObj.put("projectName", "pinkyy");
		jObj.put("status", "Startes");
		jObj.put("TeamSize", 0);
		
		
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

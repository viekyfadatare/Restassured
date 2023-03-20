package Different_Ways_To_Post_Requests;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateRestAssueredUsingHashMapTest {
	
	@Test
	
	public void created() {
		
		
		
	Random ran = new Random();
		
		int ranNumber = ran.nextInt(500);
		
		HashMap map = new HashMap();
		
		map.put("createdBy", "Dabbaa123");
		map.put("projectName", "Shelu"+ranNumber);
		map.put("status", "Created");
		map.put("TeamSize", 10);
		
		given()
		.body(map)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
		
		
		
		
		
	}

}

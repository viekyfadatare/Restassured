package Different_Ways_To_Post_Requests;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class CreatedByJsonFileTest {
	
	@Test
	public void creating() {
		
		 
		File file = new File("./RestAssured.json");
		
		given()
		.body(file)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
		
		
		
	}

}

package Different_Ways_To_Post_Requests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import Pojo.PojoClass;
import io.restassured.http.ContentType;

public class CreatedUsingPOJOClass {
	
	@Test
	public void createdByPojo() {
		
		
		PojoClass pojo = new PojoClass("Limbaji", "sdet_27 Projo", "Completed", 130);
		
		given()
		.body(pojo)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
		
	}

}

package practice_CRUD_With_BDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Get_Perticular_data {
	
	@Test
	public void getData() {
		
		when()
		.get("http://localhost:8084/projects/TY_PROJ_1803")
		
		.then()
		.assertThat().contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();
	}

}

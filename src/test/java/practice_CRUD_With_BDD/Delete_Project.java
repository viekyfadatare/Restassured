package practice_CRUD_With_BDD;

import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;

public class Delete_Project {
	
	@Test
	
	public void deletProject() {
		
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_1009")
		.then()
		.assertThat().statusCode(204)
		.log().all();
		
	}

}

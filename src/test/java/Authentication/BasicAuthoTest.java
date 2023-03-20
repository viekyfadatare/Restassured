package Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicAuthoTest {
	
	@Test
	public void basic() {
		
		given()
		.auth().basic("rmgyantra", "rmgy@9999")
		.when().get("http://localhost:8084/login")
		.then().assertThat().statusCode(202)
		.log().all();
		
	}

}

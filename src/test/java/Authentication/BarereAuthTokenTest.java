package Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BarereAuthTokenTest {

	@Test
	public void barerToken() {
		
		given()
		.auth().oauth2("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")
		.when()
		.get("https://api.github.com/user/repos")
		.then().assertThat().statusCode(200)
		
		.log().all();
	
	}
}

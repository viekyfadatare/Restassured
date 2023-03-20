package Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Auth2 {
	
	@Test
	public void auth2() {
		
		
		Response response = given()
				
		.formParam("client_id", "Don")
		.formParam("client_secret", "0006bbc273982903d35bf0e29d3e8346")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "https://example.com")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		String token = response.jsonPath().get("access_token");
		
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID","2805")
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		.then()
		.log().all();

		
	}

}

package ResposnseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidation {

	@Test
	
	public void Verify() {
		
		String actResult = "whatsdown";
		
		 Response response = when()
				 .get("http://localhost:8084/projects");
		 
		List<String> proName = response.jsonPath().get("projectName");
		
		boolean flag = false;
		for (String pName : proName) {
			try {
			if(pName.contains(actResult)) {
				flag = true;
			}
			}
			catch(Exception e ) {
				
			}
		}
		
		response.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.log().all();
		
		Assert.assertEquals(flag, true);
		
		
	}
	
}

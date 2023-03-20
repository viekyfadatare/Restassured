package ResposnseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class VErifyRessponseTimeUsingHamcrestTest {
	
	@Test
	public void verify() {
		
		
		when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat().time(Matchers.lessThan(5000l),TimeUnit.MILLISECONDS)
		.log().all();
		
	}

}

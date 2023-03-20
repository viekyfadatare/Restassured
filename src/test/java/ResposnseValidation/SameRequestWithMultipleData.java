package ResposnseValidation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pojo.PojoClass;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class SameRequestWithMultipleData {

	@Test(dataProvider = "getData")
	public void create(String createdBy, String projectName, String status, int teamSize) {
		
		
		PojoClass pojo = new PojoClass( createdBy,  projectName,  status,  teamSize);
		
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
		
		@DataProvider
		public Object [][] getData(){
			
			Object[][]	obj = new Object[2][4];
			
			obj[0][0]="Vikyaaa";
			obj[0][1]="fbfbfb";
			obj[0][2]="Completed";
			obj[0][3]=200;
			
			obj[1][0]="ViekyTikee";
			obj[1][1]="Xyz54fgs14r";
			obj[1][2]="Completed";
			obj[1][3]=400;
			
			return obj;
		
			
		}	
		
	}



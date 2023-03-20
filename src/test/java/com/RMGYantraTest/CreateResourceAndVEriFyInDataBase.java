package com.RMGYantraTest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Pojo.PojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import sdet_27Genric_Utilities.BaseAPIClass;
import sdet_27Genric_Utilities.EndPoint;

public class CreateResourceAndVEriFyInDataBase extends BaseAPIClass {

	@Test
	public void createResourceAndVerifyInDB() throws Throwable {

		//Step1 Create test data

		PojoClass pojo = new PojoClass("Harshinibro", "PUMA" + jlib.getRandomNumber(), "Completed", 21);
		
		//Step2 Execute Post Request
		
		Response resp = given()
		.body(pojo)
		.contentType(ContentType.JSON)
		.when()
		.post(EndPoint.creatProject);
		
		// capturing the project Id from response
		
		String expData = rlib.getJSONdata(resp, "projectId");
		
		System.out.println(expData);
		
		// verify In database
		String query = "select* from project;";
		String actdata = dlib.executeQueryAndgetData(query, 1, expData);
		Reporter.log(actdata, true);
		
		Assert.assertEquals(expData, actdata);
		
		Reporter.log("  Data Verification Succefully  ", true);
		
		
		
		
	}

}

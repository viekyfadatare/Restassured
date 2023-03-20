package sdet_27Genric_Utilities;

import static io.restassured.RestAssured.*; 

import io.restassured.response.Response;

/**
 * This Class contains geric method specific for rest Assured
 * 
 * @author admin
 *
 */
public class RestAssured_Utitilities {

	/**
	 * This Method is return the json Data for the json path specification
	 * @param resp
	 * @param jsonPath
	 * @return
	 */
	public String getJSONdata(Response resp, String jsonPath) {

		String jsonData = resp.jsonPath().get(jsonPath);

		return jsonData;

	}

}

package sdet_27Genric_Utilities;

import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseAPIClass {

	public DataBase_Utilities dlib = new DataBase_Utilities();
	public Java_Utilities jlib = new Java_Utilities();
	public RestAssured_Utitilities rlib = new RestAssured_Utitilities();

	@BeforeSuite
	public void bsConfig() throws Throwable {

		baseURI = "http://localhost";
		port = 8084;

		dlib.connectDB();
		System.out.println(" ====Data Base Connection estblished ");
	}
	
	@AfterSuite
	public void asConfig() throws Throwable {
		
		
		dlib.closeDB();
		System.out.println("  === close Data Base Connection estblished  ");
	}
}

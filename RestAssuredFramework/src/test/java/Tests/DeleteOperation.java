package Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;


public class DeleteOperation {

	@BeforeMethod
	public void commonUrl() {
		RestAssured.baseURI="https://reqres.in";
		
	}
	

	@AfterMethod
	public void validation() {
		System.out.println("Successfully validated");
	}
	
	@Test
	public void deleteMethod() {
		String response=given().log().all().header("User-Agent","PostmanRuntime/7.29.0")
		.when().delete("api/users/2").then().assertThat().log().all().statusCode(204).extract().asString();
		
		System.out.println(response);
		
	
	}

}

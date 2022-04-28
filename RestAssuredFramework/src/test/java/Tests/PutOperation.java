package Tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PutOperation {
	

	@BeforeMethod
	public void commonUrl() {
		RestAssured.baseURI="https://reqres.in";
		
	}
	

	@AfterMethod
	public void validation() {
		System.out.println("Successfully validated");
	}
	
	@Test
	public void putMethod() {
		
		String newName = "Sharvari P";
		given().log().all().header("Content-Type","application/json").body("{\r\n"
				+ "    \"name\": \""+newName+"\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}")
		.when().put("api/users/2").
		then().assertThat().statusCode(200).header("Content-Type", "application/json; charset=utf-8");
		
		
	}
}

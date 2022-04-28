package Tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetOperartion {
	
	@BeforeMethod
	public void commonUrl() {
		RestAssured.baseURI="https://reqres.in";
		
	}
	
	
	@Test
	public void getMethod() {
		String getRes=given().log().all().queryParam("page", "2").
				when().get("api/users")
				.then().assertThat().log().all().statusCode(200).extract().asString();
				System.out.println(getRes);
				JsonPath jp1=new JsonPath(getRes);
				
				String totalPages=jp1.getString("total");
				System.out.println(totalPages);
				
		
	}
	
	@AfterMethod
	public void validation() {
		System.out.println("Successfully validated");
	}

}

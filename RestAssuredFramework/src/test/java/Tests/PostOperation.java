package Tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class PostOperation {
	
	
	@BeforeMethod
	public void commonUrl() {
		RestAssured.baseURI="https://reqres.in";
		
	}
	
	@Test
	public void postMethod() {
		String responce=given().log().all().header("Content-Type","text/plain").body(Payload.reqresPostBody())
				.when().post("api/users")
				.then().log().all().assertThat().statusCode(201).header("Content-Type","application/json; charset=utf-8").extract().response().asString();
				
				System.out.println(responce);
				JsonPath jp=new JsonPath(responce);
				String serverName=jp.getString("Server");
				System.out.println(serverName);
	}
	

	@AfterMethod
	public void validation() {
		System.out.println("Successfully validated");
	}


}

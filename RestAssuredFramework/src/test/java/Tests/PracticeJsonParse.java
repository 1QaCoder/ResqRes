package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class PracticeJsonParse {
	JsonPath js;
	int count;
	@BeforeMethod
	public void commonJson() {
		js=new JsonPath(Payload.CoursePrice());
		
	}
	

	@AfterMethod
	public void validation() {
		System.out.println("Successfully validated");
	}
	
	@Test
	public void printNoofCourses() {
		 count=	js.getInt("courses.size()");
		System.out.println(count);
		//Print Purchase Amount
		int totalAmount= js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
	}
	
	@Test
	public void printTitle() {
		 String title=js.get("courses[2].title");
		  System.out.println(title);
		  
		  for(int i=0;i<count;i++)
		  {
			  String courseTitles=js.get("courses["+i+"].title");
			  System.out.println(js.get("courses["+i+"].price").toString());
			  
			  System.out.println(courseTitles);
			  
		  }
		
	}
	
	@Test
	public void copiesOfRPA() {
		System.out.println("Print no of copies sold by RPA Course");
		 
		 for(int i=0;i<count;i++)
		 {
			  String courseTitles=js.get("courses["+i+"].title");
			  if(courseTitles.equalsIgnoreCase("RPA"))
			  {
				  int copies=js.get("courses["+i+"].copies");
				  System.out.println(copies);
				  break;
			  }  
		 }
		
	}
	
	@Test
	public void sumOfCourses()
	{
		int sum = 0;
		JsonPath js=new JsonPath(Payload.CoursePrice());
		int count=	js.getInt("courses.size()");
		for(int i=0;i<count;i++)
		{
			int price=js.getInt("courses["+i+"].price");
			int copies=js.getInt("courses["+i+"].copies");
			int amount = price * copies;
			System.out.println(amount);
			sum = sum + amount;
			
		}
		System.out.println(sum);
		int purchaseAmount =js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum, purchaseAmount);
		
	}

}

package tests;

import org.testng.Assert;
	

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
//import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestsExamples {
	@Test
	public void test_1() {
		
		
		/*Response response= RestAssured.get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		System.out.println(response.getBody().asString());
		System.out.println(response.getHeader("content-type"));
		*/
		 Response response = RestAssured
	                .given()
	                .header("x-api-key", "reqres_cd3cdf4c36094de59f2295e62b0f10ea")// reqres.in now requires a free API key.
	                .when()
	                .get("https://reqres.in/api/users?page=2");
		    System.out.println(response.getStatusCode());
			System.out.println(response.getTime());
			System.out.println(response.getStatusLine());
			System.out.println(response.getBody().asString());
			System.out.println(response.getHeader("content-type"));
			
			int statuscode=response.getStatusCode();
			
			Assert.assertEquals(statuscode, 200);
			
	}
	
	//@Test
	public void test_2() {
		
	
	/*baseURI="https://reqres.in/api";
	given().
	   get("https://reqres.in/api/users?page=2").
	then().
	   statusCode(200).
	   body("data[1].id", equalTo(8)). //data[1].id    data.id[1]
	   log().all();
	*/
		
			given().
			   header("x-api-key","reqres_cd3cdf4c36094de59f2295e62b0f10ea").
			   get("https://reqres.in/api/users").
			then().
			 statusCode(200).
			 body("data[3].id",equalTo(4)).
			 log().all();
		
		
	}

}

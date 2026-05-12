package tests;

import org.json.simple.JSONObject;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
public class GetAndPostExamples {
	
	//@Test
	public void testGet() {
		
		
		
		baseURI="https://reqres.in/api";	
		given().
		   get("/users?page=2").
		then().
		body("data[0].first_name", equalTo("Michael")).
		body("data.first_name",hasItems("Michael","Lindsay","Tobias")).
		log().all().//Lindsay Tobias
		   statusCode(200);
		
		
	}
	
	@Test
	public void testPost() {
		
		Map<String,Object> map= new HashMap<String,Object>();
		
		/*map.put("email", "eve.holt@reqres.in");
		map.put("password", "pistol");
		System.out.println(map);*/
		
		JSONObject request= new JSONObject();
		
		
		request.put("email", "eve.holt@reqres.in");
		request.put("password", "pistol");
		
		System.out.println(request.toJSONString());
		
		given().
		  header("Content-Type","application/Json").
		  contentType(ContentType.JSON).
		  accept(ContentType.JSON).
		  header("x-api-key","reqres_cd3cdf4c36094de59f2295e62b0f10ea").
		  body(request.toJSONString()).
		when().
		  post("https://reqres.in/api/users").
		then().
		  statusCode(201).
		  log().all();
		
		
		
		//gson from google
		//jackson high performance json processor
		//json
		//json Simple google
		
		
		
	}

}

package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TestsOnLocalAPI {
	
	//@Test
	public void get() {
		
		baseURI="http://localhost:3000";
		given().
		 get("/users").
		then().
		  statusCode(200).log().all();
		
	}
	
	//@Test
	public void post() {
		
		JSONObject response= new JSONObject();
		response.put("firstName", "Rakhi");
		response.put("LastName", "Deulkar");
		response.put("subjectId", "1");
		
		baseURI="http://localhost:3000";
		given().
		 contentType(ContentType.JSON).
		 accept(ContentType.JSON).
		 body(response.toJSONString()).
		when().
		 post("/users").
		then().
		  statusCode(201).log().all();
		
	}
	
    //@Test
	public void put() {
		
		JSONObject response= new JSONObject();
		response.put("firstName", "Sonal");
		response.put("LastName", "Deulkar");
		response.put("subjectId", "3");
		
		baseURI="http://localhost:3000";
		given().
		 contentType(ContentType.JSON).
		 accept(ContentType.JSON).
		 body(response.toJSONString()).
		when().
		 put("/users/g31DPjnLNQc").
		then().
		  statusCode(200).log().all();
		
	}
	
   //@Test
	public void patch() {
		
		JSONObject response= new JSONObject();
		response.put("firstName", "Rakhi");
		//response.put("LastName", "Deulkar");
		//response.put("subjectId", "3");
		
		baseURI="http://localhost:3000";
		given().
		 contentType(ContentType.JSON).
		 accept(ContentType.JSON).
		 body(response.toJSONString()).
		when().
		 patch("/users/g31DPjnLNQc").
		then().
		  statusCode(200).log().all();
		
	}
	
	@Test
		public void delete() {
			
		
			baseURI="http://localhost:3000";
			
			when().
			 delete("/users/g31DPjnLNQc").
			then().
			  statusCode(200).log().all();
			
		}

}

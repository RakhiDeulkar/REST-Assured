package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class PutPatchAndDelete {
	
	@Test
	public void testPut() {
		
		JSONObject request= new JSONObject();
		
		//request.put("name", "Rakhi");
		//request.put("job", "Thane resident");
		request.put("id", "3");
		request.put("email", "rakhi.deulkar");
		
		baseURI="https://reqres.in/api";
		given().
		  header("Content-Type","application/JSON").
		  header("x-api-key","reqres_cd3cdf4c36094de59f2295e62b0f10ea").
		  body(request.toJSONString()).
		when().
		  put("/users/2").
		then().
		  statusCode(200).log().all();
		
	}
	
	//@Test
	public void testPatch() {
		
		JSONObject request= new JSONObject();
		
		request.put("name", "Rakkhi");
		request.put("job", "Thane resident");
		
		baseURI="https://reqres.in";
		given().
		  header("Content-Type","application/JSON").
		  header("x-api-key","reqres_cd3cdf4c36094de59f2295e62b0f10ea").
		  body(request.toJSONString()).
		when().
		  patch("/api/users/2").
		then().
		  statusCode(200).log().all();
		
	}
	
	//@Test
	public void testDelete() {
	
		baseURI="https://reqres.in";
		
		given().
		  header("x-api-key","reqres_cd3cdf4c36094de59f2295e62b0f10ea").
		when().
		  delete("/api/users/2").
		then().
		  statusCode(204).log().all();
		
	}

}

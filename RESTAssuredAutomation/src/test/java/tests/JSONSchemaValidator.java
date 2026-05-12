package tests;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

public class JSONSchemaValidator {
	
	@Test
	public void test() {																																																		
		

	                 given().
	                    header("x-api-key", "reqres_cd3cdf4c36094de59f2295e62b0f10ea").
	                    get("https://reqres.in/api/users?page=2").
	                 then().
	                    assertThat().
	                    body(matchesJsonSchemaInClasspath("schema.json.JSON")).
	                    statusCode(200);
	

			
	}

}

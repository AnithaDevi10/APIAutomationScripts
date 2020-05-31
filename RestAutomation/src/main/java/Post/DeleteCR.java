package Post;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteCR {
	
	@Test
	public void deleteCR(){
		//step1. end point
		
				RestAssured.baseURI="https://dev97931.service-now.com/api/now/table/change_request";
				
				//step2. authentication
				  RestAssured.authentication=RestAssured.basic("admin","Archinmayi@630");
				  
				  ValidatableResponse response=RestAssured
						  .given()
						  .log()
						  .all()
						  .delete("8e06564e2f705010336f837cf699b61e")
						  .then()
						  .assertThat()
						  .statusCode(204);
				
				
	}

}

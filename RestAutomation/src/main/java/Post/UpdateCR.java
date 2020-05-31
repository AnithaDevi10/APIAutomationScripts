package Post;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class UpdateCR {

	@Test
	public void updateCR() {
		RestAssured.baseURI="https://dev97931.service-now.com/api/now/table/change_request";
		
		//step2. authentication
		  RestAssured.authentication=RestAssured.basic("admin","Archinmayi@630");
	
		  ValidatableResponse response = RestAssured
				  .given()
				  .log()
				  .all()
				  .contentType(ContentType.JSON)
			 
				  .body("{\n" + 
				  		"  \"short_description\": \"Updated shortdesc using RA\",\n" + 
				  		"  \"description\": \"updated desc using RA\"\n" + 
				  		"}")
				  .patch("05a512ce2f705010336f837cf699b670")
				  .then()
				  .assertThat()
				  .statusCode(200);
	}
	
}

package Basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateCR {

	@Test
	public void createCR() {
		//step1. end point
		
		RestAssured.baseURI="https://dev97931.service-now.com/api/now/table/change_request";
		
		//step2. authentication
		  RestAssured.authentication=RestAssured.basic("admin","Archinmayi@630");
		  
		  //step3.create CR( body as string)
		  Response response=RestAssured
				  .given()
				  .contentType(ContentType.JSON)
				  .body("{\n" + 
				  		"  \"short_description\": \"AnithaDevi\"\n" + 
				  		"}")
				  .post();
		  
		  System.out.println(response.getStatusCode());
		  response.prettyPrint();
				  
				}
}

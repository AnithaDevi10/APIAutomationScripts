package Basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllChangeRequests {

	@Test
	public  void getAllChangeRequests() {
		// TODO Auto-generated method stub
		
		//step1: need an endpoint for the service
  RestAssured.baseURI="https://dev97931.service-now.com/api/now/table/change_request";
  
       //step2: Need to set Basic Authentication
  RestAssured.authentication=RestAssured.basic("admin","Archinmayi@630");
  
  //step3: place the get request
  Response response=RestAssured.get();
  
  //step4: Check the response status
  System.out.println(response.getStatusCode());
  response.prettyPrint();
  
	}

}

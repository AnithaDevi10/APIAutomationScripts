package StepDefn;

import java.io.File;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDef {
	
	private RequestSpecification requestspec;
	private Response response;
	
	@Given("End Point is loaded")
	public void initEndPoint()
	{
		RestAssured.baseURI="https://dev97931.service-now.com/api/now/table/change_request";

	}
	
	@And("Basic Authorization is initiated")
	public void authorize()
	{
		  RestAssured.authentication=RestAssured.basic("admin","Archinmayi@630");
		  
	}
	@When("Content-Type is JSON")
	public void setContentType()
	{
	requestspec = RestAssured.given().log().all().contentType(ContentType.JSON);
	}
	
	@When("Content-Type is XML")
	public void setContentTypeAsXML()
	{requestspec=RestAssured.given().log().all().contentType(ContentType.XML);   }
	
	@And("Send request as Post")
	public void createIncident()
	{
	response=requestspec.post();
	}
	
	@And("Send Body as String in JSON format")
	public void sendBodyAsJson()
	{ requestspec=requestspec.body("{\n" + 
			"  \"short_description\": \"Fusion as JSON\"\n" + 
			"}");  }
	
	@And("Send Body as File(.*)$")
	public void sendBodyAsFile(String file)
	{ requestspec=requestspec.body(new File(file));             }
	
	@And("Send Body as String in XML format")
	public void sendbodyAsXML()
	{ requestspec=requestspec.body("{\n" + 
			"  \"short_description\": \"Fusion as XML\"\n" + 
			"}"); }
	
	
  @Then("Confirm the response status code is 201")
   public void verifyResponse()
   {
	  System.out.println("Status code is = "+response.getStatusCode());
	  
	 if(response.getStatusCode()==201) 
	 { System.out.println("the status code is correct");}
	 else
	 {System.err.println("doesnot match"); }
   
   }
}

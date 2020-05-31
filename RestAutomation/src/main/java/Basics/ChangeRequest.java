package Basics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ChangeRequest {
@Test
	public  void changeRequest() {
		// TODO Auto-generated method stub

		
	
	//step1: need an endpoint for the service
	  RestAssured.baseURI="https://dev97931.service-now.com/api/now/table/";
	  
	       //step2: Need to set Basic Authentication
	  RestAssured.authentication=RestAssured.basic("admin","Archinmayi@630");
	  
	  //step3: place the get request
	  //setup multiple parameters
	  Map<String,String> parametersMap = new HashMap<String,String>();
	  parametersMap.put("type","emergency");
	  parametersMap.put("sysparam_fields","type,number,sys_id");
	  //get the response
	  Response response = RestAssured
			  .given()
			//  .log().all() //we dont want all fields to be printed
			 // .header(new Header("accept","application/xml"))
			  .param("sysparam_fields","type,number,sys_id")
			  .queryParams(parametersMap)
			  .get("change_request");
		//Print
	  response.prettyPrint();
	  
	  //Print the status code and response time
	  int statuscode= response.getStatusCode();
	  long time=response.getTime();
	  System.out.println("The status is"+statuscode+"and the time is"+time);
	  
	  //response format
	  String contentType=response.getContentType();
	  System.out.println(contentType);
	  
	  //count the number of changerequests in the response
	 // XmlPath xmlResponse =response.xmlPath();
	  JsonPath jsonresponse=response.jsonPath();
	  System.out.println(jsonresponse);
	  //to print only type,number,sys_id from jsonresponse
	  
	  
	  //get the specific field
	  List<String> allRequests=jsonresponse.getList("result.sys_id");
	  //allRequests hold list of sys_id
	  //print count of requests
	  int size=allRequests.size();
	  System.out.println("The number of records  are "+size);
	  System.out.println("the first request"+allRequests.get(0));
	  System.out.println("the last request"+allRequests.get(size-1)); 
	    
	  
	  
	  
	  
}
}

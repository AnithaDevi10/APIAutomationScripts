package JIIRAAssignments;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Create3issuesDataProvider {

	@DataProvider(name="ThreeInputs",parallel=true)
	public String[] getFiles() {
		String[] files=new String[3];
		files[0]="input1.json";
		files[1]="input2.json";
		files[2]="input3.json";
		
		return files;
	}
	
	//step1. end point
		@Test(dataProvider="ThreeInputs")
		public void CreateCRfile(String fileName)
		{
			//file
			File jsonFile=new File(fileName);
				RestAssured.baseURI="https://api-mar2020.atlassian.net/rest/api/2/issue";
				
				//step2. authentication
				 RestAssured.authentication=RestAssured.preemptive().basic("rajalakshmi.govindarajan@testleaf.com","kEJxzmhkQzvdeP8iysWN2D1B");
					 
				  //step3.create Issue( body as string)
				  Response response=RestAssured
						  .given()
						  //.queryParam("sysparm_fields", "number,sys_id")
	// only those fields sysparm_fields like number,sys_id will be printed in console
						  .contentType(ContentType.JSON)
						  .body(jsonFile)
						  .log().all()
						  .post();
				  
				  System.out.println(response.getStatusCode());
				  response.prettyPrint();
				
	}

}

package Post;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateCRfile {
	
	//it can pass multiple data to test
	@DataProvider(name="Files",parallel=true)
	public String[] getFiles() {
		String[] files=new String[2];
		files[0]="data1.json";
		files[1]="data2.json";
		return files;
	}
	
	
	
	
	
	
	
	//step1. end point
	@Test(dataProvider="Files")
	public void CreateCRfile(String fileName)
	{
		//file
		File jsonFile=new File(fileName);
			RestAssured.baseURI="https://dev97931.service-now.com/api/now/table/change_request";
			
			//step2. authentication
			  RestAssured.authentication=RestAssured.basic("admin","Archinmayi@630");
			  
			  //step3.create CR( body as string)
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
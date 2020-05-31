package Post;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;

public class UpdateCR_datafile {

	//public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		@DataProvider(name="File1")
		public String[] getFiles() {
			String[] files=new String[1];
			files[0]="data1.json";
			//files[1]="data2.json";
			return files;
					}
		
		@Test(dataProvider="File1")
		public void updateCRfile(String fileName)
		{
			//file
			File jsonFile=new File(fileName);
				RestAssured.baseURI="https://dev97931.service-now.com/api/now/table/change_request";
				
				//step2. authentication
				  RestAssured.authentication=RestAssured.basic("admin","Archinmayi@630");
				  
				  
				  //step3.create CR( body as string)
				  ValidatableResponse response=RestAssured
						  .given()
						  //.queryParam("sysparm_fields", "number,sys_id")
	// only those fields sysparm_fields like number,sys_id will be printed in console
						 // .queryParam(parameterName, parameterValues)
						  .contentType(ContentType.JSON)
						  .body(jsonFile)
						  .log().all()
						  .patch("05a512ce2f705010336f837cf699b670")
						  .then()
						  .assertThat()
						  .statusCode(200);	
			
				  Response response1=RestAssured
						  .given()
						  .log().all()
						  .queryParam("sys_id","05a512ce2f705010336f837cf699b670")
						  //.body()
						  .get();
						  
					System.out.println("Response Body is: "+response1.prettyPrint() );


			 
	}	
		

		
}

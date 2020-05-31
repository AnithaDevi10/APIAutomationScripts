import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JIIRA {

	@Test
	public void getAllIssues()
	{
		RestAssured.baseURI="https://api-mar2020.atlassian.net/rest/api/2/search";
	 RestAssured.authentication=RestAssured.preemptive().basic("rajalakshmi.govindarajan@testleaf.com","kEJxzmhkQzvdeP8iysWN2D1B");
	 //(1) Get All issues in JIIRA
	 Response response=RestAssured
			 .given()
			 //.queryParam("maxResults","1")
			 .queryParam("jql","project=MAY AND priority=Medium AND attachments IS NOT EMPTY ")
			 .get();
	 response.prettyPrint();
	 System.out.println(response.getStatusCode());
	 long time=response.getTime();
	 System.out.println("the time is "+time);
	 
	 JsonPath responseJson = response.jsonPath();
	 
	 List<String> allIssues=responseJson.getList("issues.id");
	 System.out.println("the total number of issues are"+allIssues.size());
	 
	 //Print the attachment
	 for(String eachIssue:allIssues)
	 {     System.out.println("the issue id "+ eachIssue);
	         Response response2=RestAssured
			  .given()
			  .get("https://api-mar2020.atlassian.net/rest/api/2/issue/"+eachIssue);
	 JsonPath responseJsonIssue=response2.jsonPath();
	// response2.prettyPrint();
	 
	 List<String> attachmentFileNames=responseJsonIssue.getList("fields.attachment.fileName");
//	 for(String fileName:attachmentFileNames)
//	 { System.out.println("Printing fileName"+fileName); }
	   System.out.println("the file size is"+attachmentFileNames.size());
        for(int j=0;j<attachmentFileNames.size();j++)	
         { 
    	    if(!attachmentFileNames.get(j).isEmpty()) 
	        System.out.println("the file name is " + attachmentFileNames.get(j));
	     }
		 
	 }//for loop of issues
	 
	}
	
	
}
 
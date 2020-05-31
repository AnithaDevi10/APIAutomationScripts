package JIIRAAssignments;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateNewIssue {

		// TODO Auto-generated method stub
        @Test
		public void createNewIssue()
		{
			RestAssured.baseURI="https://api-mar2020.atlassian.net/rest/api/2/issue";
			 RestAssured.authentication=RestAssured.preemptive().basic("rajalakshmi.govindarajan@testleaf.com","kEJxzmhkQzvdeP8iysWN2D1B");
			File JsonFile=new File("/Users/kumanananitha/Desktop/RESTASSURED/jira.json"); 
			 Response response=RestAssured
					 .given()
					 .contentType(ContentType.JSON)
					 .body(JsonFile)
					 //.queryParam("maxResults","1")
					 //.queryParam("jql","project=MAY AND priority=Medium AND attachments IS NOT EMPTY ")
					 .post();
			response.prettyPrint() ;
			System.out.println(response.getStatusCode());
		}
	

}

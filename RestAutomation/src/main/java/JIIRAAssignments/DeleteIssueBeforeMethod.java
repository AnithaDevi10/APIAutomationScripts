package JIIRAAssignments;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteIssueBeforeMethod {
	String issue_id;
	
	@BeforeMethod
	public void getTheFirstIssue() {
		RestAssured.baseURI="https://api-mar2020.atlassian.net/rest/api/2/search";
		 RestAssured.authentication=RestAssured.preemptive().basic("rajalakshmi.govindarajan@testleaf.com","kEJxzmhkQzvdeP8iysWN2D1B");
		
		 issue_id=RestAssured.get().jsonPath().getList("issues.id").get(0).toString();
	}
	
	@Test
	public void deleteIssue() {
		RestAssured.baseURI="https://api-mar2020.atlassian.net/rest/api/2/issue";
		 RestAssured.authentication=RestAssured.preemptive().basic("rajalakshmi.govindarajan@testleaf.com","kEJxzmhkQzvdeP8iysWN2D1B");
		
		 Response response=RestAssured.delete(issue_id);
		 System.out.println(response.getStatusCode());
		 
	}

}

package JIIRAAssignments;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllIssueswithin24hrs {
	@Test
	public void getAllIsssues() throws ParseException
	{
	RestAssured.baseURI="https://api-mar2020.atlassian.net/rest/api/2/search";
	 RestAssured.authentication=RestAssured.preemptive().basic("rajalakshmi.govindarajan@testleaf.com","kEJxzmhkQzvdeP8iysWN2D1B");
	Response response=RestAssured.get();
	
	response.prettyPrint();
	//returns body as string
	
	//to get total number of issues
	System.out.println("total issues"+response.jsonPath().get("total"));
	
	JsonPath jsonpath=response.jsonPath();
	//it gets issues with created timestamp
	List<String> created=jsonpath.getList("issues.fields.created");
	
	System.out.println("total number of issues " + created.size());
	for(int i=0;i<created.size();i++)
	 {
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		Date date = format.parse(created.get(i));
		long Createdtime=date.getTime();//it converts the created timestamp to milliseconds
		long CurrentTime=new Date().getTime(); //it gets sysytem current time in milliseconds
		
		if(CurrentTime-Createdtime <= (24*60*60*1000))
		{
			System.out.println(jsonpath.getList("issues.id").get(i)+":created at"
					           +jsonpath.getList("issues.fields.created").get(i)); 
			
		}
	 }		
				
	}
			
	}


package restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import restApi.Base.BasePage;

public class getSingleUser {
	
	@Test
	public void getSingleUser() {
		BasePage bp=new BasePage();
		bp.BaseUrl();
	
	RequestSpecification httprequest=RestAssured.given();
	//responseobject

	Response response=httprequest.request(Method.GET,"api/users/2");
	System.out.println(RestAssured.baseURI);
	String responseBody=response.getBody().asString();
	System.out.println("responseBody is: "+responseBody);
	int statusCode=response.getStatusCode();
	System.out.println("Status code is: "+statusCode);
	Assert.assertEquals(statusCode,200);
	//success code validation
		String name=response.jsonPath().get("data.first_name");
		Assert.assertEquals(name, "Janet");
	
	}
}

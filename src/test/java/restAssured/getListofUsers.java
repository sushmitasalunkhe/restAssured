package restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import restApi.Base.BasePage;

public class getListofUsers extends BasePage{
	
	@Test
	public void getUsers() {
		BasePage bp=new BasePage();
		bp.BaseUrl();
	
	RequestSpecification httprequest=RestAssured.given();
	//responseobject

	Response response=httprequest.request(Method.GET,"/api/users?page=2");
	System.out.println(RestAssured.baseURI);
	String responseBody=response.getBody().asString();
	System.out.println("responseBody is: "+responseBody);
	//success code validation

	String name=response.jsonPath().get("data[0].first_name");
	
	Assert.assertEquals(name, "Michael");
	}
}

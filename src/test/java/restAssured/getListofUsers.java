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
import restApi.Base.BaseTest;

public class getListofUsers extends BaseTest{
	
	@Test(priority=0)
	public void getUsers() {
		System.out.println("testcase running: get all users");
		BaseTest bt=new BaseTest();
		bt.BaseUrl();
	
		String token=bt.gettoken();
		RequestSpecification httprequest=RestAssured.given().auth().oauth2(token);

	//responseobject

	Response response=httprequest.request(Method.GET,"/users/");
	
	String responseBody=response.getBody().asString();
	System.out.println("responseBody is: "+responseBody);
	//success code validation
	int statusCode=response.getStatusCode();
	System.out.println("Status code is: "+statusCode);
	Assert.assertEquals(statusCode,200);

	
	}
	@Test(priority=1)
	public void CountOfUsers() {
		System.out.println("testcase running: getcount of users");
		BaseTest bt=new BaseTest();
		bt.BaseUrl();
	
		String token=bt.gettoken();
		RequestSpecification httprequest=RestAssured.given().auth().oauth2(token);

	//responseobject

	Response response=httprequest.request(Method.GET,"/users/");
	
	String responseBody=response.getBody().asString();
	System.out.println("responseBody is: "+responseBody);
	//success code validation
	int statusCode=response.getStatusCode();
	System.out.println("Status code is: "+statusCode);
	Assert.assertEquals(statusCode,200);
	int count=response.jsonPath().get("totalCount");
	//count validation
	Assert.assertEquals(count, 2198);
	System.out.println("testcase passed");
		}
	@Test(priority=2)
	public void WrongApi() {
		System.out.println("testcase running: wrong api");
		BaseTest bt=new BaseTest();
		bt.BaseUrl();
	
		String token=bt.gettoken();
		RequestSpecification httprequest=RestAssured.given().auth().oauth2(token);

	//responseobject

	Response response=httprequest.request(Method.GET,"/user/");

	//success code validation
	int statusCode=response.getStatusCode();
	System.out.println("Status code is: "+statusCode);
	Assert.assertEquals(statusCode,404);
	System.out.println("testcase passed");
		
	}
	@Test(priority=3)
	public void unAuthorisedcall() {
		System.out.println("testcase running: wrong token");
		BaseTest bt=new BaseTest();
		bt.BaseUrl();
	
		String token=bt.gettoken();
		RequestSpecification httprequest=RestAssured.given().auth().oauth2("ndcccn"+token);
	//responseobject

	Response response=httprequest.request(Method.GET,"users/");
	
	String responseBody=response.getBody().asString();
	System.out.println("responseBody is: "+responseBody);
	int statusCode=response.getStatusCode();
	System.out.println("Status code is: "+statusCode);
	Assert.assertEquals(statusCode,401);
	//message validation
		String message=response.jsonPath().get("message");
		Assert.assertEquals(message, "Authentication failed.");
		System.out.println("testcase passed");
	}
}

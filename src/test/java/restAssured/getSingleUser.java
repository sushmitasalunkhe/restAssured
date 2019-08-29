package restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import restApi.Base.BasePage;
import restApi.Base.BaseTest;

public class getSingleUser extends BaseTest {
	@Test(priority=0)
	public void getSingleUser()  {
		System.out.println("testcase running: get single user");
		BaseTest bt=new BaseTest();
		bt.BaseUrl();
	
		String token=bt.gettoken();
		RequestSpecification httprequest=RestAssured.given().auth().oauth2(token);
	//responseobject

	Response response=httprequest.request(Method.GET,"users/123/");

	String responseBody=response.getBody().asString();
	System.out.println("responseBody is: "+responseBody);
	int statusCode=response.getStatusCode();
	System.out.println("Status code is: "+statusCode);
	Assert.assertEquals(statusCode,200);
	//name validation
		String name=response.jsonPath().get("result.first_name");
		Assert.assertEquals(name, "Esta");
		System.out.println("testcase passed");
	
	}
	@Test(priority=1)
	public void unAuthorizedcall()  {
		System.out.println("testcase running: wrong token");
		BaseTest bt=new BaseTest();
		bt.BaseUrl();
	
		String token=bt.gettoken();
		RequestSpecification httprequest=RestAssured.given().auth().oauth2("ndcccn"+token);
	//responseobject

	Response response=httprequest.request(Method.GET,"users/123/");
	
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
	@Test(priority=2)
	public void WrongApi() {
		System.out.println("testcase running: wrong api");
		BaseTest bt=new BaseTest();
		bt.BaseUrl();
	
		String token=bt.gettoken();
		RequestSpecification httprequest=RestAssured.given().auth().oauth2(token);
	//responseobject

	Response response=httprequest.request(Method.GET,"user/123/");//using user instead of users
	System.out.println(RestAssured.baseURI);
	/*String responseBody=response.getBody().asString();
	System.out.println("responseBody is: "+responseBody);*/
	int statusCode=response.getStatusCode();
	System.out.println("Status code is: "+statusCode);
	Assert.assertEquals(statusCode,404);
	
	}
	@Test(priority=3)
	public void WrongId()  {
		System.out.println("testcase running: wrong user id");
		BaseTest bt=new BaseTest();
		bt.BaseUrl();
	
		String token=bt.gettoken();
		RequestSpecification httprequest=RestAssured.given().auth().oauth2(token);
	//responseobject

	Response response=httprequest.request(Method.GET,"users/122/");

	String responseBody=response.getBody().asString();
	System.out.println("responseBody is: "+responseBody);
	int statusCode=response.getStatusCode();
	System.out.println("Status code is: "+statusCode);
	Assert.assertEquals(statusCode,200);
	//name validation
		String name=response.jsonPath().get("result.first_name");
		Assert.assertNotEquals(name, "Esta");
		System.out.println("testcase passed");
	
	}
	
}

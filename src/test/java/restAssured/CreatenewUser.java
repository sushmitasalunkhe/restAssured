package restAssured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import restApi.Base.BaseTest;

public class CreatenewUser extends BaseTest {
	@Test(priority=0)
	public void CreatenewUser() {
		BaseTest bt=new BaseTest();
		bt.BaseUrl();
		String token=bt.gettoken();
		String email=bt.getrandomEmail(10);
		
		RequestSpecification httprequest=RestAssured.given().auth().oauth2(token);
		JSONObject requestParams=new JSONObject();
		requestParams.put("first_name","Brian");
		requestParams.put("last_name","Ratke");
		requestParams.put("gender","male");
		requestParams.put("email",email+"@gmail.com");
		requestParams.put("status","active");
		httprequest.header("Content-Type","application/json");
		httprequest.body(requestParams.toJSONString());
		//responseobject

		Response response=httprequest.request(Method.POST,"/users");
		String responseBody=response.getBody().asString();
		System.out.println("responseBody is: "+responseBody);
		int statusCode=response.getStatusCode();
		System.out.println("Status code is: "+statusCode);
		Assert.assertEquals(statusCode,201);
	
		}
	@Test(priority=1)
	
	public void emptyDetails() {
		System.out.println("test case running is empty details");
		BaseTest bt=new BaseTest();
		bt.BaseUrl();
		String token=bt.gettoken();
		String email=bt.getrandomEmail(10);
		
		RequestSpecification httprequest=RestAssured.given().auth().oauth2(token);
		JSONObject requestParams=new JSONObject();
		requestParams.put("first_name","");
		requestParams.put("last_name","");
		requestParams.put("gender","male");
		requestParams.put("email",email+"@gmail.com");
		requestParams.put("status","active");
		httprequest.header("Content-Type","application/json");
		httprequest.body(requestParams.toJSONString());
		//responseobject

		Response response=httprequest.request(Method.POST,"/users");
		String responseBody=response.getBody().asString();
		System.out.println("responseBody is: "+responseBody);
		int statusCode=response.getStatusCode();
		System.out.println("Status code is: "+statusCode);
		Assert.assertEquals(statusCode,422);
		String message=response.jsonPath().getString("message");
		System.out.println("message is showing right ");
		Assert.assertEquals(message, "Data validation failed. Please check the response body for detailed error messages.");
		}
	@Test(priority=2)
	public void withoutAuth() {
		System.out.println("withoutAuth testcase");
		BaseTest bt= new BaseTest();
		bt.BaseUrl();
		String email=bt.getrandomEmail(10);
		RequestSpecification httprequest=RestAssured.given();
		JSONObject requestparams=new JSONObject();
		requestparams.put("first_name", "Sushmita");
		requestparams.put("last_name", "Salunkhe");
		requestparams.put("email", email+"@gmail.com");
		requestparams.put("first_name", "Sushmita");
		httprequest.body(requestparams.toJSONString());
		Response response =httprequest.request(Method.POST,"/users");
		String responseBody=response.getBody().asString();
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 402);
	String message=response.jsonPath().get("message");
	//Assert.assertEquals(message, "Authentication failed.");
	}

}

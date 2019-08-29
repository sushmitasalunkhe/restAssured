package restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import restApi.Base.BasePage;

public class getAuth extends BasePage {
	
	//@Test(priority=0)
 void gettoken() {
		System.out.println("testcase running: get auth");
		BasePage bp=new BasePage();
		bp.BaseUrl();
	//requestobject
	RequestSpecification httprequest=RestAssured.given();
	

	JSONObject requestParams=new JSONObject();
	
	requestParams.put("email","eve.holt@reqres.in");
	requestParams.put("password","pistol");

	
	httprequest.header("Content-Type","application/json");
	
	httprequest.body(requestParams.toJSONString());
	
	//responseobject
	Response response=httprequest.request(Method.POST,"register");
	String responseBody=response.getBody().asString();
	System.out.println("responseBody is: "+responseBody);
	//status code validation
	int statusCode=response.getStatusCode();
	System.out.println("Status code is: "+statusCode);
	Assert.assertEquals(statusCode,200);
	System.out.println("testcase passed");
	
	String token=response.jsonPath().get("token");
	 
	System.out.println("token is: "+token);
	}
	//@Test(priority=1)
	public void emptycreds() {
		System.out.println();
		System.out.println("testcase running: empty credentials");
		BasePage bp=new BasePage();
		bp.BaseUrl();
	//requestobject
	RequestSpecification httprequest=RestAssured.given();
	

	JSONObject requestParams=new JSONObject();
	
	requestParams.put("email","");
	requestParams.put("password","");

	
	httprequest.header("Content-Type","application/json");
	
	httprequest.body(requestParams.toJSONString());
	
	//responseobject
	Response response=httprequest.request(Method.POST,"register");
	String responseBody=response.getBody().asString();
	System.out.println("responseBody is: "+responseBody);
	//status code validation
	int statusCode=response.getStatusCode();
	System.out.println("Status code is: "+statusCode);
	Assert.assertEquals(statusCode,400);
	String error_message=response.jsonPath().get("error");
	Assert.assertEquals(error_message, "Missing email or username");
	System.out.println("testcase passed");
	}
	//@Test(priority=2)
	public void wrongcreds() {
		System.out.println();
		System.out.println("testcase running: wrong credentials");
		BasePage bp=new BasePage();
		bp.BaseUrl();
	//requestobject
	RequestSpecification httprequest=RestAssured.given();
	

	JSONObject requestParams=new JSONObject();
	
	requestParams.put("email","xyz");
	requestParams.put("password","123");

	
	httprequest.header("Content-Type","application/json");
	
	httprequest.body(requestParams.toJSONString());
	
	//responseobject
	Response response=httprequest.request(Method.POST,"register");
	String responseBody=response.getBody().asString();
	System.out.println("responseBody is: "+responseBody);
	//status code validation
	int statusCode=response.getStatusCode();
	System.out.println("Status code is: "+statusCode);
	Assert.assertEquals(statusCode,400);
	String error_message=response.jsonPath().get("error");
	Assert.assertEquals(error_message, "Note: Only defined users succeed registration");
	System.out.println("testcase passed");

	}
	
}

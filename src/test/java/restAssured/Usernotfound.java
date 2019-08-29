package restAssured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import restApi.Base.BasePage;
import restApi.Base.BaseTest;

public class Usernotfound {
	@Test
	public void userNotFound() {

		System.out.println();
		System.out.println("testcase running: usernot found");
		BaseTest bt=new BaseTest();
		bt.BaseUrl();
	
		String token=bt.gettoken();
		RequestSpecification httprequest=RestAssured.given().auth().oauth2(token);

	JSONObject requestParams=new JSONObject();
	httprequest.header("Content-Type","application/json");
	
	httprequest.body(requestParams.toJSONString());
	
	//responseobject
	Response response=httprequest.request(Method.GET,"users/0");
	String responseBody=response.getBody().asString();
	System.out.println("responseBody is: "+responseBody);
	//status code validation
	int statusCode=response.getStatusCode();
	System.out.println("Status code is: "+statusCode);
	Assert.assertEquals(statusCode,404);
	System.out.println("testcase passed");
	}

}

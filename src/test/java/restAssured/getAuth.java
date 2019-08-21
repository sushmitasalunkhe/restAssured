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
	
	@Test
void getToken() {
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
	Response response=httprequest.request(Method.POST,"/api/register");
	String responseBody=response.getBody().asString();
	System.out.println("responseBody is: "+responseBody);
	//status code validation
	int statusCode=response.getStatusCode();
	System.out.println("Status code is: "+statusCode);
	Assert.assertEquals(statusCode,200);
	
	
	
	
}
}

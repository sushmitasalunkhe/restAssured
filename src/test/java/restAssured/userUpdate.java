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



public class userUpdate extends BaseTest {
	

		
	@Test
	public void UpdateUser() {
		
		System.out.println("testcase running: update userdetails");
	BaseTest bt=new BaseTest();
	bt.BaseUrl();
	String token=bt.gettoken();
	String email=bt.getrandomEmail(10);
	RequestSpecification httprequest=RestAssured.given().auth().oauth2(token);
	JSONObject requestParams=new JSONObject();
	requestParams.put("first_name","bcnd");
	requestParams.put("last_name","mdmdmmd");
	requestParams.put("gender","male");
	requestParams.put("email",email+"@gmail.com");
	requestParams.put("status","active");

	httprequest.header("Content-Type","application/json");
	httprequest.body(requestParams.toJSONString());

	httprequest.body(requestParams.toJSONString());
	//responseobject

	Response response=httprequest.request(Method.PATCH,"users/123");
	String responseBody=response.getBody().asString();
	System.out.println("responseBody is: "+responseBody);
	int statusCode=response.getStatusCode();
	System.out.println("Status code is: "+statusCode);
	Assert.assertEquals(statusCode,200);
	//success code validation
		String name=response.jsonPath().get("name");
		Assert.assertEquals(name, "morpheus");
		System.out.println("testcase passed");
	}
		

}

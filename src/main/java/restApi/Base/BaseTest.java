package restApi.Base;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseTest extends BasePage {

	public  String gettoken() {

		/*BasePage bp=new BasePage();
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
	String responseBody=response.getBody().asString();*/
	 String token="DWwcr_fYLlG1u5kn3WD7C2tYWkjFeEuJcW7B";
	return token;
	}
	  public static String getrandomEmail(int n) 
	    { 
	  
	        // chose a Character random from this String 
	        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	                                    + "0123456789"
	                                    + "abcdefghijklmnopqrstuvxyz"; 
	  
	        // create StringBuffer size of AlphaNumericString 
	        StringBuilder sb = new StringBuilder(n); 
	  
	        for (int i = 0; i < n; i++) { 
	  
	            // generate a random number between 
	            // 0 to AlphaNumericString variable length 
	            int index 
	                = (int)(AlphaNumericString.length() 
	                        * Math.random()); 
	  
	            // add Character one by one in end of sb 
	            sb.append(AlphaNumericString 
	                          .charAt(index)); 
	        } 
	  
	        return sb.toString(); 
	    } 
	
}

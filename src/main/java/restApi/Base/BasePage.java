package restApi.Base;

import io.restassured.RestAssured;

public class BasePage {
	
	public static void BaseUrl() {
		RestAssured.baseURI="https://gorest.co.in/public-api";

	}
	
	
}

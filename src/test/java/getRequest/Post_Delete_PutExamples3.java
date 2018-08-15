package getRequest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_Delete_PutExamples3 {
	@Test
	public void test1() {
		
		RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
		
		JSONObject json = new JSONObject();
		json.put("id", "21");
		json.put("title", "selenium webdriver4");
		json.put("author", "NORAYR");
		request.body(json.toJSONString());
		Response response = request.put("http://localhost:3000/posts/21");
		int code = response.getStatusCode();
		System.out.println("response code is :"+ code);
		Assert.assertEquals(code, 200);
		
	}

}

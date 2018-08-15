package getRequest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_Delete_PutExamples2 {
	@Test
	public void test1() {
		
		RequestSpecification request = RestAssured.given();
		Response response = request.delete("http://localhost:3000/posts/25");
		int code = response.getStatusCode();
		Assert.assertEquals(code, 200);
		
	}

}

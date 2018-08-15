package getRequest;

import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class basics5 {
	
	public void test() {
		RestAssured.baseURI = "http://localhost:3000/posts";
		
		given().
		      param("location","-33.8670522,151.1957362").
		      param("radius","500").
		      param("key","AIzaSyCBga0fW7H20B1i3QPC9TIKMyAFfxirkaU").
		      when().
		      get("/maps/api/place/nearbysearch/json").
		      then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		      body("results[0].name",equalTo("Cruise Bar, Restaurant & Events")).and().
		      body("results[0].place_id",equalTo("ChIJi6C1MxquEmsR9-c-3O48ykI")).and().
		      header("Server","scaffolding on HTTPServer2");
		      
		      }
	@Test
	public void testa() {
		
		
		JSONObject json = new JSONObject();
		json.put("userId", "27");
		json.put("title", "selendroidenium webdriver4");
		json.put("id", "201");
		json.put("body", "alue");
		Response resp = given().
		header("Content-Type", "application/json").
		body(json.toString()).
		post("https://jsonplaceholder.typicode.com/posts");
		
		System.out.println(resp.asString());
		
	}

}

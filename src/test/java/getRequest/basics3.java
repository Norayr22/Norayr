package getRequest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class basics3 {
	
	@Test
	public void postData() {
		
		String b = "{"+
				"\"location\":{"+
				 "\"lat\": -33.8669710,"+
				"\"lng\": 151.1958750"+
				 "},"+
				"\"accuracy\":50,"+
				 "\"name\": \"Google Shoes!\","+
				"\"phone_number\": \"(02) 9374 4000\","+
				 "\"address\":\"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","+
			 	"\"types\":[\"shoe_store\"],"+
		      	"\"website\": \"http://www.google.com.au/\","+
			 	"\"language\": \"en-AU\""+
		      	"}";
		
		
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		Response res = given().
		queryParam("key", "AIzaSyACSslVlO0sIt5oTFcz3LLchlTqW8nLYIo").
		body(b).
		when().
		post("/maps/api/place/add/json").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
		and().body("status", equalTo("OK")).
		extract().response();
		
		String responseString = res.asString();
		System.out.println(responseString);
		
		
		
		
		
	}
	

}

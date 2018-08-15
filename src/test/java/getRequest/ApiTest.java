package getRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.Cookies;

import static io.restassured.RestAssured.*;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ApiTest {
	
	
		    
	  
	@Test
	public void test() throws InterruptedException {
		 JSONArray files = new JSONArray();
         
	        JSONArray galleryIds = new JSONArray();
	      
	        JSONObject attachment = new JSONObject();
	        attachment.put("files", files);
	        attachment.put("galleryIds", galleryIds);
	        
	        JSONObject background = new JSONObject();
	        background.put("gradient", "");
	            
	        JSONObject link = new JSONObject();
	        link.put("title", "");
	        link.put("image", "");
	        link.put("url", "");
	        link.put("description", "");
	        
	        JSONObject finald = new JSONObject();
	        finald.put("attachment",attachment);
	        finald.put("background",background);
	        finald.put("link", link);
	        finald.put("loading", false);
	        finald.put("text", "Testing post create");
	        finald.put("typeId", 3);
	        
		    RestAssured.baseURI = "https://api.sylkar-dev.tk";
		
			for(int i = 0; i<5; i++) {
			given().header("Content-Type","application/json").header("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzYWx0IjoiczNHQmQxIiwiaWQiOiJjZjVlZjJlNy1iN2RhLTQxZjktYWY1My02ZWJjMTRhNGVlMDUiLCJpYXQiOjE1MzQzMTM3NjB9.JZSK6jf18_5VhnSVNCPZm-P8gV0YjfkShwrDwOCRVnw").
					body(finald.toJSONString()).post("/v1/posts").then().assertThat().statusCode(201);}
			
			

			
			
			
			}
	
	
	
	}
			


	

	      

	


package getRequest;

import static io.restassured.RestAssured.get;
import static org.testng.Assert.assertTrue;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import bsh.ParseException;

public class GetData {
//	@Test
	public void testResponsecode() {
		
		int code  = get("http://parabank.parasoft.com/parabank/services/bank/customers/12212/").getStatusCode();
		System.out.println(code);
		Assert.assertEquals(code, 200);
	}
	
//	@Test
	public void testBody() {
		
		String data = get("http://parabank.parasoft.com/parabank/services/bank/customers/12212/").asString();
		long time = get("http://parabank.parasoft.com/parabank/services/bank/customers/12212/").getTime();
		System.out.println(data);
		System.out.println(time);
	}
	@Test
	public void testBody1() throws org.json.simple.parser.ParseException {
		
		String data = get("http://overpass-api.de/api/interpreter?data=[out:json];node(around:400,59.93823555,30.2668659740719)[amenity=cafe];out;").asString();
		System.out.println(data);
		int code  = get("http://overpass-api.de/api/interpreter?data=[out:json];node(around:400,59.93823555,30.2668659740719)[amenity=cafe];out;").getStatusCode();
		System.out.println(code);
		Assert.assertEquals(code, 200);
		JSONObject objects;
		JSONParser helper = new JSONParser();
		objects = (JSONObject)helper.parse(data);
		// Note that these may throw several exceptions
		JSONArray array = (JSONArray)objects.get("elements");
		int cafe_count = array.size();
		System.out.println(array.size());
	
		
		Assert.assertTrue(cafe_count  >= 2 , "there is not enough cafe in radious");  
		}
	}


package getRequest;

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

import io.restassured.RestAssured;
import io.restassured.http.Cookies;

import static io.restassured.RestAssured.*;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ApiTest2 {
	
	
		 
		    
	  
	@Test
	public void test() throws InterruptedException {
		RestAssured.baseURI = "https://api.taiga.io";
		JSONObject requestParams = new JSONObject();
		requestParams.put("username", "sqa.days@yandex.ru"); // Cast
		requestParams.put("password", "Armenia2018");
		requestParams.put("type", "normal");
		
		 String ACCES_TOKEN = given().header("Content-Type","application/json").body(requestParams.toJSONString()).post("/api/v1/auth").then().extract().path("auth_token");
		 String project_name = "Norayr 33533";
		
		 
		 JSONObject request = new JSONObject();
			request.put("is_private", "false"); // Cast
			request.put("creation_template", "1");
			request.put("name", project_name);
			request.put("description", "Test22");
			
			int Proejct_Id = given().header("Content-Type","application/json").header("Authorization","Bearer "+ACCES_TOKEN+"").body(request.toJSONString()).post("/api/v1/projects").then().extract().path("priorities[0].project_id");
			
			

			
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			WebDriver driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			
			driver.get("https://tree.taiga.io/project/sqadaystest-"+project_name.replace(" ", "-").toLowerCase()+"/");
			
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//a[@class= 'login']"))).click().perform();
			action.moveToElement(driver.findElement(By.xpath("//input[@type = 'text']"))).click().perform();
			driver.findElement(By.xpath("//input[@type = 'text']")).sendKeys("sqa.days@yandex.ru");
			action.moveToElement(driver.findElement(By.xpath("//input[@type = 'password']"))).click().perform();
			driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys("Armenia2018");
			action.moveToElement(driver.findElement(By.xpath("//button[@type = 'submit']"))).click().perform();
			
			
			
			Assert.assertTrue(driver.findElement(By.xpath("//tg-svg[@svg-icon = 'icon-like']")).isDisplayed());
			Thread.sleep(2000);
			
			given().header("Authorization","Bearer "+ACCES_TOKEN+"").delete("/api/v1/projects/"+Proejct_Id+"");
			driver.get("https://tree.taiga.io/project/sqadaystest-"+project_name.replace(" ", "-").toLowerCase()+"/");
			Assert.assertTrue(driver.findElement(By.xpath("//h1[@translate = 'ERROR.NOT_FOUND']")).isDisplayed());  
			
			Thread.sleep(2000);
			driver.close();
				
			}
			


	
//	 @Test
	    public void login_state_should_be_restored() throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        driver.get("https://tree.taiga.io/login?next=%252Fdiscover");
	        Actions action = new Actions(driver);
	        action.moveToElement(driver.findElement(By.xpath("//input[@type = 'text']"))).click().perform();
			driver.findElement(By.xpath("//input[@type = 'text']")).sendKeys("sqa.days@yandex.ru");
			action.moveToElement(driver.findElement(By.xpath("//input[@type = 'password']"))).click().perform();
			driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys("Armenia2018");
			action.moveToElement(driver.findElement(By.xpath("//button[@type = 'submit']"))).click().perform();
			Assert.assertTrue(driver.findElement(By.xpath("//tg-svg[@svg-icon = 'icon-like']")).isDisplayed());
	      
	        //Before closing the browser, read the cookies
	        Set<Cookie> allCookies = driver.manage().getCookies();
	        driver.close();
	        System.out.println(allCookies);
	        //open a new browser window
	        driver = new ChromeDriver();
	        //restore all cookies from previous session
	     
	        driver.get("https://tree.taiga.io/login?next=%252Fdiscover");
	        
	            
	        }
	      

	}


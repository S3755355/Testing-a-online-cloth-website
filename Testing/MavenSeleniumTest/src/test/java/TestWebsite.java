
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.inflectra.spiratest.addons.junitextension.SpiraTestCase;
import com.inflectra.spiratest.addons.junitextension.SpiraTestConfiguration;

/**
 * 
 * @author Homy
 * @version 1.0
 * @since 09/2019 This code is a base code for RMIT Software Testing/ Selenium Lab Assessment.
 *        You may need to change the webpage target and test methods based on your assessment spec.
 *        You can send email to amirhomayoon.ashrafzadeh@rmit.edu.au if you have any question
 *        Alternatively use your course Canvas forum Assessment specification is
 *        available on Canvas/Assignment
 * 
 */

/*
 * You must "junit 5 extension.jar" from SpiraTeam to your
 * project/properties/java build path, Library tab as an External Jar
 * 
 */

@SpiraTestConfiguration(
		// following are REQUIRED
		url = "https://rmit-university.spiraservice.net",
		login = "MShSIVARAJ", 
	password = "{84488E63-7BAF-4BA8-9E08-40D767F5F7C8}", 
		projectId = 822
// following are OPTIONAL
// releaseId = 7, testSetId = 1)
)
@TestMethodOrder(OrderAnnotation.class) // << this annotation is for using @order, or adding order to my test-cases
public class TestWebsite {
		private static ChromeDriver driver;
	private String expectedResult;
	private String actualResult;
	private WebElement element;
	private WebDriverWait wait;
	

	@BeforeAll
	// setup my driver here through @BeforeAll, this method is running once before
	// all test-cases
	public static void setup() {
		
		
		
		System.setProperty("Webdriver.chrome.driver", "chromedriver");
		

		driver = new ChromeDriver();

	}

	@Test
	@Order(1) 
	@SpiraTestCase(testCaseId = 23236)
		public void testwebsite() {

		driver.get("http://automationpractice.com/");

				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		

		expectedResult = "My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);

	}
	
	
	@Test
	@Order(2) 
	@SpiraTestCase(testCaseId =23239)
	
	public void SigninTest() {

		driver.findElement(By.className("login")).click();
		expectedResult ="Login - My Store" ;
		actualResult =driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	@Test
	@Order(3) 
	@SpiraTestCase(testCaseId =23239)

	public void AccountLoginTest() {

		driver.findElement(By.name("email")).sendKeys("sharmasivara@gmail.com");
		
		WebDriverWait wait = new WebDriverWait(driver, 20);

		// 3.4 wait(maximum 20sec) until the password field can be located
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("passwd")));
		driver.findElement(By.name("passwd")).sendKeys("Sharma@123");
		driver.findElement(By.xpath("//*[@id=\'SubmitLogin\']/span")).click();
		expectedResult ="My account - My Store" ;
		actualResult =driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	@Test
	@Order(4) 
	@SpiraTestCase(testCaseId =23244)
		public void SearchItemTest() {

		driver.findElement(By.name("search_query")).sendKeys("T-shirt");
	
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit_search")));
		driver.findElement(By.name("submit_search")).click();
		expectedResult ="Search - My Store";
		actualResult =driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	@Test
	@Order(5) 
	@SpiraTestCase(testCaseId =23571)
	
	public void CatergoryTest() {

		driver.findElement(By.className("sf-with-ul")).click();
	   expectedResult ="Women - My Store";
		actualResult =driver.getTitle();
		assertEquals(expectedResult, actualResult);
		
		driver.findElement(By.xpath("//*[@id=\'block_top_menu\']/ul/li[2]/a")).click();
		 expectedResult ="Dresses - My Store";
		 actualResult =driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	@Test
	@Order(6) 
	@SpiraTestCase(testCaseId =23996)
	
	public void AddingItemTest() {

		driver.findElement(By.xpath("//*[@id=\'center_column\']/ul/li[1]/div/div[2]/h5/a")).click();
	   expectedResult ="Printed Dress - My Store";
		actualResult =driver.getTitle();
		assertEquals(expectedResult, actualResult);
		
	driver.findElement(By.xpath("//*[@id=\'add_to_cart\']/button/span")).click();
//WebDriverWait wait = new WebDriverWait(driver, 20);
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\'layer_cart\\']/div[1]/div[2]/div[4]/a/span")));
		driver.findElement(By.xpath("//*[@id=\'layer_cart\']/div[1]/div[2]/div[4]/a/span")).click();
		 expectedResult ="Order - My Store";
		 actualResult =driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	@AfterAll
	// closing or quitting the browser after the test
	public static void closeBrowser() {
		driver.close();
		// driver.quit()
	}
    
	
}

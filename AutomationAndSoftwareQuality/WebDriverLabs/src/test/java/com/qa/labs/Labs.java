package com.qa.labs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Labs {
	
	private WebDriver driver;
	
	@BeforeEach
	public void setDriverLocation() {
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	}
	
	@Test
	public void exerciseOne() {
		driver.get("https://www.google.com");
		
		// find accept button using it's id
		// found via chrome inspect tool
		WebElement acceptBtn = driver.findElement(By.cssSelector("#L2AGLb"));
		acceptBtn.click();
		
		
		// same code as previous example
		WebElement searchBar = driver.findElement(By.name("q"));
		searchBar.sendKeys("kittens");
		searchBar.submit();
		
		assertEquals("kittens - Google Search", driver.getTitle());
	}
	
	@Test
	public void exerciseTwo() {
		Navigation navigator = driver.navigate();
		
		navigator.to("https://automatetheboringstuff.com/2e/chapter1/");
		WebElement heading = driver.findElement(By.className("h2b"));
		assertTrue(heading.getText().contains("PYTHON BASICS"));
		
		navigator.back();
		
		navigator.to("https://automatetheboringstuff.com/2e/chapter2/");
		heading = driver.findElement(By.className("h2b"));
		assertTrue(heading.getText().contains("FLOW CONTROL"));
		
		navigator.back();
		
		navigator.to("https://automatetheboringstuff.com/2e/chapter3/");
		heading = driver.findElement(By.className("h2b"));
		assertTrue(heading.getText().contains("FUNCTIONS"));
	}
	
	@Test
	public void exerciseThreeA() {
		driver.get("https://www.saucedemo.com/");
		
		WebElement username = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.id("login-button"));
		
		username.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		login.click();
		
		WebElement invItem = driver.findElement(By.className("inventory_item"));
		
		assertTrue(invItem.isDisplayed());
	}

	@Test
	public void exerciseThreeB() {
		driver.get("https://www.saucedemo.com/");
		
		WebElement username = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.id("login-button"));
		
		username.sendKeys("locked_out_user");
		password.sendKeys("secret_sauce");
		login.click();
		
		WebElement errMsg = driver.findElement(By.cssSelector("h3[data-test=error]"));
		
		assertTrue(errMsg.getText().contains("locked"));
	}
	
	@Test
	public void exerciseThreeC() {
		driver.get("https://www.saucedemo.com/");
		
		WebElement username = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.id("login-button"));
		
		username.sendKeys("problem_user");
		password.sendKeys("wrong");
		login.click();
		
		WebElement errMsg = driver.findElement(By.cssSelector("h3[data-test=error]"));
		
		assertTrue(errMsg.getText().contains("do not match"));
		
	}
//	
//	@Test
//	public void exerciseFourA() {
//		Navigation navigator = driver.navigate();
//		
//		navigator.to("https://www.demoblaze.com/");
//		
//		driver.findElement(By.cssSelector("a[href*='idp_=1']")).click();
//		driver.findElement(By.cssSelector("a[onclick='addToCart(1)']")).click();
//		
//		navigator.back();
//		navigator.back();
//		
//		driver.findElement(By.cssSelector("a[href*='idp_=2']")).click();
//		driver.findElement(By.cssSelector("a[onclick='addToCart(2)']")).click();
//		
//		navigator.back();
//		navigator.back();
//		
//		driver.findElement(By.cssSelector("a[href*='idp_=3']")).click();
//		driver.findElement(By.cssSelector("a[onclick='addToCart(3)']")).click();
//		
//		navigator.back();
//		navigator.back();
//		
//		navigator.to("https://www.demoblaze.com/cart.html");
//		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		assertEquals(3, driver.findElements(By.className("success")).size());
//
//	}
//	
//	@Test
//	public void exerciseFourB() {
//		Navigation navigator = driver.navigate();
//		
//		navigator.to("https://www.demoblaze.com/");
//		
//		driver.findElement(By.cssSelector("a[href*='idp_=1']")).click();
//		driver.findElement(By.cssSelector("a[onclick='addToCart(1)']")).click();
//		
//		navigator.to("https://www.demoblaze.com/cart.html");
//		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		driver.findElement(By.cssSelector("button[data-target='#orderModal']")).click();
//		
//		driver.findElement(By.id("name")).sendKeys("test");
//		driver.findElement(By.id("country")).sendKeys("test");
//		driver.findElement(By.id("city")).sendKeys("test");
//		driver.findElement(By.id("card")).sendKeys("12345");
//		driver.findElement(By.id("month")).sendKeys("1");
//		driver.findElement(By.id("year")).sendKeys("2023");
//		
//		driver.findElement(By.cssSelector("button[onclick='purchaseOrder()']")).click();
//		
//		String results = driver.findElement(By.className("lead")).getText();
//		
//		assertTrue(results.contains("360"));
//		assertTrue(results.contains("12345"));
//		assertTrue(results.contains("test"));
//
//	}
	
	@AfterEach
	public void cleanUp() {
		driver.quit();
	}
	
}

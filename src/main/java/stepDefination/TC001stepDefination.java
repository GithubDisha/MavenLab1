package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC001stepDefination 
{
	WebDriver driver;
	@Test(description="Hard Assert",enabled=false)
	
	@Given("User is on Home Page")
	public void user_is_on_home_page() 
	{
		System.out.println("Open Rediff");
		driver=new ChromeDriver();
		driver.get("https://www.rediff.com/");
		driver.manage().window().maximize();
	   
	}
	
	@When("User Clicks on Singin Link")
	public void user_clicks_on_singin_link() 
	{
		System.out.println("Login Rediff");
		driver.findElement(By.linkText("Sign in")).click();
	
	}
	
	@Then("Check Title")
	public void check_title()
	{
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Rediffmail123");
		System.out.println("Assert Executed..");
   	}
	
	@When("user entered Username and Password clicks on Submit")
	public void user_entered_username_and_password_clicks_on_submit() 
	{
		driver.findElement(By.id("login1")).sendKeys("dp_1624");
		driver.findElement(By.id("password")).sendKeys("@Sree26!");
		driver.findElement(By.id("remember")).click();
		driver.findElement(By.name("proceed")).click();
	}
	
	@Then("Check Login Succesfull")
	public void check_login_succesfull() 
	{
		SoftAssert assertion=new SoftAssert();
		Reporter.log("Login Successful..");
		driver.findElement(By.linkText("Logout")).click();
		assertion.assertAll();
	}

}

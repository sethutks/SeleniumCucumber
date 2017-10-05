package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	
	public static RemoteWebDriver driver;
	
	@Before
	public void startTestScenario(Scenario sc) {
		System.out.println("I am starting the test scenario");
		System.out.println("Scenario Name "+sc.getName());
		System.out.println("Scenario Id "+sc.getId());
	}
	
	@After
	public void endTestScenario(Scenario sc) {
		System.out.println("I am ending the test scenario");
		System.out.println("Scenario Status "+ sc.getStatus());
		driver.quit();
	}
	
	@Given("Launch the chrome browser")
	public void launchBrowser(){
	   System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	   driver = new ChromeDriver();
	}
	
	@Given("Maximize")
	public void Maximize(){
	   driver.manage().window().maximize();
	}
	
	@Given("Set timeout")
	public void setTimeout(){
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	@Given("Enter URL (.*)")
	public void enterURL(String url){
	   driver.get(url);
	}
	
	@When("Enter User Name (.*)")
	public void enterUserName(String username){
	   driver.findElementById("username").sendKeys(username);
	}
	
	@When("Enter Password (.*)")
	public void enterPassword(String password){
		   driver.findElementById("password").sendKeys(password);
	}
	
	@When("Click Login")
	public void clickLogin() {
		driver.findElementByXPath("//input[@value='Login']").click();
	}
	
	@Then("Verify the Welcome Message")
	public void verifyWelcomeMessage() {
		String text = driver.findElementByXPath("//*[@id='form']/h2").getText();
		if(text.equals("Welcome")) {
			System.out.println("The Welcome message is displayed successfully");
		}else {
			System.err.println("The Welcome message is not displayed");
		}
	}
	
	@But("Login should not be successful")
	public void isLoginNotDisplayed() {
		String errorMsg = driver.findElementByXPath("//div[@id='errorDiv']/p[2]").getText();
		if(errorMsg.contains("User not found")) {
			System.out.println("The Login Error message is displayed successfully");
		}else {
			System.err.println("The Login Error message is not displayed");
		}
	}
}

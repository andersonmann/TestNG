package firstTestCaseWithTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestNG {

	static String browser = "webdriver.chrome.driver";
	static String path = "C:\\Program Files\\Java\\chrome\\chromedriver.exe";
	public WebDriver driver;

	@Test
	public void f() {

		// Find the element that's ID attribute is 'account'(My Account)
		driver.findElement(By.id("account")).click();

		// Find the element that's ID attribute is 'log'(Usarname)
		// Enter Username on the element found by above desc
		driver.findElement(By.id("log")).sendKeys("anderson");

		// Find the element that's ID attribute is 'pwd'(Password)
		// Enter password on the element found by the above desc.
		driver.findElement(By.id("pwd")).sendKeys("escola3092");

		// Now submit the form. WebDriver will find form for us from the element
		driver.findElement(By.id("login")).click();

		// Print a Log In message to the screen
		System.out.println("Login Successfully, now it is the time to Log Off buddy");

		// Find the element that's ID attribute is 'account_logout'(Log Out)
		driver.findElement(By.id("account_logout"));

	}

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the Chrome driver
		System.setProperty(browser, path);
		driver = new ChromeDriver();

		// Put a Implicit wait, this means that any search for elements on the
		// page could take the time the implicit
		// wait is set for before throwing exception
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch the Online Website
		driver.get("http://www.store.demoqa.com");

	}

	@AfterMethod
	public void afterMethod() {
		// Close the driver
		driver.quit();
	}

}

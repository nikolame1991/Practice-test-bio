package practicetestAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTestClass {
	WebDriver driver;

	PageClasses practicetestPageClass;

	// Initializes WebDriver and test environment before running tests
	// Inicijalizuje WebDriver i test okruženje pre pokretanja testova
	@BeforeTest
	public void initalization() {
		driver = new ChromeDriver(); // Creates a new ChromeDriver instance
		// Kreira novu instancu ChromeDriver-a
		driver.manage().window().maximize(); // Maximizes the browser window for better visibility
		// Maksimizuje prozor pregledača radi bolje preglednosti

		practicetestPageClass = new PageClasses(driver); // Initializes PageClasses for test execution
		// Inicijalizuje PageClasses za izvršavanje testova
	}

	// Closes WebDriver and cleans up resources after tests
	// Zatvara WebDriver i čisti resurse nakon testiranja
	@AfterTest
	public void closeDriver() {
		driver.quit(); // Closes the browser and terminates the WebDriver session
		// Zatvara pregledač i prekida sesiju WebDriver-a
	}
}

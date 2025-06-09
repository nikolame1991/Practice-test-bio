package practicetestAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTestClassContact {
	WebDriver driver;

	ContactPageClass contactPracticetest;

	// Initializes the WebDriver and sets up the environment before running tests
	// Inicijalizuje WebDriver i postavlja okruženje pre pokretanja testova
	@BeforeTest
	public void initalization() {
		driver = new ChromeDriver(); // Creates an instance of ChromeDriver
		// Kreira instancu ChromeDriver-a
		driver.manage().window().maximize(); // Maximizes the browser window
		// Maksimizuje prozor pregledača

		contactPracticetest = new ContactPageClass(driver); // Initializes the ContactPageClass object
		// Inicijalizuje objekat ContactPageClass
	}

	// Closes the WebDriver after tests have been executed
	// Zatvara WebDriver nakon što se testovi izvrše
	@AfterTest
	public void closeDriver() {
		driver.quit(); // Closes the browser and ends the WebDriver session
		// Zatvara pregledač i završava sesiju WebDriver-a
	}
}

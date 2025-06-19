package practicetestAutomation;

import org.testng.annotations.DataProvider;

public class TestDataPracticeTestAutomation {

	// Validno korisničko ime za test login stranice
	// Valid username for test login page
	public String VALID_NAME = "student";

	// Validna lozinka za test login stranice
	// Valid password for test login page
	public String VALID_PASSWORD = "Password123";

	// TestNG DataProvider koji obezbeđuje podatke za testiranje logovanja
	// TestNG DataProvider providing login credentials for testing
	@DataProvider(name = "userData")
	public Object[][] userData() {
		return new Object[][] {
			{ VALID_NAME, VALID_PASSWORD }
		};
	}
}

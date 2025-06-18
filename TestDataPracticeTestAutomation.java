package practicetestAutomation;

import org.testng.annotations.DataProvider;

public class TestDataPracticeTestAutomation {

	public String VALID_NAME = "student";
	public String VALID_PASSWORD = "Password123";

	@DataProvider(name = "userData")
	public Object[][] userData() {
		return new Object[][] { { "student", "Password123" } };
	}
}

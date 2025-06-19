package practicetestAutomation;

import org.testng.annotations.DataProvider;

public class TestDataContact {

	// Validno ime za testiranje kontakt forme
	// Valid first name for contact form testing
	public String VALID_NAMECONTACT = "Nikola";

	// Validno prezime za testiranje kontakt forme
	// Valid last name for contact form testing
	public String VALID_LASTNAMECONTACT = "Medan";

	// Validna email adresa za testiranje
	// Valid email address for testing
	public String VALID_EMAIL = "nikolamedan1991@gmail.com";

	// Validna poruka za tekstualno polje
	// Valid message for textarea input
	public String VALID_TEXTAREA = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";

	// TestNG DataProvider koji vraća kombinaciju korisničkih podataka
	// TestNG DataProvider returning a combination of user input data
	@DataProvider(name = "userData")
	public Object[][] userData() {
		return new Object[][] {
			{ VALID_NAMECONTACT, VALID_LASTNAMECONTACT, VALID_EMAIL, VALID_TEXTAREA }
		};
	}
}

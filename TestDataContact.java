package practicetestAutomation;

import org.testng.annotations.DataProvider;

public class TestDataContact {

	public String VALID_NAMECONTACT = "Nikola";
	public String VALID_LASTNAMECONTACT = "Medan";
	public String VALID_EMAIL = "nikolamedan1991@gmail.com";
	public String VALID_TEXTAREA = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";

	@DataProvider(name = "userData")
	public Object[][] userData() {
		return new Object[][] { { "Nikola", "Medan", "nikolamedan1991@gmail.com",
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry." } };
	}

}
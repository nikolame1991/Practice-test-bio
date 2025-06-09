package practicetestAutomation;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageClassTest extends BaseTestClass {

	@BeforeMethod
	public void navigation() {
		driver.navigate().to("https://practicetestautomation.com/");
	}

	@AfterMethod
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
	}

	@Test
	public void checkingWeb() {

		// Click the logo link
		// Klik na logo link
		practicetestPageClass.clickLinkLogo();

		// Navigate to the practice section
		// Navigacija ka sekciji za vežbu
		practicetestPageClass.clickPracticeNav();

		// Click on the test login page link
		// Klik na link stranice za test prijavu
		practicetestPageClass.verifyClickTestLoginPage();

		// Verify the heading on the login page
		// Provera naslova na stranici za prijavu
		practicetestPageClass.verifyHeading();

		// Verify expected text on the login page
		// Provera očekivanog teksta na stranici za prijavu
		practicetestPageClass.verifyText();

		// Enter username
		// Unos korisničkog imena
		practicetestPageClass.fieldInputName("student");

		// Enter password
		// Unos lozinke
		practicetestPageClass.fieldInputPassword("Password123");

		// Click submit button
		// Klik na dugme za prijavu
		practicetestPageClass.clickButtonSubmit();

		// Attempt to log out
		// Pokušaj odjave
		practicetestPageClass.clickButtonLogOut();

		// Check for error message
		// Provera poruke o grešci
		practicetestPageClass.showError();

		// Assert that the horizontal rule is displayed
		// Provera da li je horizontalna linija vidljiva
		Assert.assertTrue(practicetestPageClass.isHorizontalRuleDisplayed(), "HR element nije vidljiv!");

		// Verify that the header is displayed
		// Provera da li je zaglavlje prikazano
		practicetestPageClass.isHeader5Displayed();

		// Verify information display
		// Provera prikaza informacija
		practicetestPageClass.isInformationDisplayed();

		// Click on the contact link
		// Klik na kontakt link
		practicetestPageClass.linkContactClick();
	}
}
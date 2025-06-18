package practicetestAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactTest extends BaseTestClassContact {

	// Navigates to the contact page before each test
	// Navigacija ka stranici za kontakt pre svakog testa
	@BeforeMethod
	public void navigation() {
		driver.navigate().to("https://practicetestautomation.com/contact/");
	}

	// Deletes cookies after each test
	// Brisanje kolačića nakon svakog testa
	@AfterMethod
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
	}

	// Test to check the presence of key elements on the contact page
	// Test za proveru prisustva ključnih elemenata na stranici za kontakt
	@Test
	public void checkPageContact() {
		// Verify that the header text is displayed
		// Provera da li je prikazan tekst zaglavlja
		contactPracticetest.headerTextIsDisplay();

		// Verify that the image is displayed
		// Provera da li je slika prikazana
		contactPracticetest.imageIsDisplayed();

		// Verify that general text is displayed
		// Provera da li je opšti tekst prikazan
		contactPracticetest.textIsDisplayed();

		// Verify and trim text content for validation
		// Provera i skraćivanje tekstualnog sadržaja radi validacije
		contactPracticetest.verifyAndTrimText();
	}

	// Test for validating input fields in the contact form
	// Test za validaciju ulaznih polja u kontakt formi
	@Test
	public void validationInputFields() {
		// Enter first name
		// Unos imena
		contactPracticetest.checkInputFieldName("Nikola");

		// Enter last name
		// Unos prezimena
		contactPracticetest.checkInputFieldLastName("Medan");

		// Enter email address
		// Unos email adrese
		contactPracticetest.checkInputFieldEmail("nikolamedan1991@gmail.com");

		// Enter message into the text area
		// Unos poruke u polje za unos teksta
		contactPracticetest.checkTextarea(
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.");

		// Click on CAPTCHA checkbox
		// Klik na CAPTCHA checkbox
		contactPracticetest.checkboxClickRobot();

		// Click the submit button
		// Klik na dugme za slanje forme
		contactPracticetest.clickSubmitButton();
	}

	// Test for validation error cases
	// Test za validaciju grešaka u unosu
	@Test
	public void validationError() {
		// Enter empty name (should trigger validation error)
		// Unos praznog imena (trebalo bi da izazove grešku u validaciji)
		contactPracticetest.checkInputFieldName("");

		// Enter incorrect email format
		// Unos nepravilnog formata email adrese
		contactPracticetest.checkInputFieldEmail("not_an_email");

		// Click CAPTCHA before page is fully loaded
		// Klik na CAPTCHA pre nego što je stranica potpuno učitana
		contactPracticetest.checkboxClickRobot();

		// Using a non-existent selector for submit button (intentionally incorrect)
		// Korišćenje nepostojećeg selektora za dugme za slanje (namerno pogrešan)
		WebElement wrongSubmitButton = driver.findElement(By.cssSelector("#wrong-submit-id"));
		wrongSubmitButton.click();
	}

	/**
	 * Validates that all input fields on the contact form can be filled using test
	 * data. Includes checks for: name, last name, email, message textarea, robot
	 * checkbox and submission.
	 *
	 * Validira da se sva polja na kontakt formi mogu popuniti pomoću testnih
	 * podataka. Obuhvata: ime, prezime, e-mail, poruku, potvrdu da korisnik nije
	 * robot i klik na dugme za slanje.
	 */
	@Test
	public void validationInputFieldsWithTestDataProvider() {
		// Enter first name with Test DataProvider
		// Unos imena sa Test DataProvider
		contactPracticetest.checkInputFieldName(contactDataProvider.VALID_NAMECONTACT);

		// Enter last name with Test DataProvider
		// Unos prezimena sa Test DataProvider
		contactPracticetest.checkInputFieldLastName(contactDataProvider.VALID_LASTNAMECONTACT);

		// Enter email address with Test DataProvider
		// Unos email adrese sa Test DataProvider
		contactPracticetest.checkInputFieldEmail(contactDataProvider.VALID_EMAIL);

		// Enter message into the text area with Test DataProvider
		// Unos poruke u polje za unos teksta sa Test DataProvider
		contactPracticetest.checkTextarea(contactDataProvider.VALID_TEXTAREA);

		// Click on CAPTCHA checkbox
		// Klik na CAPTCHA checkbox
		contactPracticetest.checkboxClickRobot();

		// Click the submit button
		// Klik na dugme za slanje forme
		contactPracticetest.clickSubmitButton();
	}

}

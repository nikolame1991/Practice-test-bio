package practicetestAutomation;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPageClass {
	WebDriver driver;
	WebDriverWait wait;

	// Konstruktor za inicijalizaciju drajvera i elemenata
	// Constructor for initializing WebDriver and elements
	public ContactPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Web elementi za kontakt stranicu
	// Web elements for the contact page

	@FindBy(css = "#loop-container > div > article > div.post-header > h1")
	WebElement checkHeaderContact; // Naslov kontakt stranice / Contact page heading

	@FindBy(css = "#loop-container > div > article > div.post-content > div.wp-block-image > figure > img")
	WebElement checkImageProfil; // Profilna slika / Profile image

	@FindBy(css = "#loop-container > div > article > div.post-content > p:nth-child(2)")
	WebElement checkLongText; // Glavni tekst / Main paragraph text

	@FindBy(css = "#loop-container > div > article > div.post-content > p:nth-child(2)")
	WebElement testElement; // Element za testiranje dužine teksta / Text length test element

	@FindBy(css = "#wpforms-161-field_0")
	WebElement inputFieldName; // Polje za ime / First name input field

	@FindBy(css = "#wpforms-161-field_0-last")
	WebElement inputFieldLastName; // Polje za prezime / Last name input field

	@FindBy(css = "#wpforms-161-field_1")
	WebElement inputFieldEmail; // Polje za email / Email input field

	@FindBy(css = "#wpforms-161-field_2")
	WebElement inputTextarea; // Tekstualno polje za poruku / Message textarea

	@FindBy(xpath = "//*[@id=\"recaptcha-anchor\"]/div[1]")
	WebElement checkboxRobot; // CAPTCHA checkbox

	@FindBy(css = "#wpforms-submit-161")
	WebElement clickButtonSubmit; // Dugme za slanje forme / Submit button

	// === Metode za interakciju sa elementima / Methods for interacting with elements ===

	// Proverava da li je naslov stranice prikazan
	// Verifies if the page heading is displayed
	public void headerTextIsDisplay() {
		wait.until(ExpectedConditions.visibilityOf(checkHeaderContact));
	}

	// Proverava da li je slika prikazana
	// Verifies if the profile image is displayed
	public void imageIsDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(checkImageProfil));
	}

	// Proverava da li je tekst prikazan
	// Verifies if the text is displayed
	public void textIsDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(checkLongText));
	}

	// Proverava i skraćuje tekst ako je predugačak
	// Validates and trims long text if necessary
	public void verifyAndTrimText() {
		String fullText = testElement.getText();

		if (fullText.length() > 50) { // Primer: skraćivanje teksta dužeg od 50 karaktera
			String shortText = fullText.substring(0, 50) + "..."; // Skraćena verzija sa znakom ...
			System.out.println("Trimovani tekst: " + shortText); // Trimmed text output
		} else {
			System.out.println("Originalni tekst je kratak: " + fullText); // Text is already short
		}
	}

	// Unosi ime u odgovarajuće polje
	// Inputs first name into the field
	public void checkInputFieldName(String firstname) {
		inputFieldName.clear();
		inputFieldName.sendKeys("Nikola");
	}

	// Unosi prezime u odgovarajuće polje
	// Inputs last name into the field
	public void checkInputFieldLastName(String lastname) {
		inputFieldLastName.clear();
		inputFieldLastName.sendKeys("Medan");
	}

	// Unosi email adresu u polje
	// Inputs email into the field
	public void checkInputFieldEmail(String email) {
		inputFieldEmail.clear();
		inputFieldEmail.sendKeys("nikolamedan1991@gmail.com");
	}

	// Unosi poruku u tekstualno polje
	// Inputs message into the textarea
	public void checkTextarea(String text) {
		inputTextarea.clear();
		inputTextarea.sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
	}

	// Klik na CAPTCHA checkbox unutar iframe-a
	// Handles clicking CAPTCHA checkbox inside iframe
	// Koristimo try-catch blok da bismo bezbedno obradili potencijalne izuzetke
	// koji mogu nastati kada CAPTCHA nije dostupna ili se ne učita na vreme.
	// We use try-catch to safely handle potential exceptions
	// when CAPTCHA is not available or fails to load in time.
	public void checkboxClickRobot() {
		try {
			// Provera iframe-a jer CAPTCHA se često učitava unutar iframe-a
			// Checking for iframe since CAPTCHA usually loads inside one
			List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
			// Proveravamo da li postoji iframe, jer se CAPTCHA često učitava unutar iframe-a.
			// We check if an iframe exists, as CAPTCHA is often loaded inside an iframe.
			if (!iframes.isEmpty()) {
				driver.switchTo().frame(iframes.get(0));
				System.out.println("Prebačeno na CAPTCHA iframe. / Switched to CAPTCHA iframe.");
			} else {
				// Ako iframe ne postoji, CAPTCHA možda još nije učitana ili se prikazuje direktno.
    				// If no iframe is found, CAPTCHA might not have loaded yet or is shown directly.
				System.out.println("CAPTCHA iframe nije pronađen. / No CAPTCHA iframe found.");
			}
			// Proveravamo da li CAPTCHA element postoji pre nego što pokušamo klik.
			// We check if CAPTCHA element exists before attempting to click it.
			if (driver.findElements(By.xpath("//*[@id='recaptcha-anchor']/div[1]")).size() > 0) {
				WebElement captcha = wait.until(ExpectedConditions.elementToBeClickable(checkboxRobot));
				captcha.click();
				System.out.println("CAPTCHA kliknuta! / CAPTCHA clicked!");
			} else {
				// CAPTCHA nije prisutna – izbegavamo pokušaj interakcije.
				// CAPTCHA not present – avoiding interaction to prevent failure.
				System.out.println("CAPTCHA element nije pronađen. / CAPTCHA element not found.");
			}
	
			driver.switchTo().defaultContent(); // Povratak na glavni sadržaj / Switch back to main content
	
		} catch (TimeoutException e) {
			// Ako CAPTCHA kasni sa učitavanjem
			// If CAPTCHA takes too long to load
			System.out.println("Vreme isteklo – CAPTCHA se nije učitala. / Timeout – CAPTCHA not loaded.");
		} catch (NoSuchElementException e) {
			// Ako CAPTCHA element nije pronađen u DOM-u
			// If CAPTCHA element not found in DOM
			System.out.println("Element nije pronađen. / CAPTCHA element not found.");
		}
	}


	// Klik na dugme za slanje forme
	// Clicks the form submit button
	public void clickSubmitButton() {
		wait.until(ExpectedConditions.elementToBeClickable(clickButtonSubmit)).click();
	}
}

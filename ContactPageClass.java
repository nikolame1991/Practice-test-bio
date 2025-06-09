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

	// Constructor for initializing driver and elements
	// Konstruktor za inicijalizaciju drajvera i elemenata
	public ContactPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Web elements for the contact page
	// Web elementi za kontakt stranicu
	@FindBy(css = "#loop-container > div > article > div.post-header > h1")
	WebElement checkHeaderContact;

	@FindBy(css = "#loop-container > div > article > div.post-content > div.wp-block-image > figure > img")
	WebElement checkImageProfil;

	@FindBy(css = "#loop-container > div > article > div.post-content > p:nth-child(2)")
	WebElement checkLongText;

	@FindBy(css = "#loop-container > div > article > div.post-content > p:nth-child(2)")
	WebElement testElement;

	/*-------------------------------------------------------------*/
	@FindBy(css = "#wpforms-161-field_0")
	WebElement inputFieldName;

	@FindBy(css = "#wpforms-161-field_0-last")
	WebElement inputFieldLastName;

	@FindBy(css = "#wpforms-161-field_1")
	WebElement inputFieldEmail;

	@FindBy(css = "#wpforms-161-field_2")
	WebElement inputTextarea;

	@FindBy(xpath = "//*[@id=\"recaptcha-anchor\"]/div[1]")
	WebElement checkboxRobot;

	@FindBy(css = "#wpforms-submit-161")
	WebElement clickButtonSubmit;

	// Methods for interacting with web elements
	// Metode za interakciju sa web elementima

	// Verify if the header text is displayed
	// Provera da li je zaglavlje prikazano
	public void headerTextIsDisplay() {
		wait.until(ExpectedConditions.visibilityOf(checkHeaderContact));
	}

	// Verify if the profile image is displayed
	// Provera da li je profilna slika prikazana
	public void imageIsDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(checkImageProfil));
	}

	// Verify if the text is displayed
	// Provera da li je tekst prikazan
	public void textIsDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(checkLongText));
	}

	// Validate and trim long text if necessary
	// Provera i skraćivanje dugog teksta ako je potrebno
	public void verifyAndTrimText() {
		String fullText = testElement.getText();

		// Check the text length and trim if needed
		// Provera dužine teksta i skraćivanje ako je potrebno
		if (fullText.length() > 50) { // Example: trim if longer than 50 characters
			String shortText = fullText.substring(0, 50) + "..."; // Shortened version with indication
			System.out.println("Trimmed text: " + shortText);
		} else {
			System.out.println("Original text is short: " + fullText);
		}
	}

	// Input first name into the field
	// Unos imena u polje
	public void checkInputFieldName(String firstname) {
		inputFieldName.clear();
		inputFieldName.sendKeys("Nikola");
	}

	// Input last name into the field
	// Unos prezimena u polje
	public void checkInputFieldLastName(String lastname) {
		inputFieldLastName.clear();
		inputFieldLastName.sendKeys("Medan");
	}

	// Input email into the field
	// Unos email adrese u polje
	public void checkInputFieldEmail(String email) {
		inputFieldEmail.clear();
		inputFieldEmail.sendKeys("nikolamedan1991@gmail.com");
	}

	// Input message into the text area
	// Unos poruke u tekstualno polje
	public void checkTextarea(String text) {
		inputTextarea.clear();
		inputTextarea.sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
	}

	// Handle CAPTCHA checkbox click within iframe
	// Obrada klika na CAPTCHA checkbox unutar iframe-a
	public void checkboxClickRobot() {
		try {
			// Check if there are iframes
			// Provera da li postoje iframe-ovi
			List<WebElement> iframes = driver.findElements(By.tagName("iframe"));

			if (!iframes.isEmpty()) {
				driver.switchTo().frame(iframes.get(0)); // Switch to the first iframe
				System.out.println("Switched to CAPTCHA iframe.");
			} else {
				System.out.println("No iframe found, CAPTCHA might be loading directly.");
			}

			// Check if CAPTCHA element exists
			// Provera da li CAPTCHA element postoji
			if (driver.findElements(By.xpath("//*[@id='recaptcha-anchor']/div[1]")).size() > 0) {
				WebElement captcha = wait.until(ExpectedConditions.elementToBeClickable(checkboxRobot));
				captcha.click();
				System.out.println("CAPTCHA clicked!");
			} else {
				System.out.println("CAPTCHA element not found.");
			}

			driver.switchTo().defaultContent(); // Switch back to the main content

		} catch (TimeoutException e) {
			System.out.println("Timeout: CAPTCHA did not load in time.");
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: CAPTCHA might not have loaded correctly.");
		}
	}

	// Click the submit button
	// Klik na dugme za slanje forme
	public void clickSubmitButton() {
		wait.until(ExpectedConditions.elementToBeClickable(clickButtonSubmit)).click();
	}
}

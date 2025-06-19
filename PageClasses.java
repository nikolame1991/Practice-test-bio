package practicetestAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageClasses {
	WebDriver driver;
	WebDriverWait wait;

	// Konstruktor klase – inicijalizuje WebDriver i WebDriverWait
	// Class constructor – initializes WebDriver and WebDriverWait
	public PageClasses(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Web elementi korišćeni pomoću @FindBy anotacija
	// Web elements using @FindBy annotation

	@FindBy(css = "#site-title > a")
	WebElement clickLink; // Logo sajta / Site logo

	@FindBy(css = "#menu-item-20")
	WebElement clickNavPractice; // Navigacija do Practice strane / Navigation to Practice page

	@FindBy(css = "#loop-container > div > article > div.post-content > div:nth-child(2) > div:nth-child(1) > p > a")
	WebElement clickTestLoginPage; // Link ka Test Login stranici / Link to Test Login page

	@FindBy(css = "#login > h2")
	WebElement checkHeading; // Naslov na login stranici / Heading on login page

	@FindBy(css = "#login > ul > li:nth-child(1)")
	WebElement checkText; // Tekst ispod naslova / Text under the heading

	@FindBy(css = "#username")
	WebElement inputFieldUserName; // Polje za korisničko ime / Username input field

	@FindBy(css = "#password")
	WebElement inputFieldPassword; // Polje za lozinku / Password input field

	@FindBy(css = "#submit")
	WebElement clickButton; // Dugme za prijavu / Submit (login) button

	@FindBy(xpath = "//*[@id=\"loop-container\"]/div/article/div[2]/div/div/div/a")
	WebElement clickButtonLogOut; // Dugme za odjavu / Logout button

	@FindBy(xpath = "//*[@id=\"error\"]")
	WebElement showError; // Poruka o grešci / Error message

	@FindBy(xpath = "//*[@id=\"login\"]/hr[1]")
	WebElement horizontalRule; // Horizontalna linija / Horizontal line

	@FindBy(css = "#login > h5:nth-child(6)")
	WebElement header5Displayed; // Podnaslov test slučaja / Test case subtitle

	@FindBy(css = "#login > ol:nth-child(7)")
	WebElement informationDisplay; // Informacije o test koracima / Test steps info

	@FindBy(css = "#menu-item-18 > a")
	WebElement clickContactLink; // Link ka kontakt stranici / Link to contact page

	// ==== Metodi za interakciju sa elementima / Methods for interacting with elements ====

	// Klik na logo / Click on site logo
	public void clickLinkLogo() {
		wait.until(ExpectedConditions.elementToBeClickable(clickLink)).click();
	}

	// Klik na navigaciju "Practice" / Click on "Practice" navigation
	public void clickPracticeNav() {
		wait.until(ExpectedConditions.elementToBeClickable(clickNavPractice)).click();
	}

	// Klik na link za test login stranicu / Click on test login page link
	public void verifyClickTestLoginPage() {
		wait.until(ExpectedConditions.elementToBeClickable(clickTestLoginPage)).click();
	}

	// Provera naslova stranice / Verify page heading
	public void verifyHeading() {
		WebElement headingElement = wait.until(ExpectedConditions.visibilityOf(checkHeading));
		String actualHeading = headingElement.getText();
		String expectedHeading = "Test login";
		Assert.assertEquals(actualHeading, expectedHeading);
	}

	// Proverava da li se tekst ispod naslova prikazuje / Check if text under heading is displayed
	public void verifyText() {
		WebElement textElement = wait.until(ExpectedConditions.visibilityOf(checkText));
		String actualText = textElement.getText();
		String expectedText = "simple Login page.";
		Assert.assertTrue(actualText.contains(expectedText));
	}

	// Unos korisničkog imena / Enter username
	public void fieldInputName(String username) {
		wait.until(ExpectedConditions.visibilityOf(inputFieldUserName));
		inputFieldUserName.sendKeys(username);
	}

	// Unos lozinke / Enter password
	public void fieldInputPassword(String password) {
		wait.until(ExpectedConditions.visibilityOf(inputFieldPassword));
		inputFieldPassword.sendKeys(password);
	}

	// Klik na dugme za prijavu / Click submit button
	public void clickButtonSubmit() {
		wait.until(ExpectedConditions.elementToBeClickable(clickButton)).click();
	}

	// Proverava da li je dugme za odjavu prikazano / Check if logout button is present
	public void clickButtonLogOut() {
		if (driver.findElements(By.xpath("//*[@id='loop-container']/div/article/div[2]/div/div/div/a")).size() > 0) {
			System.out.println("Element je pronađen! / Element found!");
		} else {
			System.out.println("Element ne postoji u DOM-u! / Element not present in DOM!");
		}
	}

	// Proverava da li se prikazuje poruka o grešci / Check if error message is displayed
	public void showError() {
		if (driver.findElements(By.xpath("//*[@id='error']")).size() > 0) {
			System.out.println("Element je pronađen! / Element found!");
		} else {
			System.out.println("Element ne postoji u DOM-u! / Element not present in DOM!");
		}
	}

	// Proverava da li je horizontalna linija vidljiva / Check if horizontal line is visible
	public boolean isHorizontalRuleDisplayed() {
		return horizontalRule.isDisplayed();
	}

	// Alternativna metoda za proveru teksta (može se refaktorisati) / Duplicate of verifyText (can be refactored)
	public void verifyText1() {
		WebElement textElement = wait.until(ExpectedConditions.visibilityOf(checkText));
		String actualText = textElement.getText();
		String expectedText = "simple Login page.";
		Assert.assertTrue(actualText.contains(expectedText));
	}

	// Proverava prikaz podnaslova (npr. Test case 1) / Check if H5 header is visible (e.g. test case title)
	public void isHeader5Displayed() {
		WebElement textHeader5 = wait.until(ExpectedConditions.visibilityOf(header5Displayed));
		String actualTextHeader5 = textHeader5.getText();
		String expectedTextHeader5 = "Test case 1: Positive LogIn test";
		Assert.assertEquals(actualTextHeader5, expectedTextHeader5);
	}

	// Proverava da li su prikazane informacije o testu / Check if test info steps are displayed
	public boolean isInformationDisplayed() {
		return informationDisplay.isDisplayed();
	}

	// Klik na kontakt link / Click on contact link
	public void linkContactClick() {
		wait.until(ExpectedConditions.elementToBeClickable(clickContactLink)).click();
	}
}

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

	// Constructor // Konstruktor
	public PageClasses(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Web elements using @FindBy annotation // Web elementi koristeći @FindBy
	// anotaciju
	@FindBy(css = "#site-title > a")
	WebElement clickLink;

	@FindBy(css = "#menu-item-20")
	WebElement clickNavPractice;

	@FindBy(css = "#loop-container > div > article > div.post-content > div:nth-child(2) > div:nth-child(1) > p > a")
	WebElement clickTestLoginPage;

	@FindBy(css = "#login > h2")
	WebElement checkHeading;

	@FindBy(css = "#login > ul > li:nth-child(1)")
	WebElement checkText;

	@FindBy(css = "#username")
	WebElement inputFieldUserName;

	@FindBy(css = "#password")
	WebElement inputFieldPassword;

	@FindBy(css = "#submit")
	WebElement clickButton;

	@FindBy(xpath = "//*[@id=\"loop-container\"]/div/article/div[2]/div/div/div/a")
	WebElement clickButtonLogOut;

	@FindBy(xpath = "//*[@id=\"error\"]")
	WebElement showError;

	@FindBy(xpath = "//*[@id=\"login\"]/hr[1]")
	WebElement horizontalRule;

	@FindBy(css = "#login > h5:nth-child(6)")
	WebElement header5Displayed;

	@FindBy(css = "#login > ol:nth-child(7)")
	WebElement informationDisplay;

	@FindBy(css = "#menu-item-18 > a")
	WebElement clickContactLink;

	// Methods to interact with web elements // Metodi za interakciju sa web
	// elementima
	public void clickLinkLogo() {
		wait.until(ExpectedConditions.elementToBeClickable(clickLink)).click();
	}

	public void clickPracticeNav() {
		wait.until(ExpectedConditions.elementToBeClickable(clickNavPractice)).click();
	}

	public void verifyClickTestLoginPage() {
		wait.until(ExpectedConditions.elementToBeClickable(clickTestLoginPage)).click();
	}

	// Verifies that the login page heading is correct // Proverava da li je naslov
	// stranice za prijavu ispravan
	public void verifyHeading() {
		WebElement headingElement = wait.until(ExpectedConditions.visibilityOf(checkHeading));
		String actualHeading = headingElement.getText();
		String expectedHeading = "Test login";
		Assert.assertEquals(actualHeading, expectedHeading);
	}

	// Checks if the expected login text is displayed // Proverava da li se
	// očekivani tekst za prijavu prikazuje
	public void verifyText() {
		WebElement textElement = wait.until(ExpectedConditions.visibilityOf(checkText));
		String actualText = textElement.getText();
		String expectedText = "simple Login page.";
		Assert.assertTrue(actualText.contains(expectedText));
	}

	// Enters username into the input field // Unosi korisničko ime u polje za unos
	public void fieldInputName(String username) {
		wait.until(ExpectedConditions.visibilityOf(inputFieldUserName));
		inputFieldUserName.sendKeys(username);
	}

	// Enters password into the input field // Unosi lozinku u polje za unos
	public void fieldInputPassword(String password) {
		wait.until(ExpectedConditions.visibilityOf(inputFieldPassword));
		inputFieldPassword.sendKeys(password);
	}

	// Clicks the submit button to log in // Klikne na dugme za prijavu
	public void clickButtonSubmit() {
		wait.until(ExpectedConditions.elementToBeClickable(clickButton)).click();
	}

	// Checks if the logout button is available // Proverava da li je dugme za
	// odjavu dostupno
	public void clickButtonLogOut() {
		if (driver.findElements(By.xpath("//*[@id='loop-container']/div/article/div[2]/div/div/div/a")).size() > 0) {
			System.out.println("Element je pronađen!"); // Element found!
		} else {
			System.out.println("Element ne postoji u DOM-u!"); // Element does not exist in DOM!
		}
	}

	// Checks if the error message is displayed // Proverava da li se prikazuje
	// poruka o grešci
	public void showError() {
		if (driver.findElements(By.xpath("//*[@id='error']")).size() > 0) {
			System.out.println("Element je pronađen!");
		} else {
			System.out.println("Element ne postoji u DOM-u!");
		}
	}

	// Checks if the horizontal rule is visible // Proverava da li je horizontalna
	// linija vidljiva
	public boolean isHorizontalRuleDisplayed() {
		return horizontalRule.isDisplayed();
	}

	// Verifies another login page text // Proverava drugi tekst na stranici za
	// prijavu
	public void verifyText1() {
		WebElement textElement = wait.until(ExpectedConditions.visibilityOf(checkText));
		String actualText = textElement.getText();
		String expectedText = "simple Login page.";
		Assert.assertTrue(actualText.contains(expectedText));
	}

	// Checks if the header is displayed // Proverava da li je zaglavlje prikazano
	public void isHeader5Displayed() {
		WebElement textHeader5 = wait.until(ExpectedConditions.visibilityOf(header5Displayed));
		String actualTextHeader5 = textHeader5.getText();
		String expectedTextHeader5 = "Test case 1: Positive LogIn test";
		Assert.assertEquals(actualTextHeader5, expectedTextHeader5);
	}

	// Checks if informational text is displayed // Proverava da li je informativni
	// tekst prikazan
	public boolean isInformationDisplayed() {
		return informationDisplay.isDisplayed();
	}

	// Clicks the contact link // Klikne na kontakt link
	public void linkContactClick() {
		wait.until(ExpectedConditions.elementToBeClickable(clickContactLink)).click();
	}

}

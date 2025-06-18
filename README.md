# 🧪 PracticeTestAutomation - Contact Form Selenium Automation

## 📄 Description
This project is an automated UI test suite for the **Contact** page on [PracticeTestAutomation](https://practicetestautomation.com/contact/) using:

- Java
- Selenium WebDriver
- TestNG
- Page Object Model (POM) design pattern

It validates presence of page elements, tests form input behavior, handles CAPTCHA, and submits the form.

---

## 🚀 Features

- ✅ Verifies that:
  - Contact page header is displayed
  - Profile image is visible
  - Introductory text is present and can be trimmed
- ✅ Validates:
  - Input fields: name, last name, email, message
  - CAPTCHA checkbox (manual test/mocked)
- ✅ Negative test:
  - Incorrect email format
  - Empty fields
  - Broken selectors
- 🔁 Setup and teardown logic included using `@BeforeTest`, `@AfterTest`, `@BeforeMethod`, `@AfterMethod`

---

## 📁 Project Structure


---

## 🧪 How to Run

1. Open project in your IDE (e.g., IntelliJ, Eclipse)
2. Make sure ChromeDriver is properly configured in your system
3. Run `ContactTest.java` using **TestNG**

You can also run all tests via a test suite XML file if created.

---

## 🛠 Technologies Used

- Java 17+
- Selenium WebDriver
- TestNG
- Page Object Model (POM)
- WebDriverWait / Explicit Wait
- Git (for version control)

---

## ❗Notes

- CAPTCHA interaction is automated **only if allowed** — in real production environments, CAPTCHA is often disabled in test environments or replaced by test keys.
- Tests are written for demo/learning purposes.

---

## 👨‍💻 Author

**Nikola Medan**  
📍 Novi Sad, Serbia  
📧 [nikolamedan1991@gmail.com](mailto:nikolamedan1991@gmail.com)  
🔗 [LinkedIn](https://www.linkedin.com/in/nikola-medan-99a923124)  
🐙 [GitHub Profile](https://github.com/nikolame1991)

---

## 📸 Screenshots (Optional)

You can add screenshots of:

- The contact form page
- Console output
- Successful test execution in TestNG

Use this Markdown syntax:

```markdown
![Test Execution Screenshot](screenshots/test-success.png)

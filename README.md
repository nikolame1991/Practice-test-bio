# 🧪 PracticeTestAutomation - Contact Form Selenium Automation

## 📄 Description
This project is an automated UI test suite for the **Contact** page on [PracticeTestAutomation](https://practicetestautomation.com/contact/) using:

- Java
- Selenium WebDriver
- TestNG
- Page Object Model (POM) design pattern

It validates the presence of page elements, tests form input behavior, handles CAPTCHA, and submits the form.

---

## 🚀 Features

- ✅ Verifies that:
  - Contact page header is displayed
  - Profile image is visible
  - Introductory text is present and can be trimmed

- ✅ Validates:
  - Input fields: name, last name, email, message
  - CAPTCHA checkbox (manual test/mocked)

- ✅ Negative tests:
  - Incorrect email format
  - Empty fields
  - Broken selectors

- 🔁 Setup and teardown logic included using TestNG annotations

---

## 📂 Project Structure

src/
└── main/
└── java/
└── practicetestAutomation/
├── ContactPageClass.java
├── PageClasses.java
├── TestDataContact.java
└── TestDataPracticeTestAutomation.java
└── test/
└── java/
└── practicetestAutomation/
├── ContactTest.java
└── PracticeTest.java



---

## 🧰 Technologies Used

- Java 17+
- Selenium WebDriver
- TestNG
- Page Object Model (POM)
- WebDriverWait / Explicit Wait
- Git (version control)

---

## 🔍 Why Page Object Model?

Page Object Model (POM) helps keep test code clean, reusable, and easier to maintain by separating page structure and test logic.

---

## ❗ CAPTCHA Handling Notes

- CAPTCHA is a challenge for automation because it is designed to prevent bots.
- In real test environments, CAPTCHA is often disabled or replaced with test keys.
- This project includes handling CAPTCHA iframe and checkbox click, but full automation might require manual intervention or mocks.

---

## 🧪 How to Run

1. Open the project in your IDE (e.g., IntelliJ, Eclipse)  
2. Ensure ChromeDriver is properly configured and compatible with your Chrome browser  
3. Run `ContactTest.java` using TestNG  

You can also run all tests via a TestNG XML suite file if created.

---

## 👨‍💻 Author

**Nikola Medan**  
📍 Novi Sad, Serbia  
📧 [nikolamedan1991@gmail.com](mailto:nikolamedan1991@gmail.com)  
🔗 [LinkedIn](https://www.linkedin.com/in/nikola-medan-99a923124)  
🐙 [GitHub Profile](https://github.com/nikolame1991)

---

## 📸 Screenshots (Optional)

Add screenshots of the contact form, test execution, or console output to improve README presentation.

```markdown
![Test Execution Screenshot](screenshots/test-success.png)

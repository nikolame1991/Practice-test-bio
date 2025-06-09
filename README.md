# Practice Test Automation 

## Project Overview 
This project is designed for automated testing using Selenium WebDriver and TestNG. 
It includes various test classes to validate different functionalities of the 
**Practice Test Automation** website. 

## Technologies Used 
- **Java** – Programming language 
- **Selenium WebDriver** 
– Browser automation 
- **TestNG** 
– Test framework 
- **Page Object Model (POM)** – Structured test organization 

## Project Structure 
## Test Cases 
### 1. **Login Functionality** 
- Navigate to the login page 
- Enter valid credentials 
- Verify successful login 
- Validate logout functionality 
### 2. **Contact Page Validation** 
- Verify the presence of header, images, and text 
- Validate input fields (Name, Last Name, Email, Message) 
- Handle CAPTCHA interaction 
- Submit the form and check error messages 
### 3. **UI Elements Verification** 
- Ensure buttons, headers, and form elements are displayed correctly 
- Test navigation between pages 

## Setup Instructions 
### Prerequisites 
1. Install **Java (JDK 11 or later)** 
2. Install **Maven** 
3. Install **Google Chrome** and **ChromeDriver** 
4. Clone the repository: 
```sh 
git clone https://github.com/your-repo/practice-test-automation.git 
5. Navigate to the project directory: 
cd practice-test-automation 

Running the Tests 
Run all tests using Maven: 
mvn test 
Run a specific test class: 
mvn test -Dtest=PageClassTest 
mvn test -Dtest=ContactTest 

⚠️ Known Issues 
CAPTCHA Handling: May fail if CAPTCHA loads differently per session. 

TimeoutExceptions: Occur due to slow page load. 
Dynamic Elements: Require additional wait conditions. 
🤝 Contributing 
Want to improve the project? Feel free to fork the repository and submit pull requests! 🙌 
📜 License 

This project is licensed under the MIT License.

# AI Test Automation Project

## Overview
This project is an automation framework designed for testing a web application. It includes functionalities for user registration, login, and item search through both UI and API testing. The framework utilizes Java, Selenium, MySQL, RestAssured, TestNG, Maven, and Extent Reports for reporting.

## Project Structure
```
ai-test-automation
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── config
│   │   │   │   └── DatabaseConfig.java
│   │   │   ├── pages
│   │   │   │   ├── HomePage.java
│   │   │   │   ├── LoginPage.java
│   │   │   │   └── RegistrationPage.java
│   │   │   └── utils
│   │   │       ├── DatabaseUtils.java
│   │   │       ├── DriverFactory.java
│   │   │       └── RestAssuredUtils.java
│   │   └── resources
│   │       └── log4j2.xml
│   └── test
│       ├── java
│       │   └── tests
│       │       ├── ApiTests.java
│       │       ├── DatabaseTests.java
│       │       ├── TestRunner.java
│       │       └── UiTests.java
│       └── resources
│           └── testng.xml
├── pom.xml
└── README.md
```

## Technologies Used
- **Java**: Programming language used for writing the automation scripts.
- **Selenium**: Framework for automating web applications for testing purposes.
- **MySQL**: Database used for storing registration details and other test data.
- **RestAssured**: Library for testing REST APIs.
- **TestNG**: Testing framework for running the test cases.
- **Maven**: Build automation tool used for managing project dependencies.
- **Extent Reports**: Reporting library for generating test execution reports.

## Setup Instructions
1. **Clone the Repository**
   ```
   git clone <repository-url>
   cd ai-test-automation
   ```

2. **Configure environment variables**
   Set the required environment variables for the web app and database:
   - `APP_BASE_URL` - base URL for the web application (default: `https://automationexercise.com/`)
   - `REST_BASE_URL` - base URL for RestAssured API tests (example: `https://rahulshettyacademy.com`)
   - `API_BASE_URL` - legacy fallback for API tests if `REST_BASE_URL` is not set
   - `BROWSER` - browser to use for UI tests (`chrome` or `firefox`, default: `chrome`)
   - `CHROME_DRIVER_PATH` - path to `chromedriver` if not on PATH
   - `GECKO_DRIVER_PATH` - path to `geckodriver` if not on PATH
   - `MYSQL_HOST`, `MYSQL_PORT`, `MYSQL_USER`, `MYSQL_PASSWORD`, `MYSQL_DATABASE`

   Example ecommerce demo sites:
   - `APP_BASE_URL = "http://automationpractice.com/index.php"`
   - `APP_BASE_URL = "https://automationexercise.com/"`
   Registration pages for those sites:
   - `http://automationpractice.com/index.php?controller=authentication&back=my-account`
   - `https://automationexercise.com/login`

3. **Configure Database**
   Ensure your MySQL database is running and that the configured database exists. The default database connection is built from the environment variables listed above.

4. **Install Dependencies**
   Run the following command to install the required dependencies and compile the project:
   ```
   mvn clean install
   ```

5. **Run Tests**
   Run the full test suite:
   ```
   mvn test
   ```

## Usage
- The project includes test cases for user registration, login, and item search.
- The UI and API tests now execute from `src/test/java/tests` and use TestNG.
- Modify the test classes in `src/test/java/tests` or the page objects in `src/main/java/pages` as needed.

## Reporting
Test execution reports will be generated using Extent Reports. You can find the reports in the specified output directory after running the tests.

## Contribution
Feel free to fork the repository and submit pull requests for any improvements or bug fixes.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.
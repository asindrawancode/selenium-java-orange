# OrangeHRM Automation Project

This project is an automated testing suite for the OrangeHRM application, focusing on the Admin, PIM, and Leave functionalities. It utilizes Selenium WebDriver for browser automation and Cucumber for behavior-driven development (BDD), implemented in Java.

## Project Structure

```
src
│
├── main
│   └── java
│       └── com
│           └── example
│               └── pages
│                   ├── LoginPage.java
│                   ├── AdminPage.java
│                   ├── PIMPage.java
│                   └── LeavePage.java
└── test
    └── java
        └── com
            └── example
                └── stepdefinitions
                    ├── Steps.java
                └── runners
                    └── TestRunner.java
    └── resources
        └── features
            ├── admin.feature
            ├── pim.feature
            └── leave.feature
```

## Requirements

- Java Development Kit (JDK) 8 or above
- Maven
- ChromeDriver (ensure the version matches the installed Chrome version)

## Setup Instructions

1. **Clone the Repository**

   ```bash
   git clone <repository-url>
   cd <repository-directory>
   ```

2. **Install Dependencies**

   Using Maven, install the required dependencies by running:

   ```bash
   mvn clean install
   ```

3. **Configure WebDriver**

   Ensure `ChromeDriver` is available on your system's PATH. Optionally, you can configure it explicitly in your test setup.

## Running the Tests

- To execute the test suite, use the following Maven command which automatically applies the settings defined in `TestRunner.java`:

  ```bash
  mvn test
  ```

- Test reports will be generated in the `target/cucumber-reports` directory.

## Pages Description

- **LoginPage.java**: Contains methods for interacting with the login page of OrangeHRM.
- **AdminPage.java**, **PIMPage.java**, **LeavePage.java**: Include methods designed to interact with specific features on the respective pages.

## Step Definitions

- Each step definition class corresponds to a feature and includes methods that define the actions to be taken during the test scenarios described in the feature files.

## Feature Files

- **login.feature**, **admin.feature**, **pim.feature**, **leave.feature**: These files describe user scenarios using Gherkin syntax and are the basis for generating executable specifications.

## Contributing

- Fork the repository.
- Create your feature branch: `git checkout -b feature/AmazingFeature`
- Commit your changes: `git commit -m 'Add some feature'`
- Push to the branch: `git push origin feature/AmazingFeature`
- Open a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

For any queries regarding the project, please contact [me].

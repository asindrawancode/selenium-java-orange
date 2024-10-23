package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;
import pageObjects.AdminPage;

public class AdminSteps {
    WebDriver driver;
    LoginPage loginPage;
    AdminPage adminPage;

    @Given("I am on the OrangeHRM login page")
    public void i_am_on_the_orangehrm_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @When("I enter valid admin credentials")
    public void i_enter_valid_admin_credentials() {
        loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();
    }

    @And("I navigate to the Admin section")
    public void i_navigate_to_the_admin_section() {
        adminPage = new AdminPage(driver);
        adminPage.navigateToAdmin();
    }

    @Then("I should see the Admin page title")
    public void i_should_see_the_admin_page_title() {
        String title = adminPage.getAdminPageTitle();
        if (title.equals("Admin")) {
            System.out.println("Successfully navigated to Admin page");
        } else {
            System.out.println("Failed to navigate to Admin page");
        }
        driver.quit();
    }
}

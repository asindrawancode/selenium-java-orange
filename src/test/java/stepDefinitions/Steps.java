package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LeavePage;
import pageObjects.LoginPage;
import pageObjects.AdminPage;
import pageObjects.PimPage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Steps {
    static WebDriver driver;
    LoginPage loginPage;
    AdminPage adminPage;
    PimPage pimPage;
    LeavePage leavePage;

    @Given("I am on the OrangeHRM login page")
    public void i_am_on_the_orangehrm_login_page() {
        WebDriverManager.chromedriver().setup();

//        Headless
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless"); // Enables headless mode
//        options.addArguments("--window-size=1920x1080"); // Optional: Ensures full page rendering
//        driver = new ChromeDriver(options);
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

//       Headed
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

    @And("I navigate to the PIM section")
    public void i_navigate_to_the_pim_section() {
        pimPage = new PimPage(driver);
        pimPage.navigateToPim();
    }

    @Then("I should see the PIM page title")
    public void i_should_see_the_pim_page_title() {
        String title = pimPage.getPimPageTitle();
        if (title.equals("PIM")) {
            System.out.println("Successfully navigated to PIM page");
        } else {
            System.out.println("Failed to navigate to PIM page");
        }
        driver.quit();
    }

    @And("I navigate to the Leave section")
    public void i_navigate_to_the_leave_section() {
        leavePage = new LeavePage(driver);
        leavePage.navigateToLeave();
    }


    @And("I apply leave with type {string} start from {string} to {string} with partial days {string}, duration {string}, and comments {string}")
    public void iApplyLeaveWithTypeStartFromToWithPartialDaysDurationAndComments(String leaveType, String fromDate, String toDate, String partialDays, String duration, String comments){
        leavePage = new LeavePage(driver);
        leavePage.applyleave(leaveType, fromDate, toDate, partialDays, duration, comments);
    }

    @Then("I should see the leave record on My Leave")
    public void iShouldSeeTheLeaveRecordOnMyLeave() {
        leavePage = new LeavePage(driver);
        leavePage.validateApplyLeave();
    }

    @Then("I should see the Leave page title")
    public void i_should_see_the_leave_page_title() {
        String title = leavePage.getLeavePageTitle();
        if (title.equals("PIM")) {
            System.out.println("Successfully navigated to Leave page");
        } else {
            System.out.println("Failed to navigate to Leave page");
        }
        driver.quit();
    }

    @After
    public void closeBrowser() {
        takeScreenshot("target/final_screenshot.png");
        if (driver != null) {
            driver.quit();
        }
    }

    public static void takeScreenshot(String fileName) {
        try {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Files.write(Paths.get(fileName), screenshot);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}

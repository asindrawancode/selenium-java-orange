package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class AdminPage {
    WebDriver driver;
    WebDriverWait wait;

    By adminTab = By.xpath("//span[normalize-space()='Admin']");
    By adminPageTitle = By.className("oxd-topbar-header-breadcrumb-level");

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToAdmin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminTab));
        driver.findElement(adminTab).click();
    }

    public String getAdminPageTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminPageTitle));
        return driver.findElement(adminPageTitle).getText();
    }
}

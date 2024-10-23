package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {
    WebDriver driver;

    By adminTab = By.xpath("//span[text()='Admin']");
    By adminPageTitle = By.className("oxd-topbar-header-breadcrumb-level");

    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToAdmin() {
        driver.findElement(adminTab).click();
    }

    public String getAdminPageTitle() {
        return driver.findElement(adminPageTitle).getText();
    }
}

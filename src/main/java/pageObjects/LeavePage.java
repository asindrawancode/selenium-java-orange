package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LeavePage {
    WebDriver driver;
    WebDriverWait wait;

    By leaveTab = By.xpath("//span[normalize-space()='PIM']");
    By leavePageTitle = By.xpath("//h6[text()='PIM']");

    public LeavePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToLeave() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(leaveTab));
        driver.findElement(leaveTab).click();
    }

    public String getLeavePageTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(leavePageTitle));
        return driver.findElement(leavePageTitle).getText();
    }
}

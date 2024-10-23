package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class PimPage {
    WebDriver driver;
    WebDriverWait wait;

    By pimTab = By.xpath("//span[normalize-space()='PIM']");
    By pimPageTitle = By.xpath("//h6[text()='PIM']");

    public PimPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToPim() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pimTab));
        driver.findElement(pimTab).click();
    }

    public String getPimPageTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pimPageTitle));
        return driver.findElement(pimPageTitle).getText();
    }
}

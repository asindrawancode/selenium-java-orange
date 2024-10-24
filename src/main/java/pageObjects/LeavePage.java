package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LeavePage {
    WebDriver driver;
    WebDriverWait wait;

    By leaveTab = By.xpath("//span[normalize-space()='Leave']");
    By leavePageTitle = By.xpath("//h6[text()='Leave']");
    By applyTab = By.xpath("//a[contains(@class,'topbar') and text()='Apply']");

    By leaveTypeElement = By.xpath("(//i[contains(@class,'arrow')])[1]");
    By leaveValue;

    By startCal = By.xpath("(//input[@placeholder=\"yyyy-dd-mm\"])[1]");

    By endCalElement = By.xpath("(//i[contains(@class,'calendar')])[2]");
    By endCalClear = By.xpath("//*[text()='Clear']");
    By endCal = By.xpath("(//input[@placeholder=\"yyyy-dd-mm\"])[2]");

    By partialDaysElement = By.xpath("(//i[contains(@class,'arrow')])[2]");
    By partialDaysValue;

    By durationsElement = By.xpath("(//i[contains(@class,'arrow')])[3]");
    By durationsValue;

    By textArea = By.xpath("//textarea");
    By btnSubmit = By.xpath("//button[@type='submit']");
    By msgSuccess = By.xpath("//*[text()='Successfully Saved']");
    By msgUpdated = By.xpath("//*[text()='Successfully Updated']");



    By tabMyLeave = By.xpath("//*[text()='My Leave']");
    By recordLeave = By.xpath("//div[text()='Apply Leave All Days']/parent::div/following-sibling::div//*[text()=' Cancel ']");


    // Delete this
    By test = By.xpath("//asd");



    public LeavePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToLeave() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(leaveTab));
        driver.findElement(leaveTab).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(applyTab));
        driver.findElement(applyTab).click();
    }

    public String getLeavePageTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(leavePageTitle));
        return driver.findElement(leavePageTitle).getText();
    }

    public void applyleave(String leaveType, String fromDate, String toDate, String partialDays, String duration, String comments){
        wait.until(ExpectedConditions.visibilityOfElementLocated(leaveTypeElement));
        driver.findElement(leaveTypeElement).click();
        leaveValue = By.xpath("//*[text()='" + leaveType + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(leaveValue));
        driver.findElement(leaveValue).click();
        driver.findElement(startCal).sendKeys(fromDate);
        driver.findElement(endCalElement).click();
        driver.findElement(endCalClear).click();
        driver.findElement(endCal).sendKeys(toDate);

        wait.until(ExpectedConditions.visibilityOfElementLocated(textArea));
        driver.findElement(textArea).sendKeys(comments);

        wait.until(ExpectedConditions.visibilityOfElementLocated(partialDaysElement));
        driver.findElement(partialDaysElement).click();

        partialDaysValue = By.xpath("//*[text()='" + partialDays + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(partialDaysValue));
        driver.findElement(partialDaysValue).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(durationsElement));
        driver.findElement(durationsElement).click();

        durationsValue = By.xpath("//*[text()='" + duration + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(durationsValue));
        driver.findElement(durationsValue).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(btnSubmit));
        driver.findElement(btnSubmit).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(msgSuccess));
    }

    public void validateApplyLeave(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(tabMyLeave));
        driver.findElement(tabMyLeave).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(recordLeave));
        driver.findElement(recordLeave).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(msgUpdated));

    }
}

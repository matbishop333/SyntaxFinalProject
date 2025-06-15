package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonMethods extends PageInitializer {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public void openBrowser() {
        String browserName = ConfigReader.get("browser");
        switch (browserName) {
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Invalid Browser Name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(ConfigReader.get("url"));

    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sendText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).clear();
        element.sendKeys(text);
    }

    public String getText(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public void waitForElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementClickable(WebElement element) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public void selectDropdownByVisibleText(WebElement element, String text) {
        new Select(element).selectByVisibleText(text);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }


}

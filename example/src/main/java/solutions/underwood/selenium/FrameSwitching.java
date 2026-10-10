package solutions.underwood.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FrameSwitching {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.selenium.dev/selenium/web/alerts.html");
            DemoSupport.waitFor(driver).until(
                ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                    "iframeWithAlert"
                )
            );
            DemoSupport.waitFor(driver)
                .until(
                    ExpectedConditions.elementToBeClickable(
                        By.id("alertInFrame")
                    )
                )
                .click();
            DemoSupport.waitFor(driver)
                .until(ExpectedConditions.alertIsPresent())
                .accept();
            driver.switchTo().defaultContent();
            DemoSupport.verify(
                driver.findElement(By.id("prompt")).isDisplayed(),
                "Returned from the iframe to the main page"
            );
        } finally {
            driver.quit();
        }
    }
}

package solutions.underwood.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ExplicitWaits {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            // Use explicit waits without mixing in an implicit wait.
            driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
            driver.findElement(By.id("reveal")).click();
            WebElement input = DemoSupport.waitFor(driver).until(
                ExpectedConditions.elementToBeClickable(By.id("revealed"))
            );
            input.sendKeys("Ready after waiting");
            DemoSupport.verify(
                "Ready after waiting".equals(input.getDomProperty("value")),
                "Entered text in the delayed input"
            );
        } finally {
            driver.quit();
        }
    }
}

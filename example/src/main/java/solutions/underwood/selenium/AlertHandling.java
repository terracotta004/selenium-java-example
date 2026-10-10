package solutions.underwood.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertHandling {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.selenium.dev/selenium/web/alerts.html");
            driver.findElement(By.id("alert")).click();
            Alert alert = DemoSupport.waitFor(driver).until(
                ExpectedConditions.alertIsPresent()
            );
            DemoSupport.verify(
                "cheese".equals(alert.getText()),
                "Read the alert message"
            );
            alert.accept();
            driver.findElement(By.id("prompt")).click();
            Alert prompt = DemoSupport.waitFor(driver).until(
                ExpectedConditions.alertIsPresent()
            );
            prompt.sendKeys("Selenium");
            prompt.accept();
            DemoSupport.waitFor(driver).until(
                ExpectedConditions.textToBe(By.id("text"), "Selenium")
            );
            driver.findElement(By.id("confirm")).click();
            DemoSupport.waitFor(driver)
                .until(ExpectedConditions.alertIsPresent())
                .dismiss();
            DemoSupport.verify(
                driver.getCurrentUrl().contains("alerts.html"),
                "Dismissed confirmation and stayed on the page"
            );
        } finally {
            driver.quit();
        }
    }
}

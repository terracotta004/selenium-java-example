package solutions.underwood.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FormControls {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get(DemoSupport.FORM_URL);
            driver.findElement(By.name("my-text")).sendKeys("Selenium");
            driver
                .findElement(By.name("my-password"))
                .sendKeys("demo-password");
            driver
                .findElement(By.name("my-textarea"))
                .sendKeys("Learning form automation");
            WebElement checkbox = driver.findElement(By.id("my-check-2"));
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
            driver.findElement(By.id("my-radio-2")).click();
            DemoSupport.verify(checkbox.isSelected(), "Checkbox is selected");
            DemoSupport.verify(
                driver.findElement(By.id("my-radio-2")).isSelected(),
                "Radio button is selected"
            );
            DemoSupport.verify(
                "Selenium".equals(
                    driver
                        .findElement(By.name("my-text"))
                        .getDomProperty("value")
                ),
                "Text field contains Selenium"
            );
            driver.findElement(By.cssSelector("button[type='submit']")).click();
            DemoSupport.waitFor(driver).until(
                ExpectedConditions.textToBe(By.id("message"), "Received!")
            );
            System.out.println("Form submitted successfully");
        } finally {
            driver.quit();
        }
    }
}

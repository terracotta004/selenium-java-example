package solutions.underwood.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsCss {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get(DemoSupport.FORM_URL);
            WebElement input = driver.findElement(
                By.cssSelector("input[name='my-text']")
            );
            input.sendKeys("Selenium CSS locator");
            DemoSupport.verify(
                "Selenium CSS locator".equals(
                    driver
                        .findElement(By.name("my-text"))
                        .getDomProperty("value")
                ),
                "CSS and name locators find the same populated field"
            );
        } finally {
            driver.quit();
        }
    }
}

package solutions.underwood;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsName {

    public static void main(String[] args) {
        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            // Open the practice form.
            driver.get(
                "https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php"
            );

            // Locate the name field and enter text.
            WebElement nameInput = driver.findElement(By.name("name"));
            nameInput.clear();
            nameInput.sendKeys("Selenium");

            // Get the value entered
            String text = nameInput.getDomProperty("value");
            System.out.println("Entered text is: " + text);
        } finally {
            driver.quit();
        }
    }
}

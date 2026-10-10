package solutions.underwood.selenium;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {

    public static void main(String[] args) {
        // Initiate the Webdriver
        WebDriver driver = new ChromeDriver();

        try {
            // adding implicit wait of 12 secs
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));

            // URL launch
            driver.get(
                "https://www.tutorialspoint.com/selenium/practice/resizable.php"
            );

            // get browser title after browser launch
            System.out.println("Browser title: " + driver.getTitle());
        } finally {
            driver.quit();
        }
    }
}

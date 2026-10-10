package solutions.underwood;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseBrowser {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
            driver.get(
                "https://www.tutorialspoint.com/selenium/practice/droppable.php"
            );
            System.out.println("Browser title obtained: " + driver.getTitle());
        } finally {
            driver.quit();
        }
    }
}

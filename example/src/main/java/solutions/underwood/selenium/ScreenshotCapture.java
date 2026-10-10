package solutions.underwood.selenium;

import java.nio.file.Files;
import java.nio.file.Path;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotCapture {

    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get(DemoSupport.FORM_URL);
            Path directory = Path.of("target", "screenshots");
            Files.createDirectories(directory);
            Path screenshot = Files.createTempFile(
                directory,
                "web-form-",
                ".png"
            );
            Files.write(
                screenshot,
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)
            );
            DemoSupport.verify(
                Files.size(screenshot) > 0,
                "Screenshot saved to " + screenshot.toAbsolutePath()
            );
        } finally {
            driver.quit();
        }
    }
}

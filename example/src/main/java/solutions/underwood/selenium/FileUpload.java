package solutions.underwood.selenium;

import java.nio.file.Files;
import java.nio.file.Path;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

    public static void main(String[] args) throws Exception {
        Path directory = Path.of("target", "uploads");
        Files.createDirectories(directory);
        Path sample = Files.createTempFile(
            directory,
            "selenium-upload-",
            ".txt"
        ).toAbsolutePath();
        Files.writeString(
            sample,
            "Sample file for Selenium upload demonstration."
        );
        try {
            WebDriver driver = new ChromeDriver();
            try {
                driver.get(DemoSupport.FORM_URL);
                WebElement input = driver.findElement(By.name("my-file"));
                // Send the absolute path directly; no native file dialog is needed.
                input.sendKeys(sample.toString());
                DemoSupport.verify(
                    input
                        .getDomProperty("value")
                        .endsWith(sample.getFileName().toString()),
                    "File selected: " + sample.getFileName()
                );
                System.out.println(
                    "This demo selects a file; the practice page does not store uploads."
                );
            } finally {
                driver.quit();
            }
        } finally {
            Files.deleteIfExists(sample);
        }
    }
}

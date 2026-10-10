package solutions.underwood.selenium;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

final class DemoSupport {

    static final String FORM_URL =
        "https://www.selenium.dev/selenium/web/web-form.html";

    private DemoSupport() {}

    static WebDriverWait waitFor(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    static void verify(boolean condition, String message) {
        if (!condition) {
            throw new IllegalStateException(message);
        }
        System.out.println("Verified: " + message);
    }
}

package solutions.underwood.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowSwitching {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get(DemoSupport.FORM_URL);
            String originalWindow = driver.getWindowHandle();
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
            DemoSupport.verify(
                driver.getWindowHandles().size() == 2,
                "Two tabs are open"
            );
            driver.close(); // Close only the current tab.
            driver.switchTo().window(originalWindow);
            DemoSupport.verify(
                "Web form".equals(driver.getTitle()),
                "Returned to the original tab"
            );
        } finally {
            driver.quit(); // End the whole session.
        }
    }
}

package solutions.underwood.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MouseActions {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get(
                "https://www.selenium.dev/selenium/web/mouse_interaction.html"
            );
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.id("hover"))).perform();
            DemoSupport.waitFor(driver).until(
                ExpectedConditions.textToBe(By.id("move-status"), "hovered")
            );
            actions
                .doubleClick(driver.findElement(By.id("clickable")))
                .perform();
            DemoSupport.waitFor(driver).until(
                ExpectedConditions.textToBe(
                    By.id("click-status"),
                    "double-clicked"
                )
            );
            actions
                .contextClick(driver.findElement(By.id("clickable")))
                .perform();
            DemoSupport.waitFor(driver).until(
                ExpectedConditions.textToBe(
                    By.id("click-status"),
                    "context-clicked"
                )
            );
            // Reload to dismiss the browser context menu before dragging.
            driver.navigate().refresh();
            actions
                .dragAndDrop(
                    driver.findElement(By.id("draggable")),
                    driver.findElement(By.id("droppable"))
                )
                .perform();
            DemoSupport.waitFor(driver).until(
                ExpectedConditions.textToBe(By.id("drop-status"), "dropped")
            );
            System.out.println(
                "Verified hover, double-click, right-click, and drag-and-drop"
            );
        } finally {
            driver.quit();
        }
    }
}

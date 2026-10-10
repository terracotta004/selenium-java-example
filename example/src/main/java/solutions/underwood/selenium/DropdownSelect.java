package solutions.underwood.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownSelect {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get(DemoSupport.FORM_URL);
            Select dropdown = new Select(
                driver.findElement(By.name("my-select"))
            );
            dropdown.selectByVisibleText("Two");
            DemoSupport.verify(
                "2".equals(
                    dropdown.getFirstSelectedOption().getDomAttribute("value")
                ),
                "Selected Two by visible text"
            );
            dropdown.selectByValue("3");
            DemoSupport.verify(
                "Three".equals(dropdown.getFirstSelectedOption().getText()),
                "Selected Three by value"
            );
            dropdown.selectByIndex(1);
            DemoSupport.verify(
                "One".equals(dropdown.getFirstSelectedOption().getText()),
                "Selected One by index"
            );
        } finally {
            driver.quit();
        }
    }
}

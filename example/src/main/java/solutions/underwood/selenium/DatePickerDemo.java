package solutions.underwood.selenium;

import java.time.Duration;
import java.time.LocalDate;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePickerDemo {

    public static void main(String[] args) {
        // Optionally pass a date such as 2027-02-15 as the first argument.
        LocalDate targetDate =
            args.length > 0
                ? LocalDate.parse(args[0])
                : LocalDate.now().plusMonths(1).withDayOfMonth(15);
        WebDriver driver = new ChromeDriver();

        try {
            WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
            );
            driver.get(
                "https://www.tutorialspoint.com/selenium/practice/date-picker.php"
            );

            WebElement dateInput = wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.id("datetimepicker1")
                )
            );
            dateInput.click();
            wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector(".flatpickr-calendar.open")
                )
            );

            // Navigate using the calendar's year field and month dropdown.
            By yearLocator = By.cssSelector(
                ".flatpickr-calendar.open .cur-year"
            );
            WebElement yearInput = wait.until(
                ExpectedConditions.elementToBeClickable(yearLocator)
            );
            yearInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            yearInput.sendKeys(
                Integer.toString(targetDate.getYear()),
                Keys.ENTER
            );
            wait.until(d ->
                Integer.toString(targetDate.getYear()).equals(
                    d.findElement(yearLocator).getDomProperty("value")
                )
            );

            By monthLocator = By.cssSelector(
                ".flatpickr-calendar.open .flatpickr-monthDropdown-months"
            );
            new Select(driver.findElement(monthLocator)).selectByValue(
                Integer.toString(targetDate.getMonthValue() - 1)
            );

            // Exclude days from adjacent months and disabled dates.
            By dayLocator = By.xpath(
                "//div[contains(@class, 'flatpickr-calendar') and contains(@class, 'open')]" +
                    "//span[contains(@class, 'flatpickr-day')" +
                    " and not(contains(@class, 'prevMonthDay'))" +
                    " and not(contains(@class, 'nextMonthDay'))" +
                    " and not(contains(@class, 'flatpickr-disabled'))" +
                    " and normalize-space()='" +
                    targetDate.getDayOfMonth() +
                    "']"
            );
            wait.until(
                ExpectedConditions.elementToBeClickable(dayLocator)
            ).click();

            // This page includes a time; verify the date portion of its value.
            wait.until(d -> {
                String value = d
                    .findElement(By.id("datetimepicker1"))
                    .getDomProperty("value");
                return value != null && value.startsWith(targetDate + " ");
            });
            System.out.println(
                "Selected date and time: " + dateInput.getDomProperty("value")
            );
        } finally {
            driver.quit();
        }
    }
}

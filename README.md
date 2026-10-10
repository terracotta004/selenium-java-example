# Selenium Java examples

Open this folder in VS Code with the recommended Java extensions installed.
Choose a **Run Selenium App** configuration under **Run and Debug**, then press
**F5**. Each demo opens Chrome and closes its session when finished.

Requires a JDK supporting Java 16, Maven, Chrome, and internet access. Selenium
Manager resolves ChromeDriver automatically.

## Demonstrations

All classes use the package `solutions.underwood.selenium`.

| Class               | Demonstration                                             |
| ------------------- | --------------------------------------------------------- |
| `App`               | Open a page and print its title                           |
| `CloseBrowser`      | Close a browser window                                    |
| `LocatorsName`      | Locate and fill a name field                              |
| `LocatorsCss`       | Locate a field with CSS and compare with a name locator   |
| `FormControls`      | Fill and submit a form; verify checkbox and radio state   |
| `DropdownSelect`    | Select options by visible text, value, and index          |
| `ExplicitWaits`     | Wait for a delayed input without fixed sleeps             |
| `MouseActions`      | Hover, double-click, right-click, and drag-and-drop       |
| `AlertHandling`     | Read an alert, fill a prompt, and dismiss confirmation    |
| `FrameSwitching`    | Interact inside an iframe and return to the main document |
| `WindowSwitching`   | Open a tab, close it, and return to the original tab      |
| `ScreenshotCapture` | Save a PNG under `example/target/screenshots`             |
| `FileUpload`        | Select a temporary text file through a file input         |
| `DatePickerDemo`    | Select and verify a date using a calendar widget          |

The newer interaction demos use Selenium's public practice pages. `FileUpload`
verifies file selection; it does not upload to a storage service. Its temporary
file is deleted afterward. `DatePickerDemo` uses TutorialsPoint's calendar and
defaults to the 15th of next month; it also accepts an ISO date as its first argument.

## Run from PowerShell

From the repository root:

```powershell
cd example
mvn compile org.codehaus.mojo:exec-maven-plugin:3.5.0:java "-Dexec.mainClass=solutions.underwood.selenium.FormControls"
```

Replace `FormControls` with any demo class above. Public practice sites require
internet access and their markup may change. A failed verification throws an
exception instead of printing a success message.

## Checks and formatting

Run `mvn test` from `example` to compile the demos and run the existing unit test.
That unit test does not exercise browser interactions; run demos individually to
check those.

From the repository root, run `npm ci` to install the formatting tools, then:

```powershell
npm run format
npm run format:check
```

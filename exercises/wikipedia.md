# Random Wikipedia walker

Using Selenium, create a small program that, starting from the main page https://www.wikipedia.org/, walks trough a sequence of random links and takes a snapshot of the last page.
The process is as follows:

 1. Navigate to the main page https://www.wikipedia.org/
 2. Select a random link in the page
 3. Navigate to the link
 4. Repeat steps 2 to 3 until you have visited 10 different pages
 5. Take a snapshot of the current page and save it

Include the code of the walker and the snapshot in this document.

## Answer

```java
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WikipediaTest {
public static void main(String[] args) throws IOException {
// Set up the web driver
System.setProperty("webdriver.chrome.driver", "/home/marion/Documents/VV/chromedriver_linux64/chromedriver");

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(ops);
        Random random = new Random();

        // Navigate to the main page
        driver.get("https://www.wikipedia.org/");

        // Select a random link and navigate to it
        for (int i = 0; i < 10; i++) {
            List<WebElement> links = driver.findElements(By.tagName("a"));
            boolean found = false;
            do {
                int randomIndex = random.nextInt(links.size());
                try {
                    WebElement randomLink = links.get(randomIndex);
                    randomLink.click();
                    found = true;
                } catch (Exception e) {
                    links.remove(randomIndex);
                }
            } while (!found);
            // Wait for the page to load
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        }

        // Take a screenshot of the current page
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String filename = "screenshot.png";
        FileUtils.copyFile(screenshot, new File(filename));

        // Close the driver
        driver.quit();
    }
}
```

Voici le screenshot obtenu après avoir cliqué sur 10 liens :

![screenshot](screenshot.png)

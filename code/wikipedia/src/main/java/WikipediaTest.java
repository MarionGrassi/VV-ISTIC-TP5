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
import org.openqa.selenium.firefox.FirefoxDriver;

public class WikipediaTest {
    public static void main(String[] args) throws IOException {
        /*
        // Set up the web driver
        System.setProperty("webdriver.chrome.driver", "/home/marion/Documents/VV/chromedriver_linux64/chromedriver");

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(ops);

         */

        WebDriver driver = new FirefoxDriver();

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
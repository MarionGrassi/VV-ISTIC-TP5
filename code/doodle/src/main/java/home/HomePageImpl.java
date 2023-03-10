package home;

import create.CreatePage;
import create.CreatePageImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageImpl implements HomePage {
    private WebDriver driver;

    public HomePageImpl(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public CreatePage createPoll() {
        driver.findElement(By.className("Home_CreateLink")).click();
        CreatePageImpl createPage = new CreatePageImpl(driver);
        createPage.waitUntilAvailble();
        return createPage;
    }

    @Override
    public boolean waitUntilAvailble() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("Home_CreateLink")));
        return true;
    }
}

package home;

import create.CreatePage;
import create.CreatePageImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageImpl implements HomePage {
    private WebDriver driver;

    public HomePageImpl(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public CreatePage createPoll() {
        driver.findElement(By.className("Home_CreateLink")).click();
        return new CreatePageImpl(driver);
    }
}

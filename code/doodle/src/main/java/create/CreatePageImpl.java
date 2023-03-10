package create;

import dateChoice.DateChoicePage;
import dateChoice.DateChoicePageImpl;
import home.HomePage;
import home.HomePageImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreatePageImpl implements CreatePage{
    WebDriver driver;
    public CreatePageImpl(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public String getTitreReunion() {
        return driver.findElement(By.id("titre")).getText();
    }

    @Override
    public CreatePage typeTitreReunion(String titre) {
        driver.findElement(By.id("titre")).sendKeys(titre);
        return this;
    }

    @Override
    public String getLieuReunion() {
        return driver.findElement(By.id("lieu")).getText();
    }

    @Override
    public CreatePage typeLieuReunion(String lieu) {
        driver.findElement(By.id("lieu")).sendKeys(lieu);
        return this;
    }

    @Override
    public String getDescriptionReunion() {
        return driver.findElement(By.id("desc")).getText();
    }

    @Override
    public CreatePage typeDescriptionReunion(String description) {
        driver.findElement(By.id("desc")).sendKeys(description);
        return this;
    }

    @Override
    public boolean hasRepas() {
        return driver.findElement(By.tagName("p-inputswitch")).getAttribute("ng-reflect-model").equals("true");
    }

    @Override
    public CreatePage setRepas(boolean isRepas) {
        driver.findElement(By.tagName("p-inputswitch")).click();
        return this;
    }

    @Override
    public HomePage back() {
        driver.findElement(By.xpath("//*[text()='Back']")).click();
        HomePageImpl homePage = new HomePageImpl(driver);
        homePage.waitUntilAvailble();
        return homePage;
    }

    @Override
    public DateChoicePage next() {
        driver.findElement(By.xpath("//*[text()='Next']")).click();
        DateChoicePageImpl dateChoicePage = new DateChoicePageImpl(driver);
        dateChoicePage.waitUntilAvailble();
        return dateChoicePage;
    }

    @Override
    public boolean waitUntilAvailble() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("titre")));
        return true;
    }
}

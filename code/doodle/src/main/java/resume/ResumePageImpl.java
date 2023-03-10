package resume;

import dateChoice.DateChoicePage;
import dateChoice.DateChoicePageImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResumePageImpl implements ResumePage {
    WebDriver driver;

    public ResumePageImpl(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public String toParticipationPage() {
        String href = driver.findElement(By.xpath("//div/div[1]/a[1]")).getAttribute("href");
        return href;
    }

    @Override
    public String toAdminPage() {
        String href = driver.findElement(By.xpath("//div/div[1]/a[2]")).getAttribute("href");
        return href;
    }

    @Override
    public DateChoicePage back() {
        driver.findElement(By.xpath("//*[text()='Back']")).click();
        DateChoicePageImpl dateChoicePage = new DateChoicePageImpl(driver);
        dateChoicePage.waitUntilAvailble();
        return dateChoicePage;
    }

    @Override
    public boolean waitUntilAvailble() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div[1]/a[1]")));
        return true;
    }
}

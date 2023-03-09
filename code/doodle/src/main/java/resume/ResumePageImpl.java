package resume;

import admin.AdminPage;
import admin.AdminPageImpl;
import dateChoice.DateChoicePage;
import dateChoice.DateChoicePageImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import participation.ParticipationPage;
import participation.ParticipationPageImpl;

public class ResumePageImpl implements ResumePage {
    WebDriver driver;

    public ResumePageImpl(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public ParticipationPage toParticipationPage() {
        driver.findElement(By.xpath("//div/div[1]/a[1]")).click();
        return new ParticipationPageImpl(driver);
    }

    @Override
    public AdminPage toAdminPage() {
        driver.findElement(By.xpath("//div/div[1]/a[2]")).click();
        return new AdminPageImpl(driver);
    }

    @Override
    public DateChoicePage back() {
        driver.findElement(By.xpath("//*[text()='Back']")).click();
        return new DateChoicePageImpl(driver);
    }
}

package dateChoice;

import create.CreatePage;
import create.CreatePageImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import resume.ResumePage;
import resume.ResumePageImpl;

public class DateChoicePageImpl implements DateChoicePage{
    WebDriver driver;

    public DateChoicePageImpl(WebDriver driver) {
        this.driver = driver;
    }


    @Override
    public boolean hasAgenda() {
        return driver.findElement(By.tagName("ng-reflect-model")).getAttribute("ng-reflect-model").equals("true");
    }

    @Override
    public DateChoicePage setHasAgenda(boolean value) {
        driver.findElement(By.tagName("ng-reflect-model")).click();
        return this;
    }

    @Override
    public String getAgenda() {
        return driver.findElement(By.id("ics")).getText();
    }

    @Override
    public DateChoicePage typeAgenda(String url) {
        driver.findElement(By.id("ics")).sendKeys(url);
        return this;
    }

    @Override
    public DateChoicePage addCreneau(Point point) {
        Actions actions = new Actions(driver);
        actions.moveByOffset(point.getX(), point.getY()).click();
        return this;
    }

    @Override
    public CreatePage back() {
        driver.findElement(By.xpath("//*[text()='Back']")).click();
        return new CreatePageImpl(driver);
    }

    @Override
    public ResumePage next() {
        driver.findElement(By.xpath("//*[text()='Next']")).click();
        return new ResumePageImpl(driver);
    }
}

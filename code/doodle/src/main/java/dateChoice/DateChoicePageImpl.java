package dateChoice;

import create.CreatePage;
import create.CreatePageImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import resume.ResumePage;
import resume.ResumePageImpl;

import java.time.LocalDateTime;

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
    public DateChoicePage addCreneau(String time) {

        // Get the row for 11:00:00
        WebElement time_row = driver.findElement(new By.ByCssSelector("tr[data-time=\"" + time + "\"]"));
        Actions action = new Actions(driver);

        // Select the day by moving a fraction of the width of the <tr>
        // In this case, I am moving to Wed on the 7-day agendaWeek view.
        action.moveToElement(time_row, time_row.getRect().getWidth()/2, time_row.getRect().getHeight()/2);
        action.click();
        action.perform();
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

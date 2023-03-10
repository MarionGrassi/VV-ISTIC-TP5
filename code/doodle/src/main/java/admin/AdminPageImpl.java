package admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminPageImpl implements AdminPage {
    WebDriver driver;

    public AdminPageImpl(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public Map<String, String> getComments() {
        WebElement list = driver.findElement(By.xpath("//app-show-comments/div/div/ul"));
        List<WebElement> elements = list.findElements(By.tagName("li"));
        Map<String, String> comments = new HashMap<>();
        for (WebElement element : elements) {
            String author = element.findElement(By.className("Author_Comment")).getText();
            String content = element.findElement(By.xpath("//span[2]")).getText();
            comments.put(author, content);
        }
        return comments;
    }

    @Override
    public int getNombreParticipantsPourCreaneau(int creneau) {
        return Integer.parseInt(driver.findElement(By.xpath("//table/thead/tr[3]/th["+ (2 + creneau) +"]")).getText());
    }

    @Override
    public AdminPage validateCreneau(int creneau) {
        driver.findElement(By.xpath("//table/tbody/tr/td["+ (2 + creneau) +"]/p-button/button")).click();
        return this;
    }

    @Override
    public int getNombreCreneaux() {
        return driver.findElements(By.xpath("//table/thead/tr[2]/th")).size();
    }

    @Override
    public String getDateCreaneau(int creneau) {
        String jour = driver.findElement(By.xpath("//table/thead/tr[1]/th["+ (2 + creneau) +"]")).getText();
        String heure = driver.findElement(By.xpath("//table/thead/tr[2]/th["+ (2 + creneau) +"]")).getText();
        return jour + " : " + heure;
    }

    @Override
    public boolean waitUntilAvailble() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/thead/tr[2]/th")));
        return true;
    }

    public List<WebElement> errors() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("pi-exclamation-triangle")));
        return driver.findElements(By.className("pi-exclamation-triangle"));
    }
}

package participation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParticipationPageImpl implements ParticipationPage {

    private WebDriver driver;

    public ParticipationPageImpl(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public String getParticipantName() {
        return driver.findElement(By.id("nom")).getText();
    }

    @Override
    public ParticipationPage typeParticipantName(String participant) {
        driver.findElement(By.id("nom")).sendKeys(participant);
        return this;
    }

    @Override
    public String getParticipantMail() {
        return driver.findElement(By.id("mail")).getText();
    }

    @Override
    public ParticipationPage typeParticipantMail(String mail) {
        driver.findElement(By.id("mail")).sendKeys(mail);
        return this;
    }

    @Override
    public boolean hasAgenda() {
        return driver.findElement(By.tagName("ng-reflect-model")).getAttribute("ng-reflect-model").equals("true");
    }

    @Override
    public ParticipationPage setHasAgenda(boolean value) {
        driver.findElement(By.tagName("ng-reflect-model")).click();
        return this;
    }

    @Override
    public String getAgenda() {
        return driver.findElement(By.id("ics")).getText();
    }

    @Override
    public ParticipationPage typeAgenda(String url) {
        driver.findElement(By.id("ics")).sendKeys(url);
        return this;
    }

    @Override
    public boolean hasFoodPreferences() {
        return false; // TODO
    }

    @Override
    public ParticipationPage setHasFoodPreferences(boolean value) {
        return null; // TODO
    }

    @Override
    public String getFoodPreferences() {
        return null; // TODO
    }

    @Override
    public ParticipationPage typeFoodPreferences(String foodPreferences) {
        return null; // TODO
    }

    @Override
    public boolean isCalendarViewOrTableView() {
        return driver.findElement(By.tagName("full-calendar")) != null;
    }

    @Override
    public ParticipationPage setCalendarOrTableView(boolean calendarView) {
        if (calendarView) {
            driver.findElement(By.xpath("//p-selectbutton/div/div[1]/i)")).click();
        } else {
            driver.findElement(By.xpath("//p-selectbutton/div/div[2]/i)")).click();
        }
        return this;
    }

    @Override
    public Map<String, Map<Integer, Boolean>> getDisponibilities() {
        Map<String , Map<Integer,Boolean>> map = new HashMap<>();

        WebElement corpsTableau = driver.findElement(By.xpath("//table/tbody"));
        List<WebElement> rows = corpsTableau.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            String nom = row.getText();
            List<WebElement> checkBox = row.findElements(By.tagName("p-checkbox"));
            for (WebElement box : checkBox) {
                boolean isChecked = box.getAttribute("ng-reflect-model").equals("true");
                if(map.containsKey(nom)){
                    map.get(nom).put(checkBox.indexOf(box), isChecked);
                } else {
                    HashMap<Integer, Boolean> hashMap = new HashMap<>();
                    hashMap.put(checkBox.indexOf(box), isChecked);
                    map.put(nom, hashMap);
                }
            }
        }
        return map;
    }

    @Override
    public ParticipationPage setDisponibility(int creneau, String participant, boolean available) {
        WebElement corpsTableau = driver.findElement(By.xpath("//table/tbody"));
        List<WebElement> rows = corpsTableau.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            String nom = row.getText();
            if (participant.equals(nom)) {
                List<WebElement> checkBox = row.findElements(By.tagName("p-checkbox"));
                WebElement box = checkBox.get(creneau);
                if(box.getAttribute("ng-reflect-model").equals("true") != available) {
                    box.click();
                }
                return this;
            }
        }
        return this;
    }

    @Override
    public ParticipationPage submit() {
        driver.findElement(By.xpath("//*[text() = 'Soumettre voeux']")).click();
        return this;
    }

    @Override
    public ParticipationPage submitExpectingErrors() {
        driver.findElement(By.xpath("//*[text() = 'Soumettre voeux']")).click(); // TODO verifier resultat
        return this;
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
    public String getCommentAuthor() {
        return driver.findElement(By.id("comment")).getText();
    }

    @Override
    public ParticipationPage typeCommentAuthor(String author) {
        driver.findElement(By.id("comment")).sendKeys(author);
        return this;
    }

    @Override
    public String getCommentText() {
        return driver.findElement(By.id("commentdesc")).getText();
    }

    @Override
    public ParticipationPage typeCommentText(String text) {
        driver.findElement(By.id("commentdesc")).sendKeys(text);
        return this;
    }

    @Override
    public ParticipationPage addComment() {
        driver.findElement(By.xpath("//*[text() = 'Ajouter commentaire']")).click();
        return this;
    }

    @Override
    public ParticipationPage addCommentExpectingError() {
        driver.findElement(By.xpath("//*[text() = 'Ajouter commentaire']")).click(); // TODO verifier si erreur
        return this;
    }
}
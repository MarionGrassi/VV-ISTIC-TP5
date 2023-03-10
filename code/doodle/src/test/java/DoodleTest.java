import create.CreatePage;
import dateChoice.DateChoicePage;
import home.HomePage;
import home.HomePageImpl;
import org.junit.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import participation.ParticipationPage;
import resume.ResumePage;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DoodleTest {

    @Test
    public void test() {
        // Set up the web driver
        System.setProperty("webdriver.chrome.driver", "/home/marion/Documents/VV/chromedriver_linux64/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);

        driver.get("http://localhost:4200");

        // on arrive sur la page d'accueil
        HomePage homePage = new HomePageImpl(driver);

        // on clique sur le bouton pour créer un nouveau sondage
        CreatePage createPage = homePage.createPoll();
        // on rempli les infos du sondage
        createPage.typeTitreReunion("test");
        createPage.typeLieuReunion("ISTIC");
        createPage.typeDescriptionReunion("test");

        // on va sur la page pour choisir la date
        DateChoicePage dateChoicePage = createPage.next();
        dateChoicePage.addCreneau("11:00:00");

        // on va sur la page de résumé
        ResumePage resumePage = dateChoicePage.next();

        // on va sur la page du particpant
        ParticipationPage participationPage = resumePage.toParticipationPage();
        // on rempli les infos du participant
        participationPage.typeParticipantName("John Doe");
        participationPage.typeParticipantMail("johndoe"); // adresse mail invalide
        participationPage.setDisponibility(0, "John Doe", true);

        List<WebElement> errors = participationPage.errors();
        assertEquals(1, errors.size());
    }
}
package admin;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public interface AdminPage {
    Map<String, String> getComments();
    int getNombreParticipantsPourCreaneau(int creaneau);
    AdminPage validateCreneau(int creneau);
    int getNombreCreneaux();
    String getDateCreaneau(int creneau);
    boolean waitUntilAvailble();
    List<WebElement> errors();
}

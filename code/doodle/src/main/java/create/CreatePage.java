package create;

import dateChoice.DateChoicePage;
import home.HomePage;

public interface CreatePage {
    String getTitreReunion();
    CreatePage typeTitreReunion(String titre);
    String getLieuReunion();
    CreatePage typeLieuReunion(String lieu);
    String getDescriptionReunion();
    CreatePage typeDescriptionReunion(String description);
    boolean hasRepas();
    CreatePage setRepas(boolean isRepas);
    HomePage back();
    DateChoicePage next();
    boolean waitUntilAvailble();

}

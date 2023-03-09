package admin;

import java.util.Map;

public interface AdminPage {
    Map<String, String> getComments();
    int getNombreParticipantsPourCreaneau(int creaneau);
    AdminPage validateCreneau(int creneau);
    int getNombreCreneaux();
    String getDateCreaneau(int creneau);
}

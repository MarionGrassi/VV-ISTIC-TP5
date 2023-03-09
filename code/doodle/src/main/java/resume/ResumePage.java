package resume;

import admin.AdminPage;
import dateChoice.DateChoicePage;
import participation.ParticipationPage;

public interface ResumePage {
    ParticipationPage toParticipationPage();
    AdminPage toAdminPage();
    DateChoicePage back();

    // TODO rajouter toEtherpad & toChat
}

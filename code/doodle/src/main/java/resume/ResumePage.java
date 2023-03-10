package resume;

import dateChoice.DateChoicePage;

public interface ResumePage {
    String toParticipationPage();
    String toAdminPage();
    DateChoicePage back();
    boolean waitUntilAvailble();

    // TODO rajouter toEtherpad & toChat
}

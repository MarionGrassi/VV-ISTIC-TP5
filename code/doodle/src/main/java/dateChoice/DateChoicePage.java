package dateChoice;

import create.CreatePage;
import resume.ResumePage;

public interface DateChoicePage {
    boolean waitUntilAvailble();
    boolean hasAgenda();
    DateChoicePage setHasAgenda(boolean value);
    String getAgenda();
    DateChoicePage typeAgenda(String url);
    DateChoicePage addCreneau(String time);
    CreatePage back();
    ResumePage next();
}

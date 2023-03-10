package dateChoice;

import create.CreatePage;
import org.openqa.selenium.Point;
import resume.ResumePage;

import java.time.LocalDateTime;

public interface DateChoicePage {
    boolean hasAgenda();
    DateChoicePage setHasAgenda(boolean value);
    String getAgenda();
    DateChoicePage typeAgenda(String url);
    DateChoicePage addCreneau(String time);
    CreatePage back();
    ResumePage next();
}

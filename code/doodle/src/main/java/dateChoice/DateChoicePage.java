package dateChoice;

import create.CreatePage;
import org.openqa.selenium.Point;
import resume.ResumePage;

public interface DateChoicePage {
    boolean hasAgenda();
    DateChoicePage setHasAgenda(boolean value);
    String getAgenda();
    DateChoicePage typeAgenda(String url);
    DateChoicePage addCreneau(Point point);
    CreatePage back();
    ResumePage next();
}

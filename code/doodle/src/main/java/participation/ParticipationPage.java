package participation;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public interface ParticipationPage {

    String getParticipantName();

    ParticipationPage typeParticipantName(String participant);

    String getParticipantMail();

    ParticipationPage typeParticipantMail(String mail);

    boolean hasAgenda();

    ParticipationPage setHasAgenda(boolean value);

    String getAgenda();

    ParticipationPage typeAgenda(String url);

    boolean hasFoodPreferences();

    ParticipationPage setHasFoodPreferences(boolean value);

    String getFoodPreferences();

    ParticipationPage typeFoodPreferences(String foodPreferences);

    /**
     * @return isCalendarView
     */
    boolean isCalendarViewOrTableView();

    ParticipationPage setCalendarOrTableView(boolean isCalendar);

    Map<String, Map<Integer, Boolean>> getDisponibilities();

    ParticipationPage setDisponibility(int creneau, String participant, boolean available);

    ParticipationPage submit();

    ParticipationPage submitExpectingErrors();

    Map<String, String> getComments();

    String getCommentAuthor();

    ParticipationPage typeCommentAuthor(String author);

    String getCommentText();

    ParticipationPage typeCommentText(String text);

    ParticipationPage addComment();

    ParticipationPage addCommentExpectingError();

    List<WebElement> errors();
}
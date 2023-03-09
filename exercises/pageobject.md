## Page Object Model

The image below shows the poll page of the [Simba Organizer](https://github.com/barais/doodlestudent/) application discussed in classes.

![Simba Organizer Poll page](simba-poll-page.png)

Write in this document the interface of a page object class for this page.

## Answer

```java
public interface PollPage {

    public String getParticipantName();

    public PollPage typeParticipantName(String participant);

    public String getParticipantMail();

    public PollPage typeParticipantMail(String mail);

    public boolean hasAgenda();

    public PollPage setHasAgenda(boolean value);

    public String getAgenda();

    public PollPage typeAgenda(String url);

    public boolean hasFoodPreferences();

    public PollPage setHasFoodPreferences(boolean value);

    public String getFoodPreferences();

    public PollPage typeFoodPreferences(String foodPreferences);

    /**
     * @return isCalendarView
     */
    public boolean isCalendarViewOrTableView();

    public PollPage setCalendarOrTableView(boolean isCalendar);

    public Map<String, Map<Date, Boolean>> getDisponibilities();

    public PollPage setDisponibility(Date date, String participant, boolean available);

    public PollPage submit();

    public PollPage submitExpectingErrors();

    public Map<String, String> getComments();

    public String getCommentAuthor();

    public PollPage typeCommentAuthor(String author);

    public String getCommentText();

    public PollPage typeCommentText(String text);

    public PollPage addComment();

    public PollPage addCommentExpectingError();
}
```

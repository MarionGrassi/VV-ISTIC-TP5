## Page Object Model

The image below shows the poll page of the [Simba Organizer](https://github.com/barais/doodlestudent/) application discussed in classes.

![Simba Organizer Poll page](simba-poll-page.png)

Write in this document the interface of a page object class for this page.

## Answer

```java
public interface PollPage {
    
    public String participant();
    
    public PollPage typeParticipant(String participant);
    
    public String mail();
    
    public PollPage typeMail(String mail);
    
    public boolean hasAgenda();
    
    public PollPage setHasAgenda(boolean value);
    
    public boolean hasFoodPreferences();
    
    public PollPage setHasFoodPreferences(boolean value);
    
    public boolean calendarOrTableView();
    
    public PollPage setCalendarOrTableView();
    
    public Map<String, List<Pair<Date, Booleab>>> disponibilities();
    
    public PollPage setDisponibility(Date date, String participant, boolean available);
    
    public NextPage submit();
    
    public PollPage submitExpectingErrors();
    
    public String commentAuthor();
    
    public PollPage typeCommentAuthor(String author);
    
    public String commentText();
    
    public PollPage typeCommentText(String text);
    
    public CommentPage addComment();
    
    public PollPage addCommentExpectingError();
}
```

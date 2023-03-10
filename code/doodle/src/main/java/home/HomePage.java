package home;

import create.CreatePage;

public interface HomePage {
    CreatePage createPoll();
    boolean waitUntilAvailble();
}

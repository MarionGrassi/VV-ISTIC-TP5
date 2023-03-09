# Random Wikipedia walker

Using Selenium, create a small program that, starting from the main page https://www.wikipedia.org/, walks trough a sequence of random links and takes a snapshot of the last page.
The process is as follows:

 1. Navigate to the main page https://www.wikipedia.org/
 2. Select a random link in the page
 3. Navigate to the link
 4. Repeat steps 2 to 3 until you have visited 10 different pages
 5. Take a snapshot of the current page and save it

Include the code of the walker and the snapshot in this document.

## Answer

Nous n'avons pas réussis à lancer un programme java utilisant Selenium donc nous avons fait un programme python à la place.

```python
import random
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.common.exceptions import ElementNotInteractableException
import sys

def wikipedia():
    browser = webdriver.Firefox()
    browser.get("https://www.wikipedia.org/")

    i = 0
    while i < 10:
        # select a random link
        links = browser.find_elements(By.TAG_NAME, "a")
        random_link = random.choice(links)
        
        try:
            # navigate to the link
            random_link.click()
            i = i + 1
        except:
            # some link aren't clickable
            print(sys.exc_info()[0])
            

    # take a screenshot and save it
    filename = f"screenshot.png"
    browser.save_screenshot(filename)

    browser.quit()

if __name__ == "__main__":
    wikipedia()
```

Voici le screenshot obtenu après avoir cliqué sur 10 liens :

![screenshot](screenshot.png)

package pages;

import functions.Action;
import functions.Assertions;
import functions.Elements;
import functions.Waiters;
import org.openqa.selenium.WebDriver;

public class BasePage {
    static Waiters wait;
    static Action action;
    static Assertions assertions;
    static Elements elements;
    protected static WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver=driver;
        wait = new Waiters(driver);
        action= new Action(driver);
        assertions=new Assertions(driver);
        elements = new Elements(driver);
    }
}

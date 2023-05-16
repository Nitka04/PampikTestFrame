package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Action {
        private  final Elements elements;
        private final Actions actions;
        private final Waiters waiters;
        private final WebDriver driver;
    static final Logger logger = LoggerFactory.getLogger(Elements.class);


    public Action(WebDriver driver) {
        this.driver = driver;
        actions=new Actions(driver);
        elements=new Elements(driver);
        waiters=new Waiters(driver);
    }
//ми не прописуємо вайтерси в акшинах так як вже зробили це в елементц классі. тобто вони вже очікуються
    public void dragNDrop(String xpath1,String xpath2){
        actions.dragAndDrop(elements.findElementByXpath(xpath1), elements.findElementByXpath(xpath2)).perform();
    }
    public void sendKeys(WebElement element,String string){
        waiters.waitForVisabilityOfElement(element);
        actions.sendKeys(element,string).build().perform();
        logger.info("Send keys: "+string);
    }






}

package functions;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    public void sendKeysWebEl(WebElement element,String string){
        waiters.waitForVisabilityOfElement(element);
        logger.info("Send keys: "+string);
        actions.sendKeys(element,string).build().perform();

    }
    public void sendKeysBy(By by,String string){
        waiters.waitForVisabilityOfElement(by);
        WebElement element=elements.findElement(by);
        logger.info("Send keys: "+string);
        actions.sendKeys(element, string).build().perform();
    }
   /* public void sendKeysButton(String nameOfButton) throws InterruptedException {
        Thread.sleep(2000);
        logger.info("Send keys: "+nameOfButton);
        actions.sendKeys((nameOfButton.toUpperCase())).build().perform();
    }*/
    public void sendKeysEnter() throws InterruptedException {
        Thread.sleep(1000);
        logger.info("Button Enter send.");
        actions.sendKeys(Keys.ENTER).build().perform();

    }






}

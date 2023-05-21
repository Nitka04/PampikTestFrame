package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Assertions {
    private final WebDriver driver;
    private final Waiters waiters;
    private final Action action;
    private final Elements elements;
    static final Logger logger = LoggerFactory.getLogger(Assertions.class);

    public Assertions(WebDriver driver){
     this.driver=driver;
     elements=new Elements(driver);
     waiters=new Waiters(driver);
     action =new Action(driver);
    }


    public void isDisplayd(String xpath){
        logger.info("Checking if Element Displayed:" +xpath);
        assertTrue(elements.isElementDisplayd(xpath),"The text is not displayed.");
    }
    public void isSelected(String xpath){
        logger.info("Checking if Element Selected:" +xpath);
        assertTrue(elements.isSelected(xpath),"The text is not selected.");}

    public void isSelected(Boolean result){assertTrue(result, "The text is not selected.");
    }

    public  void equalsOfTexts(String xpath,String expectedText){
        assertEquals(elements.getElementText(elements.findElementByXpath(xpath)), expectedText, "The text not equals of "+expectedText+"the real text are:"+elements.getElementText(elements.findElementByXpath(xpath)));
    }
    public  void equalsOfText(String receivedText,String expectedText){
        logger.info("Checking if the  received text equals:" +receivedText);
        assertEquals(receivedText, expectedText, "The text not equals of "+expectedText+"the real text are:"+receivedText);
    }
    public  void equalsOfInts(int actual,int expected){
        logger.info("Checking if the received Int equals:" +actual);
        assertEquals(actual, expected, "The int not equals of "+expected+"the real c are:"+actual);
    }

    public  void containsSomeText(String xpath,String expectedString){
        logger.info("Checking if the  received text contains Some text." );
        assertTrue(xpath.contains(expectedString), "String did not contain the required text:"+expectedString);
    }
    public  void equalsOfUrl(String urls,String expectedUrl){
        logger.info("Checking if the  received URL equals:"+urls);
        assertEquals(urls, expectedUrl, "The url is not that expected."+expectedUrl+"the real text are:");
    }





}

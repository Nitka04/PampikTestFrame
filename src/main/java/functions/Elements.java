package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Elements {
//класс для використання методів пошуку елементів в нащіх тестах та фрейм ворках
static final Logger logger = LoggerFactory.getLogger(Elements.class);
    private  final WebDriver driver;
    private final Waiters waiters;// це вже зроблений нами класс з ветерсами;

    public  Elements(WebDriver driver){
        this.driver=driver;
        waiters=new Waiters(driver);
    }

    public WebElement findElement(By by){
        try{
            waiters.waitForVisabilityOfElement(by);
            return driver.findElement(by);
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return null;
    }

    public WebElement findElementByXpath(String xpath){
        try{
            waiters.waitForVisabilityOfElement(By.xpath(xpath));
            return driver.findElement(By.xpath(xpath));
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return null;

    }

    public String getElementText(WebElement element){
        waiters.waitForVisabilityOfElement(element);
        logger.info("Getting text from element:"+element);
        return element.getText();
    }
    public String getElementText(By by){
       waiters.waitForVisabilityOfElement(by);
        logger.info("Getting text from element: "+driver.findElement(by).getText());
        return driver.findElement(by).getText();
    }
    public String getElementTextWaitReturn(By by,String text){
        /* waiters.waitForVisabilityOfElement(by);*/
        waiters.waitFortextToBePresentInElementValue(by, text);
        logger.info("Getting text from element:"+ text);
        return driver.findElement(by).getText();
    }


    public String getTitleOfPage(){
        return driver.getTitle();
    }

    public void clickElement(WebElement element){
        logger.info("Click on element located by: "+element);
        waiters.waitForElementToBeClickable(element);
        element.click();
    }
    public void clickElement(By by){
        logger.info("Click on element located by: "+by);
        waiters.waitForElementToBeClickableReturn(by).click();
    }
    public void clickElementByXpath(String xpath){
        findElement(By.xpath(xpath)).click();
    }

    public void clickElementInsideFrameXpath(String xpathFrame,String xpathElement){
        waiters.waitForFrameAndSwitchXpath(xpathFrame);
        WebElement element=findElementByXpath(xpathElement);
       element.click();
    }

    public boolean isElementDisplayd(String xpath){
       return findElementByXpath(xpath).isDisplayed();
    }

    public  boolean isSelected(String xpath){
         waiters.waitForVisabilityOfElement(By.xpath(xpath));
       return  findElementByXpath(xpath).isSelected();}
    public  boolean isSelected(By by){
        waiters.waitForVisabilityOfElement(by);
        return  findElement(by).isSelected();}
    public  boolean isSelectedWaiters(String xpath){
    waiters.waitForElementSelectionStateToBe(By.xpath(xpath), true);
     return findElementByXpath(xpath).isDisplayed();
    }


}

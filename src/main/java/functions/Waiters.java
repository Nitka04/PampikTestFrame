package functions;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

//написання методів по очікуванню виконання тестових завдань
public class Waiters {
    static final Logger logger= LoggerFactory.getLogger(Waiters.class);//створбємо клас логеров. Будемо їх використовувати в репорті.
    // по логерам буде зрозуміло на якому місці впав тест
    private final WebDriver driver;//переменная незмінна
    private static final long EXPLICITY_WAIT = 20L;

    public Waiters(WebDriver driver) {//конструктор
        this.driver = driver;
    }

    //Пириватний метод якийповертає значення рівне такому:(new WebDriverWait(driver, Duration.ofSeconds(EXPLICITY_WAIT)))
//завдяки цьому методу ми можемо повертати Webelement;
    private FluentWait<WebDriver> fluentWait(Long duration) { //метод який повертає
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(duration))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(InvalidElementStateException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    // Пириватний метод відповідає за очікування функції що рівно такому запису: wait.until(ExpectedConditions.presenceOfElementLocated
//(By.xpath("//input[@placeholder='поиск товаров']")))
//можемо використовувати данний метод як для очікування так і для повернення значення Webelement
    private void waitForFunction(Function function, Long timeOutInSeconds) { //метод який повертає
       // logger.info("Waiting for function");//коментар до виконання
        FluentWait<WebDriver> wait = fluentWait(timeOutInSeconds);
    }

    //VisabilityOfElement
    public void waitForVisabilityOfElement(WebElement element) {
        logger.info("Waiting for visability of element : "+element);
        waitForFunction(ExpectedConditions.visibilityOf(element), EXPLICITY_WAIT);
    }

    public void waitForVisabilityOfElement(By by) {
        logger.info("Waiting for visability of element : "+by.toString());
        waitForFunction(ExpectedConditions.visibilityOf(driver.findElement(by)), EXPLICITY_WAIT);
    }

    public WebElement waitForVisabilityOfElementReturn(WebElement element) {
        return fluentWait(EXPLICITY_WAIT).until(
                ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForVisabilityOfElementReturn(By by) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOf(driver.findElement(by)));
    }

    //waitSomeSecond
    public void waitSomeSecond(int seconds) {
        int milisecond = seconds * 1000;
        try {
            Thread.sleep(milisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //ElementToBeClickable
    public WebElement waitForElementToBeClickableReturn(WebElement element) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForElementToBeClickableReturn(By by) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));
    }

    public void waitForElementToBeClickable(WebElement element) {
        logger.info("Wait for element to be clickable:" + element);
        waitForFunction(ExpectedConditions.elementToBeClickable(element), EXPLICITY_WAIT);
    }

    public void waitForElementToBeClickable(By by) {
        waitForFunction(ExpectedConditions.elementToBeClickable(driver.findElement(by)), EXPLICITY_WAIT);
    }

    //elementToBeSelected()
    public void waitForElementToBeSelected(By by) {
        waitForFunction(ExpectedConditions.elementToBeSelected(driver.findElement(by)), EXPLICITY_WAIT);
    }

    public void waitForElementToBeSelected(WebElement element) {
        waitForFunction(ExpectedConditions.elementToBeSelected(element), EXPLICITY_WAIT);
    }

    //presenceOfElementLocated()
    public WebElement waitForPresenceOfElementLocatedReturn(By by) {
        logger.info("Waiting for presence of elements located by: "+by.toString());
        return fluentWait(EXPLICITY_WAIT)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForPresenceOfElementLocated(By by) {
        waitForFunction(ExpectedConditions.presenceOfElementLocated(by), EXPLICITY_WAIT);
    }

    //textToBePresentInElementValue
    public void waitFortextToBePresentInElementValue(WebElement element, String text) {
        waitForFunction(ExpectedConditions
                .textToBePresentInElementValue(element, text), EXPLICITY_WAIT);
    }

    public void waitFortextToBePresentInElementValue(By by, String text) {
        waitForFunction(ExpectedConditions
                .textToBePresentInElementValue(driver.findElement(by), text), EXPLICITY_WAIT);
    }

    //invisibilityOf()
    public void waitForInvisibilityOf(WebElement element) {
        waitForFunction(ExpectedConditions
                .invisibilityOf(element), EXPLICITY_WAIT);
    }

    //titleContains()
    public void waitForTitleContains(String text) {
        waitForFunction(ExpectedConditions
                .titleContains(text), EXPLICITY_WAIT);
    }

    //titleIs()
    public void waitForTitleIs(String text) {
        waitForFunction(ExpectedConditions
                .titleIs(text), EXPLICITY_WAIT);
    }

    // elementSelectionStateToBe()
    public void waitForElementSelectionStateToBe(By by, boolean ExResult) {
        waitForFunction(ExpectedConditions.elementSelectionStateToBe(driver.findElement(by), ExResult), EXPLICITY_WAIT);
    }

    public void waitForElementSelectionStateToBe(WebElement element, boolean ExResult) {
        waitForFunction(ExpectedConditions.elementSelectionStateToBe(element, ExResult), EXPLICITY_WAIT);
    }

    //visibilityOfElementLocated()
    public void waitForElementSelectionStateToBe(By by) {
        waitForFunction(ExpectedConditions.visibilityOfElementLocated(by), EXPLICITY_WAIT);
    }

    public WebElement waitForElementSelectionStateToBeReturn(By by) {
        return fluentWait(EXPLICITY_WAIT)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //frameToBeAvailableAndSwitchToIt()
    public void waitForFrameToBeAvailableAndSwitchToIt(By by) {
        waitForFunction(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(by)), EXPLICITY_WAIT);
    }

    public void waitForFrameToBeAvailableAndSwitchToIt(WebElement element) {
        waitForFunction(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element), EXPLICITY_WAIT);
    }
//Frame and switch
    public void waitForFrameAndSwitchXpath(String xpath) {
        logger.info("Waiting for presence of Frame located by: "+xpath);
        waitForPresenceOfElementLocated(By.xpath(xpath));
        waitForFunction(ExpectedConditions
                .frameToBeAvailableAndSwitchToIt(By.xpath(xpath)), EXPLICITY_WAIT);

    }

    //alertIsPresent()
    public Alert waitAlertIsPresent() {
        return fluentWait(EXPLICITY_WAIT)
                .until(ExpectedConditions.alertIsPresent());
    }



}


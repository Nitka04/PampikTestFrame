package pages;

import functions.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

import static org.testng.Assert.assertTrue;

public class MainPage extends BasePage{
    Waiters waiters=new Waiters(driver);
    static final Logger logger = LoggerFactory.getLogger(MainPage.class);
    public MainPage(WebDriver driver) {super(driver);}

    private static class Locators{
        //перевірка зворотнього дзвінку
        private final static By callMeButton= By.xpath("//a[@class='call-me-btn']");
       private final static By inputTelephoneNumber =By.xpath("//input[@id='phoneCallback']");
       private final static By vidpravityButton =By.xpath("//button[@id='popup-callback-btn']");
        private final static By conformationCallWindow =By.xpath("//div[@class='popup-text'][1]");
// проверка на правильній переход на месеннджері
        private final static By onlineSuppotButton = By.xpath("//div[@class='rngst_phone_body--tooltip rngst_phone_icon']");
//перевірка результатів пошуку
        private final static  By seachLine =By.xpath("//input[@id='search-form__input']");
        private final static By positiveSeachText=By.tagName("h1");
        private final static By negativeSeachText= By.xpath("//div[@class='l-search-empty']/mark");
//перевірка перемикача міста
        private final static By cityNameClicker=By.xpath("//a[@class='current-city-name']");
//перевірити що логотип веде до головної сторінки
        private final static By mainLogo=By.xpath("//img[@class='js-logo']");

    }
    public static class Labels{
        private final static String url ="https://pampik.com/ua";
        public final static String ConformationText="передзвонимо";
      }

    public void  openPage(){
        logger.info(Labels.url);
        driver.get(Labels.url);}

    public String CallMeBackGetText(String telefonNumber) throws InterruptedException {
        elements.clickElement(Locators.callMeButton);
        wait.waitForElementToBeClickable(Locators.inputTelephoneNumber);
        Thread.sleep(3000);
        WebElement inputTelephoneNumber=elements.findElement(Locators.inputTelephoneNumber);
        action.sendKeysWebEl(inputTelephoneNumber,telefonNumber);
        elements.clickElement(Locators.vidpravityButton);
        Thread.sleep(3000);
        String receivedText=elements.getElementText(Locators.conformationCallWindow);
       return receivedText;
    }
    public String getUrlFromOpenWindow(String xpath) throws InterruptedException {
        Thread.sleep(3000);
        elements.clickElement(Locators.onlineSuppotButton);
        String descr1 = driver.getWindowHandle();
        Set<String> set1 = driver.getWindowHandles();
        elements.clickElement(By.xpath(xpath));
        Set<String> set2 = driver.getWindowHandles();
        set2.removeAll(set1);
        String descr2 = set2.iterator().next();
        driver.switchTo().window(descr2);
        Thread.sleep(1000);
        String urlOfCurentPage = driver.getCurrentUrl();
        return urlOfCurentPage;

    }
     public void SearchResult(String searchWord) throws InterruptedException {
       elements.clickElement(Locators.seachLine);
        action.sendKeysBy(Locators.seachLine, searchWord);
        waiters.waitFortextToBePresentInElementValue(Locators.seachLine, searchWord);
        action.sendKeysEnter();

     }
     public String getTextPositiveSeach(String searchWord){
        WebElement positiveSeachText=elements.findElement(Locators.positiveSeachText);
         logger.info("Get text from result search.");
       String resultOfPositiveSeach=positiveSeachText.getText();
       return resultOfPositiveSeach;
     }
    public String getTextNegativeSeach(String searchWord){
        WebElement negativeSeachText=elements.findElement(Locators.negativeSeachText);
        logger.info("Get text from result search.");
        String resultOfNegativeSeach=negativeSeachText.getText();
        return resultOfNegativeSeach;
    }

    public void clickOnCity(String xpathCityName){
     elements.clickElement(Locators.cityNameClicker);
     elements.clickElementByXpath(xpathCityName);
    }
    public String getCityName(String nameCity) throws InterruptedException {
        Thread.sleep(1000);
        String cityName=elements.getElementTextWaitReturn(Locators.cityNameClicker,nameCity);
        return cityName;
    }

    public void gotoAnotherUrlPageAndClickLogo(String url){
        driver.get(url);
        elements.clickElement(Locators.mainLogo);
    }
     public String getUrlFromCurrantPage(){
       return driver.getCurrentUrl();
     }

}

package pages;

import com.google.inject.internal.ErrorsException;
import functions.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

import static org.testng.Assert.assertTrue;

public class MainPage extends BasePage{
    Waiters waiters=new Waiters(driver);
    public MainPage(WebDriver driver) {super(driver);}
    class NoSuchUrlException extends Exception {
        public String getMessage() {
            return "Wrong URL.";
        }
    }
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
        private final static By positiveSeachText=By.xpath("//h1[@class='title']");
        private final static By negativeSeachText= By.xpath("//div[@class='l-search-empty']/mark");
//перевірка перемикача міста
private final static By cityNameClicker=By.xpath("//a[@class='current-city-name']");

//перевірити що логотип веде до головної сторінки
        private final static By mainLogo=By.xpath("//img[@class='js-logo']");



    }
    public static class Labels{
        private final static String url ="https://pampik.com/ua";
        public final static String ConformationText="Ми отримали вашу заявку. Будь ласка, дайте нам ще трохи часу і ми передзвонимо!";
        public final static By positiveSeachText=By.xpath("//h1[@class='title']");
        public final static String ffffffffffff="//h1[@class='title']";
        public final static By negativeSeachText=By.xpath("//div[@class='l-search-empty']/mark");
//перевірити що логотип веде до оловної сторінки
        private final static String urlCheckMainLogo1="https://pampik.com/ua/brand/HiPP";
        private final static String urlCheckMainLogo5="https://pampik.com/ua/info";
        private final static String urlCheckMainLogo2="https://pampik.com/ua/category/hodunki-i-pryigunki";
        private final static String urlCheckMainLogo3="https://pampik.com/ua/category/byitovaya-himiya-i-uhod-za-domom";
        private final static String urlCheckMainLogo4="https://pampik.com/ua/catalog/konstruktor-lego-classic-bolshoy-nabor-dlya-tvorchestva-790-detaley-10698";



      }

    public void  openPage(){driver.get(Labels.url);}

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
        String urlOfCurentPage = driver.getCurrentUrl();
        return urlOfCurentPage;
    }

     public void checkOfSearchResult(String searchWord) throws InterruptedException {
       elements.clickElement(Locators.seachLine);
        action.sendKeysBy(Locators.seachLine, searchWord);
        action.sendKeysEnter();

     }
    public String getTextfromElement(By xpath){
        String TextfromElement=elements.getElementText(xpath);
        return TextfromElement;
    }
     public String getTextPositiveSeach(String searchWord){
        WebElement positiveSeachText=elements.findElement(Locators.positiveSeachText);
       String resultOfPositiveSeach=positiveSeachText.getText();
       return resultOfPositiveSeach;
     }
    public String getTextNegativeSeach(String searchWord){
        WebElement negativeSeachText=elements.findElement(Locators.negativeSeachText);
        String resultOfNegativeSeach=negativeSeachText.getText();
        return resultOfNegativeSeach;
    }

    public void clickOnCity(String xpathCityName){
     elements.clickElement(Locators.cityNameClicker);
     elements.clickElementByXpath(xpathCityName);
    }



}

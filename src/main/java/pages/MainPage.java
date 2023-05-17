package pages;

import functions.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

import static org.testng.Assert.assertTrue;

public class MainPage extends BasePage{
    Waiters waiters=new Waiters(driver);
    public MainPage(WebDriver driver) {super(driver);}
    private static class Locators{
        //перевірка зворотнього дзвінку
        private final static WebElement callMeButton= elements.findElement(By.xpath("//a[@class='call-me-btn']"));
       private final static WebElement inputTelephoneNumber =elements.findElement(By.xpath("//input[@id='phoneCallback']"));
       private final static WebElement vidpravityButton =elements.findElement(By.xpath("//button[@id='popup-callback-btn']"));
        private final static By conformationCallWindow =By.xpath("//div[@class='popup-text'][1]");
// проверка на правильній переход на месеннджері
        private final static WebElement onlineSuppotButton = elements.findElementByXpath("//div[@class='rngst_phone_body--tooltip rngst_phone_icon']");
//перевірка результатів пошуку
        private final static  WebElement seachLine =elements.findElementByXpath("//input[@id='search-form__input']");
        private final static WebElement positiveSeachText=elements.findElementByXpath("//h1[@class='title']");
        private final static WebElement negativeSeachText= elements.findElementByXpath("//div[@class='l-search-empty']/mark");
//перевірка перемикача міста
        private final static By cityNameClicker=By.xpath("//a[@class='current-city-name']");
        private final static By linksCityKiyv=By.xpath("//a[@data-id='9787']");
        private final static By linksCityDnipro=By.xpath("//a[@data-id='6500']");
        private final static By linksCityKharkiv=By.xpath("//a[@data-id='25121']");
        private final static By linksCityZaporiggya=By.xpath("//a[@data-id='8008']");
        private final static By linksCityLviv=By.xpath("//a[@data-id='13242']");
//перевірити що логотип веде до головної сторінки




    }
    public static class Labels{
        private final static String url ="https://pampik.com/ua";
        public final static String ConformationText="Ми отримали вашу заявку. Будь ласка, дайте нам ще трохи часу і ми передзвонимо!";
        public final static By positiveSeachText=By.xpath("//h1[@class='title']");
        public final static By negativeSeachText=By.xpath("//div[@class='l-search-empty']/mark");
//перевірити що логотип веде до оловної сторінки
        private final static String urlCheckMainLogo="https://pampik.com/ua/brand/HiPP";
        private final static String urlCheckMainLogo1="https://pampik.com/ua/info";
        private final static String urlCheckMainLogo2="";
        private final static String urlCheckMainLogo3="";
        private final static String urlCheckMainLogo4="";
        private final static String urlCheckMainLogo5="";
        private final static String urlCheckMainLogo6="";


      }

    public void  openPage(){driver.get(Labels.url);}

    public String CallMeBackGetText(String telefonNumber) throws InterruptedException {
        elements.clickElement(Locators.callMeButton);
        wait.waitForElementToBeClickable(Locators.inputTelephoneNumber);
        Thread.sleep(3000);
        action.sendKeysWebEl(Locators.inputTelephoneNumber,telefonNumber);
        elements.clickElement(Locators.vidpravityButton);
        Thread.sleep(3000);
        String receivedText=elements.getElementText(Locators.conformationCallWindow);
       return receivedText;
    }
    public String getUrlFromOpenWindow(String xpath) throws InterruptedException {
        Thread.sleep(3000);
        elements.clickElement(Locators.onlineSuppotButton);
        String descr1= driver.getWindowHandle();
        Set<String> set1 = driver.getWindowHandles();
        elements.clickElement(By.xpath(xpath));
        Set<String> set2 = driver.getWindowHandles();
        set2.removeAll(set1);
        String descr2=set2.iterator().next();
        driver.switchTo().window(descr2);
        String urlOfCurentPage=driver.getCurrentUrl();
        return urlOfCurentPage;
    }
     public void checkOfSearchResult(String searchWord) throws InterruptedException {
       elements.clickElement(Locators.seachLine);
        action.sendKeysWebEl(Locators.seachLine, searchWord);
        action.sendKeysEnter();
     }
    public String getTextfromElement(By xpath){
        String TextfromElement=elements.getElementText(xpath);
        return TextfromElement;
    }
     public String getTextPositiveSeach(String searchWord){
       String resultOfPositiveSeach=Locators.positiveSeachText.getText();
       return resultOfPositiveSeach;
     }
    public String getTextNegativeSeach(String searchWord){
        String resultOfNegativeSeach=Locators.negativeSeachText.getText();
        return resultOfNegativeSeach;
    }

    public void clickOnCity(String xpathCytyName){
     elements.clickElement(Locators.cityNameClicker);
     elements.clickElementByXpath(xpathCytyName);
    }



}

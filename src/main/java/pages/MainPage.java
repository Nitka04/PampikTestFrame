package pages;

import functions.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class MainPage extends BasePage{
    public MainPage(WebDriver driver) {super(driver);}
    private static class Locators{
        private final static WebElement callMeButton= elements.findElement(By.xpath("//a[@class='call-me-btn']"));
        private final static WebElement InputTelephoneNumber=elements.findElement(By.xpath("//input[@id='phoneCallback']"));
        private final static WebElement VidpravityButton=elements.findElement(By.xpath("//button[@id='popup-callback-btn']"));
        private final static By ConformationCallWindow=By.xpath("//div[@class='popup-text'][1]");
// проверка на правильній переход на месеннджері
        private final static WebElement OnlineSuppotButton= elements.findElementByXpath("//div[@class='rngst_phone_body--tooltip rngst_phone_icon']");
        private final static WebElement TelegramSuppotButton= elements.findElementByXpath("//div[@class='dropdown-content-rngst']/a[1]");
        private final static WebElement ViberSuppotButton= elements.findElementByXpath("//div[@class='dropdown-content-rngst']/a[2]");
//перевірка результатів пошуку
       // private final static By SeachLine= By.xpath("//input[@id='search-form__input']");
       // private final static By NegativeSeachText= By.xpath(" //div[@class='l-search-empty']/mark");
        



    }
    public static class Labels{
        private final static String url ="https://pampik.com/ua";
       public final static String ConformationText="Ми отримали вашу заявку. Будь ласка, дайте нам ще трохи часу і ми передзвонимо!";
      public final static String urlTelegram="https://telegram.me/helponlinebot?start=uBki1eoAbSgeXwox9KNm1QwvidBtl4m8PCR6-qdL6hMKtR6g";
      public final static String urlViber="viber://pa?chatURI=onlinesupportbot&context=uBki1eoAbSgeXwox9KNm1QwvidBtl4m8PCR6-qdL6hMKtR6g";
    }
    public void  openPage(){driver.get(Labels.url);}

    public String CallMeBackGetText(String telefonNumber) throws InterruptedException {
        elements.clickElement(Locators.callMeButton);
        wait.waitForElementToBeClickable(Locators.InputTelephoneNumber);
        Thread.sleep(3000);
        action.sendKeys(Locators.InputTelephoneNumber,telefonNumber);
        elements.clickElement(Locators.VidpravityButton);
        Thread.sleep(3000);
        String receivedText=elements.getElementText(Locators.ConformationCallWindow);
       return receivedText;
    }
    public void getUrlFromOpenWindow(){
        elements.clickElement(Locators.OnlineSuppotButton);
        String descr1= driver.getWindowHandle();
        Set<String> set1 = driver.getWindowHandles();
        elements.clickElement(Locators.TelegramSuppotButton);
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ((JavascriptExecutor)driver).executeScript("window.open()");
        String descr2=set1.iterator().next();
        driver.switchTo().window(descr2);
        System.out.println("11111111111111111111"+driver.getCurrentUrl());

    }


}

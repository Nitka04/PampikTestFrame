package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends BasePage {
    public LogInPage(WebDriver driver) {super(driver);}
    private static class Locators{
//перевірка авторізації
        public final static By inputTelephoneNumber=By.xpath("//input[@class='cst-input cst-input--bg js-only-phone']");
        public final static By inputPassword=By.xpath("//input[@type='password']");
        public final static By errorofTelephoneOrPasswordInputMessage=By.xpath("//div[@class='error-msg']");



    }
    public static class Labels{
        private final static String regestrationPage1 ="https://pampik.com/ua/account/login";

    }
    public void  openPage() {driver.get(Labels.regestrationPage1);}
    public void inputTelephone(String telephoneNumber){
        action.sendKeysBy(Locators.inputTelephoneNumber, telephoneNumber);
    }
    public void inputPassword(String password){
        action.sendKeysBy(Locators.inputPassword, password);
    }
    public String getTextOfError(){
        String errowMessege=elements.getElementText(Locators.errorofTelephoneOrPasswordInputMessage);
        return errowMessege;
    }



}

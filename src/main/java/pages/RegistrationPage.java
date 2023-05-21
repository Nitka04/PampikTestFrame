package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {super(driver);}
    private static class Locators{
//перевірка регістрації
        private final static By inputName=By.xpath("//input[@name='Customer[name]']");
        private final static By inputMail=By.xpath("//input[@name='Customer[email]']");
        private final static By inputPhoneNumber=By.xpath("//input[@name='Customer[phone]']");
        private final static By inputPassword=By.xpath("//input[@name='Customer[password]']");
        private final static By checkboxZgodaPersonalData=By.tagName("//label//br");
        private final static By buttonRegestrationConfirm=By.xpath("//button[@class='cst-btn registration-form__cst-btn']");


    }
    public static class Labels{
        private final static String regestrationPage ="https://pampik.com/ua/account/register";
//errow message locators
        public final static By ErrorMessageName=By.xpath("//div[@class='error-msg'][1]");
        public final static By ErrorMessageEmail=By.xpath("//div[text()='Введіть правильний email']");
        public final static By ErrorMessagePhoneNumber=By.xpath("//input[@name='Customer[phone]'] /following-sibling::*[1]");
        public final static By ErrorMessagePassword=By.xpath("//input[@name='Customer[password]'] /following-sibling::*[1]");


    }
    public void  openPage() {driver.get(Labels.regestrationPage);}
    public void inputName(String name){
        action.sendKeysBy(Locators.inputName, name);
    }
    public void inputMailAdress (String email){
        action.sendKeysBy(Locators.inputMail, email);
    }
    public void inputPhoneNumber(String phoneNumber){
        action.sendKeysBy(Locators.inputPhoneNumber, phoneNumber);
    }
    public void inputPassword(String password){
        action.sendKeysBy(Locators.inputPassword, password);
    }

    public void clickCheckBoxZgodaPersonalData(){
        elements.clickElement(Locators.checkboxZgodaPersonalData);
    }
    public void clickRegestrationConfirmButton(){
        elements.clickElement(Locators.buttonRegestrationConfirm);
    }
    public String getTextOfError(By by){
        String errowMessege=elements.getElementText(by);
        return errowMessege;
    }
    public String getCurrentUrl(){
        String urlOfCurentPage = driver.getCurrentUrl();
        return urlOfCurentPage;
    }
    public void pressButtonUVIYTI(){
        elements.clickElement(Locators.buttonRegestrationConfirm);
    }
}

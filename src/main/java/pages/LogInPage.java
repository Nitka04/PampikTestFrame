package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends BasePage {
    public LogInPage(WebDriver driver) {super(driver);}
    private static class Locators{
//перевірка авторізації
        private final static By inputTelephoneNumber=By.xpath("//input[@class='cst-input cst-input--bg js-only-phone']");
        private final static By inputPassword=By.xpath("//input[@type='password']");
        private final static By errorofTelephoneOrPasswordInputMessage=By.xpath("//div[@class='error-msg']");
        private final static By ButtonUVIYTI=By.xpath("//button[@id='submit-login']");


    }
    public static class Labels{
        private final static String logInPage1 ="https://pampik.com/ua/account/login";
        public final static String urlConfirmationToLoggedUser="https://pampik.com/ua/account";
        public final static String conformationTextOfWrongInputData="Невірний логін або пароль";
        public final static String conformationTextOfEmptyInputData="Заповніть поле";

    }
    public void  openPage() {driver.get(Labels.logInPage1);}
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
    public String getCurrentUrl(){
        String urlOfCurentPage = driver.getCurrentUrl();
        return urlOfCurentPage;
    }
    public void pressButtonUVIYTI(){
        elements.clickElement(Locators.ButtonUVIYTI);
    }
}

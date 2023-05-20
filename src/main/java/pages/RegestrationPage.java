package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegestrationPage extends BasePage {
    public RegestrationPage(WebDriver driver) {super(driver);}
    private static class Locators{
//перевірка авторізації
        public final static By inputTelephoneNumber=By.xpath("//input[@class='cst-input cst-input--bg js-only-phone']");
        public final static By inputPassword=By.xpath("//input[@type='password']");


    }
    public static class Labels{
        private final static String regestrationPage1 ="https://pampik.com/ua/account/login";

    }
    public void  openPage(){driver.get(Labels.regestrationPage1);}


}

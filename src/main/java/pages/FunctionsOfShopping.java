package pages;

import functions.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Set;

public class FunctionsOfShopping extends BasePage{
    Waiters waiters=new Waiters(driver);
    static final Logger logger = LoggerFactory.getLogger(FunctionsOfShopping.class);
    public FunctionsOfShopping(WebDriver driver) {super(driver);}

    private static class Locators {
         private static By filterSelector=By.xpath("//ul[@id='language-bar']");
         private static By SelectorOfGrowingPrice=By.xpath("//span[text()='ціною за зростанням']");

    }
    public static class Labels{
        private final static String url ="https://pampik.com/ua/category/odnorazovye-podguzniki-dla-bassejna/sort/lowest-price";
      }

    public void  openPage(){
        logger.info(Labels.url);
        driver.get(Labels.url);}


}

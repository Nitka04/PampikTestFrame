package startProcess;

import driver.DriverBase;
import functions.Action;
import functions.Assertions;
import functions.Elements;
import functions.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import pages.BasePage;
import pages.FunctionsOfShopping;
import pages.LogInPage;
import pages.RegistrationPage;

public class PreconditionsFunctionsOfShopping {
    static final Logger logger= LoggerFactory.getLogger(PreconditionsMainPageTest.class);
    protected WebDriver driver= DriverBase.startChromeDriver();
    protected BasePage basePage=new BasePage(driver);
    protected Action action=new Action(driver);
    protected Assertions assertions=new Assertions(driver);
    protected Elements elements=new Elements(driver);
    protected Waiters waiters=new Waiters(driver);
    protected FunctionsOfShopping functionsOfShopping=new FunctionsOfShopping(driver);
    @BeforeClass
   public void openPageLogIn() throws InterruptedException {
        logger.info("OPEN page");
        functionsOfShopping.openPage();
        Thread.sleep(3000);

    }
    @BeforeGroups("ClearTheListOfFavorite")
            public void logIn() throws InterruptedException {
        logger.info("LogIn");
        functionsOfShopping.logIn();
        Thread.sleep(3000);
    }

    @AfterGroups("ClearTheListOfFavorite")
    public void clearItemsFromList() throws InterruptedException {
       functionsOfShopping.clearTheListOfFavorite();
    }
    @AfterClass
    public void closePage(){
        logger.info("CLOSING page");
        driver.quit();
    }
    @DataProvider(name="FilterBoxTitle&LabelXpath")
    public Object[][] XpathStringFilter() {
        return new Object[][]{
                {"//div[@data-filter-id='option-7']/div","//div[@data-filter-id='option-7']/div/following-sibling::*[1]/div"},
                {"//div[@data-filter-id='option-1']/div","//div[@data-filter-id='option-1']/div/following-sibling::*[1]/div[3]"},
                {"//div[@data-filter-id='option-5']/div","//div[@data-filter-id='option-5']/div/following-sibling::*[1]/div[7]"},
                {"//div[@data-filter-id='option-2']/div","//div[@data-filter-id='option-2']/div/following-sibling::*[1]/div[3]"}
        };
    }
    @DataProvider(name="AddToFavorite")
    public Object[][] WoardOfSearch() {
        return new Object[][]{
                {"ваги діагностичні"},
                {"Термометр для ванної BabyOno"}
        };
    }

}

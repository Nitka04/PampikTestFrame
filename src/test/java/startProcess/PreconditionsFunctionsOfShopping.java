package startProcess;

import driver.DriverBase;
import functions.Action;
import functions.Assertions;
import functions.Elements;
import functions.Waiters;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import pages.BasePage;
import pages.FunctionsOfShopping;
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
    @BeforeMethod
    public void openPages(){
        logger.info("OPEN page");
       functionsOfShopping.openPage();
    }
    @AfterMethod
    public void ClosePages(){
        logger.info("OPEN page");
    }
    @AfterClass
    public void closePage(){
        logger.info("CLOSING page");
        driver.quit();
    }
    @DataProvider(name="alreadyRegistratedUser")
    public Object[][] dataUser() {
        return new Object[][]{
                {"Ганна","nuta0403@ukr.net","958656666","0000000"}
        };
    }


}

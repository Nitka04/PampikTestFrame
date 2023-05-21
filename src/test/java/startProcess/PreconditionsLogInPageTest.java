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
import pages.BasePage;
import pages.LogInPage;


public class PreconditionsLogInPageTest {
    static final Logger logger= LoggerFactory.getLogger(PreconditionsMainPageTest.class);
    protected WebDriver driver= DriverBase.startChromeDriver();
    protected BasePage basePage=new BasePage(driver);
    protected Action action=new Action(driver);
    protected Assertions assertions=new Assertions(driver);
    protected Elements elements=new Elements(driver);
    protected Waiters waiters=new Waiters(driver);
    protected LogInPage logInPage =new LogInPage(driver);
    @BeforeMethod //скоріш за все потрібен @BeforeClass
    public void openPages(){
        logger.info("OPEN page");
        logInPage.openPage();
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


}

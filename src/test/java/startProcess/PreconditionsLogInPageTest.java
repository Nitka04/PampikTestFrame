package startProcess;

import driver.DriverBase;
import functions.Action;
import functions.Assertions;
import functions.Elements;
import functions.Waiters;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import pages.BasePage;
import pages.LogInPage;


public class PreconditionsLogInPageTest {
    protected WebDriver driver= DriverBase.startChromeDriver();
    protected LogInPage logInPage =new LogInPage(driver);
   protected Action action=new Action(driver);
    protected Assertions assertions=new Assertions(driver);
    protected Elements elements=new Elements(driver);
    protected Waiters waiters=new Waiters(driver);
    Logger logger= LoggerFactory.getLogger(PreconditionsMainPageTest.class);
    @BeforeMethod
    public void openPages(){
        LogInPage logInPage =new LogInPage(driver);
        logger.info("OPEN page");
        logInPage.openPage();
    }
    @AfterGroups("logOut")
    public  void logOut(){
        logger.info("Log Out");
        logInPage.logOut();
    }

  /*  @AfterClass
    public void closePage(){
        logger.info("CLOSING page");
        driver.close();
    }*/
    @DataProvider(name="incorrectPasswordOrLogIn")
    public Object[][] PassworAndLogIn() {
        return new Object[][]{
                {"958656666","dfgsghwrt"},
                {"958656666","0"},
                {"958656666","764524"},
                {"958656666","958656666"},
                {"958656667","0000000"},
                {"978656667"," "},
                {"978656667","0000000"}
        };
    }


}

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
import pages.RegistrationPage;

public class PreconditionsRegistrationPageTest {
    static final Logger logger= LoggerFactory.getLogger(PreconditionsMainPageTest.class);
    protected WebDriver driver= DriverBase.startChromeDriver();
    protected BasePage basePage=new BasePage(driver);
    protected Action action=new Action(driver);
    protected Assertions assertions=new Assertions(driver);
    protected Elements elements=new Elements(driver);
    protected Waiters waiters=new Waiters(driver);
    protected RegistrationPage regestrationPage=new RegistrationPage(driver);
    @BeforeMethod //скоріш за все потрібен @BeforeClass
    public void openPages(){
        logger.info("OPEN page");
       regestrationPage.openPage();
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
    @DataProvider(name="1")
    public Object[][] PassworAndLogIn() {
        return new Object[][]{
                {"958656666","dfgsghwrt"},
                {"958656666","0"},
                {"958656666","764524"},
                {"958656666","958656666"},
                {"958656667","0000000"},
                {"968656667","0000000"},
                {"978656667","0000000"},
                {"978656667"," "},
                {"978656667","0000000"}
        };
    }


}

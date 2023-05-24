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
    @DataProvider(name="incorrectOrEmptyEmail")
    public Object[][] dataEmail() {
        return new Object[][]{
                {"Микола","","954356676","0000000"},
                {"Микола"," ","954356676","0000000"},
                {"Микола","1233","954356676","0000000"},
                {"Микола","ewsdd@","954356676","0000000"},
                {"Микола","ewsd\"\"d@dewef.kl","954356676","0000000"},
                {"Микола","@ukr.net","954356676","0000000"},
                {"Микола","впруап@ukr.com","954356676","0000000"}
        };
    }

}

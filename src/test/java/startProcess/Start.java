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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import pages.BasePage;
import pages.MainPage;

public class Start {
    static final Logger logger= LoggerFactory.getLogger(Start.class);
    protected WebDriver driver= DriverBase.startChromeDriver();
    protected BasePage basePage=new BasePage(driver);
    protected Action action=new Action(driver);
    protected Assertions assertions=new Assertions(driver);
    protected Elements elements=new Elements(driver);
    protected Waiters waiters=new Waiters(driver);
    protected MainPage mainPage=new MainPage(driver);

    @DataProvider(name="urlOnlineSupportCheck")
    public Object[][] createData() {
        return new Object[][]{
                {"https://telegram.me/helponlinebot?start=uBki1eoAbSgeXwox9KNm1QwvidBtl4m8PCR6-qdL6hMKtR6g"},
                {"viber://pa?chatURI=onlinesupportbot&context=uBki1eoAbSgeXwox9KNm1QwvidBtl4m8PCR6-qdL6hMKtR6g"}
        };
    }

    @BeforeClass
    public void openPages(){
        logger.info("Page open:");
        mainPage.openPage();
    }
    @AfterClass
    public void closePage(){
        logger.info("CLOSING page");
        driver.close();
    }
}

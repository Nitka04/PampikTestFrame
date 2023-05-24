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
   public void openPage(){
        logger.info("OPEN page");
        functionsOfShopping.openPage();
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
                {"//div[@data-filter-id='brand']","//div[@data-filter-id='brand']/div/following-sibling::*[1]/div[2]"},
                {"//div[@data-filter-id='option-5']/div","//div[@data-filter-id='option-5']/div/following-sibling::*[1]/div[7]"},
                {"//div[@data-filter-id='option-2']/div","//div[@data-filter-id='option-2']/div/following-sibling::*[1]/div[3]"}
        };
    }


}

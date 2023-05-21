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
import pages.MainPage;

public class PreconditionsMainPageTest {
    static final Logger logger= LoggerFactory.getLogger(PreconditionsMainPageTest.class);
    protected WebDriver driver= DriverBase.startChromeDriver();
    protected BasePage basePage=new BasePage(driver);
    protected Action action=new Action(driver);
    protected Assertions assertions=new Assertions(driver);
    protected Elements elements=new Elements(driver);
    protected Waiters waiters=new Waiters(driver);
    protected MainPage mainPage=new MainPage(driver);
    //password 0000000
    @DataProvider(name="urlOnlineSupportCheck")
    public Object[][] messendgerClickWordCheck() {
        return new Object[][]{
               {"//div[@class='dropdown-content-rngst']/a[1]","telegram.me"}/*,
               {"//div[@class='dropdown-content-rngst']/a[2]","viber"}*///в них не відкривається вікно вайберу ,тест зависає навіть не пише що не проходе
        };
    }
    @DataProvider(name="searchResults")
    public Object[][] searchResultWordCheckWorld() {
        return new Object[][]{
                {"кішка","кішка"},
                {"підгузок","підгузок"},
                {"!ложка","!ложка"},
                {"іапііп","іапііп"},
                {"8776543","8776543"},
                {"Vfif","Vfif"},
                {"     ",""},
                {" кішка","кішка"},
                {"&&&","&&&"}
        };
    }


    @DataProvider(name="xpathCityNameCheckName")
    public Object[][] xpathCityNameCheckName() {
        return new Object[][]{
                {"//a[@data-id='9787']","Київ"},
                {"//a[@data-id='17125']","Одеса"},
                {"//a[@data-id='6500']","Дніпро"},
                {"//a[@data-id='25121']","Харків"},
                {"//a[@data-id='8008']","Запоріжжя"},
                {"//a[@data-id='13242']","Львів"}
        };
    }
    //перевірити що логотип веде до оловної сторінки
    @DataProvider(name="urlPageForCheckLogo")
    public Object[][] urls() {
        return new Object[][]{
                {"https://pampik.com/ua/brand/HiPP"},
                {"https://pampik.com/ua/info"},
                {"https://pampik.com/ua/category/hodunki-i-pryigunki"},
                {"https://pampik.com/ua/category/byitovaya-himiya-i-uhod-za-domom"},
                {"https://pampik.com/ua/catalog/konstruktor-lego-classic-bolshoy-nabor-dlya-tvorchestva-790-detaley-10698"}
        };
    }

    @BeforeMethod
    public void openPages(){
        logger.info("OPEN page");
        mainPage.openPage();

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

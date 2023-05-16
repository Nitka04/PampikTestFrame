package driver;

import functions.Action;
import functions.Assertions;
import functions.Elements;
import functions.Waiters;
import org.apache.log4j.helpers.Loader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class DriverBase {
    private static final long IMPLICITY_WAIT=20L;
    static Waiters wait;
    static Action action;
    static Assertions assertions;
    static Elements elements;
    private static WebDriver driver;

    static final Logger logger=LoggerFactory.getLogger(DriverBase.class);

    private static WebDriver sutUpDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        wait = new Waiters(driver);
        action= new Action(driver);
        assertions=new Assertions(driver);
        elements = new Elements(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT, TimeUnit.SECONDS);
        return driver;
    }
    public static WebDriver getInstane(){
        if(driver==null){
            try {
                driver=sutUpDriver();
                logger.info("Driver started");
            }catch(Exception e){
                e.printStackTrace();
            }
        }return driver;
    }
    public static  WebDriver startChromeDriver(){
        driver=getInstane();
        return driver;
    }

}

package pages;

import functions.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class FunctionsOfShopping extends BasePage{
    Waiters waiters=new Waiters(driver);
    static final Logger logger = LoggerFactory.getLogger(FunctionsOfShopping.class);
    protected LogInPage logInPage =new LogInPage(driver);
    protected MainPage mainPage=new MainPage(driver);
    public FunctionsOfShopping(WebDriver driver) {super(driver);}

    private static class Locators {
         private static By filterSelector=By.xpath("//a[@class='sorter__trigger']");
        private static By sortingSelectorCheckText =By.xpath("//a[@class='sorter__trigger']/span");
         private static By SelectorOfGrowingPrice=By.xpath("//ul[@class='sorter__list sorter-list']/li[2]");
         private static By clickerProduct1=By.xpath("//li[@class='listing__item'][1]/div/a");
        private static By clickerProduct2=By.xpath("//li[@class='listing__item'][2]/div/a");
        private static By clickerProduct10=By.xpath("//li[@class='listing__item'][10]/div/a");
        private static By clickerProduct20=By.xpath("//li[@class='listing__item'][19]/div/a");
        private static By priceOfProduct=By.xpath("//div[@class='product-info__price-current']/span");
//Фильтры по категориям/подкатегориям
        private static By checkResultOfFilterText=By.xpath("//div[@id='filter-result']");
        private static By buttonShowTheresultOfFilter=By.xpath("//button[@class='cst-btn category-filter__push']");
//addFaivorite
        private static By addFavorite=By.xpath("//div[@class='wishlist-container']/a/span");
        private static By buttonDodati=By.xpath("//form[@id='wishlist_add_form']/button");
        private static By allFavoriteList=By.xpath("//span[@class='icon icon-d-heaet fave-link__icon']");
        private static By listofAddedFavoritre=By.xpath("//ul[@class='listing tile-view new-listing']");
        private static By crossDeleteItemFavoritre =By.xpath("//button[@class='close remove-item']");

    }
    public static class Labels{
        private final static String url ="https://pampik.com/ua/category/odnorazovyie-podguzniki";
        private final static String checkOfApplyingFilter="ціною за зростанням";
        public static By resetEverything=By.xpath("//a[@class='filter-delete-all']");

    }

    public void  openPage(){
        logger.info(Labels.url);
        driver.get(Labels.url);}

    public void clickOnSorterList(){
        elements.clickElement(Locators.filterSelector);
    }
    public void chooseParametersFilterList() throws InterruptedException {
        clickOnSorterList();
        elements.clickElement(Locators.SelectorOfGrowingPrice);
       Thread.sleep(5000);
        elements.getElementTextWaitReturn(Locators.sortingSelectorCheckText,Labels.checkOfApplyingFilter);
    }

    public boolean getPriceFromProductElement() throws InterruptedException {
        Double massivOpPrices []=new Double[4];
        Set<String> set1 = driver.getWindowHandles();
        String descr1 = set1.iterator().next();
        waiters.waitForElementToBeClickable(Locators.clickerProduct1);
        action.openPageInNewWindow(Locators.clickerProduct1);
        Set<String> set2 = driver.getWindowHandles();
        set2.removeAll(set1);
        String descr2 = set2.iterator().next();
        driver.switchTo().window(descr2);
        String gettext= elements.getElementText(Locators.priceOfProduct);
        Double price=Double.parseDouble(gettext);
        massivOpPrices[0]=Double.parseDouble(gettext);
        driver.close();
        driver.switchTo().window(descr1);
        wait.waitForElementToBeClickableReturn(Locators.clickerProduct2);
        action.openPageInNewWindow(Locators.clickerProduct2);
        Set<String> set3=driver.getWindowHandles();
        set3.removeAll(set1);
        String descr3=set3.iterator().next();
        driver.switchTo().window(descr3);
        String gettext2= elements.getElementText(Locators.priceOfProduct);
        Double price2=Double.parseDouble(gettext2);
        massivOpPrices[1]=price2;
        driver.close();
        driver.switchTo().window(descr1);
        wait.waitForElementToBeClickable(Locators.clickerProduct10);
        action.openPageInNewWindow(Locators.clickerProduct10);
        Set<String> set4=driver.getWindowHandles();
        set4.removeAll(set1);
        String descr4=set4.iterator().next();
        driver.switchTo().window(descr4);
        String gettext3= elements.getElementText(Locators.priceOfProduct);
        Double price3=Double.parseDouble(gettext3);
        massivOpPrices[2]=price3;
        driver.close();
        driver.switchTo().window(descr1);
        wait.waitForElementToBeClickable(Locators.clickerProduct20);
        action.openPageInNewWindow(Locators.clickerProduct20);
        Set<String> set5=driver.getWindowHandles();
        set5.removeAll(set1);
        String descr5=set5.iterator().next();
        driver.switchTo().window(descr5);
        String gettext4= elements.getElementText(Locators.priceOfProduct);
        Double price4=Double.parseDouble(gettext4);
        massivOpPrices[3]=price4;
        driver.close();
        driver.switchTo().window(descr1);
        if(Double.compare(massivOpPrices[0], massivOpPrices[1])==0||
                Double.compare(massivOpPrices[0], massivOpPrices[1])<0){
            if(Double.compare(massivOpPrices[1], massivOpPrices[2])==0||
            Double.compare(massivOpPrices[1], massivOpPrices[2])<0){
                if (Double.compare(massivOpPrices[2], massivOpPrices[3])==0||
                        Double.compare(massivOpPrices[2], massivOpPrices[3])<0){
                    return true;
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    public String getTextFromFiltrChoise(String labelXpath){
        WebElement textfromFiltr=elements.findElementByXpath(labelXpath);
        String textfromWeb = textfromFiltr.getText();
        int index=textfromWeb.indexOf(' ');
        String finalTextfromFiltr=textfromWeb.substring(0,index-1);
        return finalTextfromFiltr;
    }
    public String filterSelectorCheckText(){
        waiters.waitFortextToBePresentInElementValue(Locators.checkResultOfFilterText, "ВИБРАЛИ");
        waiters.waitForElementToBeClickable(By.xpath("//div[@id='filter-result']/a"));
        String text=elements.getElementText(Locators.checkResultOfFilterText);
        return text;
    }
    public void ResultfiltrClickerText(String xpathTitle,String labelXpath) {
        waiters.waitForElementToBeClickable(By.xpath(xpathTitle));
        elements.clickElementByXpath(xpathTitle);
        waiters.waitForElementToBeClickable(By.xpath(labelXpath));
        elements.clickElementByXpath(labelXpath);
        wait.waitForVisabilityOfElement(Locators.buttonShowTheresultOfFilter);
        elements.clickElement(Locators.buttonShowTheresultOfFilter);
        waiters.waitForElementToBeClickable(By.xpath("//div[@id='filter-result']/a"));
    }
    public void resetFiltr(){
        waiters.waitForElementToBeClickable(Labels.resetEverything);
        elements.clickElement(Labels.resetEverything);

    }
    public void logIn() throws InterruptedException {
        driver.get(LogInPage.Labels.urlConfirmationToLoggedUser);
        logInPage.inputPassword("0000000");
        logInPage.inputTelephone("958656666");
        logInPage.pressButtonUVIYTI();
        Thread.sleep(2000);
    }
    public void searchAddToFavorite(String searchWord) throws InterruptedException {
        mainPage.SearchResult(searchWord);
        Set<String> set1 = driver.getWindowHandles();
        String descr1 = set1.iterator().next();
        action.openPageInNewWindow(Locators.clickerProduct2);
        Set<String> set2 = driver.getWindowHandles();
        set2.removeAll(set1);
        String descr2 = set2.iterator().next();
        driver.switchTo().window(descr2);
        waiters.waitForElementToBeClickable(Locators.addFavorite);
        elements.clickElement(Locators.addFavorite);
        elements.clickElement(Locators.buttonDodati);
        driver.close();
        driver.switchTo().window(descr1);
    }
    public void openListOfFavorite(){
        waiters.waitForElementToBeClickable(Locators.allFavoriteList);
        elements.clickElement(Locators.allFavoriteList);
    }
    public String getTextFavoriteList(){
        String text=elements.getElementText(Locators.listofAddedFavoritre);
        return text;
    }

    public void clearTheListOfFavorite() throws InterruptedException {
        waiters.waitForElementToBeClickable(Locators.crossDeleteItemFavoritre);
        elements.clickElement(Locators.crossDeleteItemFavoritre);
        Thread.sleep(2000);
        waiters.waitForElementToBeClickable(Locators.crossDeleteItemFavoritre);
        elements.clickElement(Locators.crossDeleteItemFavoritre);
        Thread.sleep(2000);

    }
}

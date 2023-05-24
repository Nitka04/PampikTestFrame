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
        System.out.println(finalTextfromFiltr +"@@@@@@@@@@@@");
        return finalTextfromFiltr;
    }
    public String filterSelectorCheckText(){
        waiters.waitFortextToBePresentInElementValue(Locators.checkResultOfFilterText, "ВИБРАЛИ");
        System.out.println(elements.getElementText(Locators.checkResultOfFilterText)+"#############");
        return elements.getElementText(Locators.checkResultOfFilterText);
    }
    public void ResultfiltrClickerText(String xpathTitle,String labelXpath) {
        waiters.waitForElementToBeClickableReturn(By.xpath(xpathTitle));
        elements.clickElementByXpath(xpathTitle);
        waiters.waitForElementToBeClickable(By.xpath(labelXpath));
        elements.clickElementByXpath(labelXpath);
        wait.waitForVisabilityOfElement(Locators.buttonShowTheresultOfFilter);
        elements.clickElement(Locators.buttonShowTheresultOfFilter);
        waiters.waitForElementToBeClickable(Labels.resetEverything);

    }
}

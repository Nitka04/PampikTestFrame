import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;
import pages.FunctionsOfShopping;
import pages.LogInPage;
import pages.RegistrationPage;
import startProcess.PreconditionsFunctionsOfShopping;

public class FunctionsOfShoppingTests extends PreconditionsFunctionsOfShopping {
    static final Logger logger= LoggerFactory.getLogger(FunctionsOfShoppingTests.class);

    @Test
    public void filterForeIncreasePriceTest() throws InterruptedException {
        functionsOfShopping.chooseParametersFilterList();
        logger.info("Checking the functionality of The filter of the Increase Price.");
        assertions.realizationOfConditionTrue( functionsOfShopping.getPriceFromProductElement(),
                "The filter of the Increase Price work incorrectly.");
    }
    @Test(dataProvider = "FilterBoxTitle&LabelXpath")
    public void filter(String xpathTitle,String labelXpath) {
        functionsOfShopping.ResultfiltrClickerText(xpathTitle,labelXpath);
       assertions.containsSomeText(functionsOfShopping.filterSelectorCheckText(),
               functionsOfShopping.getTextFromFiltrChoise(labelXpath));
       waiters.waitForElementToBeClickable(FunctionsOfShopping.Labels.resetEverything);
    }

    @Test(dataProvider = "AddToFavorite")
    public void addFavirots(String searchWord) throws InterruptedException {
        functionsOfShopping.searchAddToFavorite(searchWord);
        functionsOfShopping.openListOfFavorite();
        System.out.println(functionsOfShopping.getTextFavoriteList()+"###########");
        assertions.containsSomeText(functionsOfShopping.getTextFavoriteList().toLowerCase(),searchWord.toLowerCase());

    }

}

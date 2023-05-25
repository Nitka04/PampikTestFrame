import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import pages.FunctionsOfShopping;
import startProcess.PreconditionsFunctionsOfShopping;

public class FunctionsOfShoppingTests extends PreconditionsFunctionsOfShopping {
    static final Logger logger= LoggerFactory.getLogger(FunctionsOfShoppingTests.class);

    @Test(priority = 1)
    public void sorterForeIncreasePriceTest() throws InterruptedException {
        functionsOfShopping.chooseParametersFilterList();
        logger.info("Checking the functionality of The filter of the Increase Price.");
        assertions.realizationOfConditionTrue( functionsOfShopping.getPriceFromProductElement(),
                "The filter of the Increase Price work incorrectly.");
    }
    @Test(priority = 2,
            dataProvider = "FilterBoxTitle&LabelXpath")
    public void filterTest(String xpathTitle,String labelXpath) {
        functionsOfShopping.ResultfiltrClickerText(xpathTitle,labelXpath);
       assertions.containsSomeText(functionsOfShopping.filterSelectorCheckText(),
              functionsOfShopping.getTextFromFiltrChoise(labelXpath));
       waiters.waitForElementToBeClickable(FunctionsOfShopping.Labels.resetEverything);
       functionsOfShopping.resetFiltr();
    }

    @Test(priority = 3,
            dataProvider = "AddToFavorite",
    groups = "ClearTheListOfFavorite")
    public void addFavoritesTest(String searchWordInterestedProduct) throws InterruptedException {
        functionsOfShopping.searchAddToFavorite(searchWordInterestedProduct);
        functionsOfShopping.openListOfFavorite();
        assertions.containsSomeText(functionsOfShopping.getTextFavoriteList().toLowerCase(), searchWordInterestedProduct.toLowerCase());
    }

}

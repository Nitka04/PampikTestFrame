import org.testng.annotations.Test;
import pages.MainPage;
import startProcess.Preconditions;

import static org.testng.Assert.assertTrue;

public class MainPageTests extends Preconditions {
       @Test
       public void TestOfBackCallConformation() throws InterruptedException {
           assertions.equalsOfText(mainPage.CallMeBackGetText("99 999 99 999"), MainPage.Labels.ConformationText);

       }

       @Test(dataProvider = "urlOnlineSupportCheck")
    public void TestOfMessengerUrl(String xpath,String urlOnlineSupportCheck) throws InterruptedException {
            assertions.containsSomeText(mainPage.getUrlFromOpenWindow(xpath),urlOnlineSupportCheck);
       }

      @Test(dataProvider = "searchResults")
      public void TestofSearchResults(String searchWord, String expectedWord) throws InterruptedException {
           mainPage.checkOfSearchResult(searchWord);
          // if(waiters.waitForVisabilityOfElement(mainPage.);)
          if (mainPage.getTextPositiveSeach(searchWord).contains(expectedWord)) {
              assertions.containsSomeText(mainPage.getTextPositiveSeach(searchWord),expectedWord);
          } else {
              if (mainPage.getTextNegativeSeach(searchWord).contains(expectedWord)) {
                  assertions.containsSomeText(mainPage.getTextNegativeSeach(searchWord),expectedWord);
              }
          }
      }
}

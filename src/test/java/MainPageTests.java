import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import pages.MainPage;
import startProcess.PreconditionsMainPageTest;

import static org.testng.Assert.assertTrue;

public class MainPageTests extends PreconditionsMainPageTest {
       @Test//WORKING
       public void TestOfBackCallConformation() throws InterruptedException {
           assertions.containsSomeText(mainPage.CallMeBackGetText("99 999 99 999"), MainPage.Labels.ConformationText);
       }

       //не работающий тест после обновления исчезла кнопка онлаин связи через мессенджер
       @Test(dataProvider = "urlOnlineSupportCheck")//WORKING
    public void TestOfMessengerUrl(String xpath,String urlOnlineSupportCheck) throws InterruptedException {
           assertions.containsSomeText( mainPage.getUrlFromOpenWindow(xpath),urlOnlineSupportCheck);
       }

      @Test(dataProvider = "searchResults")//WORKING
      public void TestofSearchResults(String searchWord, String expectedWord) throws InterruptedException, NoSuchElementException {
           mainPage.SearchResult(searchWord);
          if (mainPage.getTextPositiveSeach(searchWord).contains(expectedWord)) {
              assertions.containsSomeText(mainPage.getTextPositiveSeach(searchWord),expectedWord);
          } else {
              if (mainPage.getTextNegativeSeach(searchWord).contains(expectedWord)) {
                  assertions.containsSomeText(mainPage.getTextNegativeSeach(searchWord),expectedWord);
              }
          }
      }
      @Test(dataProvider = "xpathCityNameCheckName")//WORKING
      public void checkCityNameTest(String xpathCityName,String cityName) throws InterruptedException {
      mainPage.clickOnCity(xpathCityName);
          assertions.equalsOfText(mainPage.getCityName(cityName),cityName );
      }

      @Test(dataProvider = "urlPageForCheckLogo")//WORKING
      public void checkClickToMainLogoGoToMainPage(String url) throws InterruptedException {
           mainPage.gotoAnotherUrlPageAndClickLogo(url);
           assertions.equalsOfUrl(mainPage.getUrlFromCurrantPage(),"https://pampik.com/ua");
      }

}

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import pages.MainPage;
import startProcess.PreconditionsMainPageTest;

import static org.testng.Assert.assertTrue;

public class MainPageTests extends PreconditionsMainPageTest {
       @Test//WORKING
       public void TestOfBackCallConformation() throws InterruptedException {
           assertions.equalsOfText(mainPage.CallMeBackGetText("99 999 99 999"), MainPage.Labels.ConformationText);

       }


//ДАнній тест не відает негативній результат. На сайте кнпка связи повайбер не работает,и відает пустую страницу
//и на данном єтапе тест и зависает ни негатива ни позитива просто висит.
       @Test(dataProvider = "urlOnlineSupportCheck")
    public void TestOfMessengerUrl(String xpath,String urlOnlineSupportCheck) throws InterruptedException {
           assertions.containsSomeText( mainPage.getUrlFromOpenWindow(xpath),urlOnlineSupportCheck);
       }

//и данній тест не работает хотя сделан по примеру домашней роботе по хомке. При отсутсвии в первом окне резульата
//он не переходит на второй єлемент поиска(не прорабатівает else)
//суть такая если введена "ересть": то должен пройти ассер по другой ссілке  и єто так же будет прохождение теста
      @Test(dataProvider = "searchResults")
      public void TestofSearchResults(String searchWord, String expectedWord) throws InterruptedException, NoSuchElementException {
           mainPage.checkOfSearchResult(searchWord);
          if (mainPage.getTextPositiveSeach(searchWord).contains(expectedWord)) {
              assertions.containsSomeText(mainPage.getTextPositiveSeach(searchWord),expectedWord);
          } else {
              if (mainPage.getTextNegativeSeach(searchWord).contains(expectedWord)) {
                  assertions.containsSomeText(mainPage.getTextNegativeSeach(searchWord),expectedWord);
              }
          }

          //а єто поппітка его переписать то же не работает через драйвер тоже не работает,  если негативній поиск висит
        /*  WebElement positiveSeachText=driver.findElement(MainPage.Labels.positiveSeachText);

         if(positiveSeachText.isDisplayed()==true){
         System.out.println("WORK   !!!!!!!!!!!!!!!!!!!!!!");
     }else {
        System.out.println("не видно  !!!!!!!!!!!!!!!!!!!!!!");
    }*/
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

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.MainPage;
import startProcess.Preconditions;

import static org.testng.Assert.assertTrue;

public class MainPageTests extends Preconditions {
       @Test
       public void TestOfBackCallConformation() throws InterruptedException {
           assertions.equalsOfText(mainPage.CallMeBackGetText("99 999 99 999"), MainPage.Labels.ConformationText);

       }


       //ДАнній тест не відает негативній результат
       @Test(dataProvider = "urlOnlineSupportCheck")
    public void TestOfMessengerUrl(String xpath,String urlOnlineSupportCheck) throws InterruptedException {
           mainPage.getUrlFromOpenWindow(xpath);
            assertions.containsSomeText(mainPage.getUrlFromOpenWindow(xpath),urlOnlineSupportCheck);
       }


       //и данній тест не работает хотя сделан по примеру домашней роботе по хомке
    //суть такая если введена "ересть": то должен пройти ассер по другой ссілке  и єто так же будет прохождение теста. А он не переходит на else
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
}

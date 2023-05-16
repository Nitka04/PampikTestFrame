package startProcess;

import org.testng.annotations.Test;
import pages.MainPage;

import java.awt.*;

public class MainPageTests extends Start{
       @Test
       public void TestOfBackCallConformation() throws InterruptedException {
           assertions.equalsOfText(mainPage.CallMeBackGetText("99 999 99 999"), MainPage.Labels.ConformationText);

       }

       @Test(dataProvider = "urlOnlineSupportCheck")
    public void TestOfMessengerUrl(String urlOnlineSupportCheck){
            mainPage.getUrlFromOpenWindow();

       }


}

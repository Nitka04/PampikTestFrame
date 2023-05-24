import functions.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LogInPage;
import startProcess.PreconditionsLogInPageTest;

public class LogInPageTests extends PreconditionsLogInPageTest {
    @Test
    public void logInInputCorrectInformationTest() throws InterruptedException {
        logInPage.inputPassword("0000000");
        logInPage.inputTelephone("958656666");
          logInPage.pressButtonUVIYTI();
        Thread.sleep(2000);
        assertions.equalsOfUrl(logInPage.getCurrentUrl(), LogInPage.Labels.urlConfirmationToLoggedUser);
    }
    @Test(dataProvider = "incorrectPasswordOrLogIn")
    public void logInInputIncorrectInformationsTest(String telephone,String pasword) throws InterruptedException {
        logInPage.inputPassword(pasword);
        logInPage.inputTelephone(telephone);
        logInPage.pressButtonUVIYTI();
        Thread.sleep(1000);
        assertions.equalsOfText(logInPage.getTextOfError(),LogInPage.Labels.conformationTextOfWrongInputData);
    }
    @Test
    public void leaveEmptyInPutOfTelephonTest() throws InterruptedException {
        logInPage.inputPassword("09878");
        logInPage.inputTelephone("");
        logInPage.pressButtonUVIYTI();
        Thread.sleep(1000);
        assertions.equalsOfText(logInPage.getTextOfError(),LogInPage.Labels.conformationTextOfEmptyInputData);
    }
}

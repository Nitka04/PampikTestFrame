import org.testng.annotations.Test;
import startProcess.PreconditionsLogInPageTest;

public class LogInTests extends PreconditionsLogInPageTest {

    @Test
    public void logInInputCorrectInformationTest(){
        logInPage.inputTelephone("0958656666");

    }
}

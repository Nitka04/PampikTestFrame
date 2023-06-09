import org.testng.annotations.Test;
import pages.RegistrationPage;
import startProcess.PreconditionsRegistrationPageTest;

public class RegistrationPageTest extends PreconditionsRegistrationPageTest {
    //Пользователь с данными существует в системе.
    @Test(priority=1,dataProvider ="alreadyRegistratedUser")
    public void RegistrationOfAlreadyRegistratedUseredTest(String name,String email,String phoneNumber,String password) throws InterruptedException {
        regestrationPage.inputAllData(name,email,phoneNumber,password);
        regestrationPage.clickRegistrationConfirmButton();
        assertions.equalsOfText(regestrationPage.getTextOfError(RegistrationPage.Labels.ErrorMessagePhoneNumber),
                RegistrationPage.Labels.AlreadyRegistratedUser);
    }
    @Test(priority = 2)
    public void RegistrationEmptyNameTest() throws InterruptedException {
         regestrationPage.inputAllData("","nhuyyfg@ukr.net","9768564133","0000000");
         regestrationPage.clickRegistrationConfirmButton();
         assertions.containsSomeText(regestrationPage.getTextOfError(RegistrationPage.Labels.ErrorMessageName), RegistrationPage.Labels.ErrorEmptyName);
    }
    @Test(priority = 3,
            dataProvider = "incorrectOrEmptyEmail")
    public void IncorrectMailNameTest(String name,String email,String phoneNumber,String password) throws InterruptedException {
        regestrationPage.inputAllData(name,email,phoneNumber,password);
        regestrationPage.clickRegistrationConfirmButton();
        assertions.containsSomeText(regestrationPage.getTextOfError(RegistrationPage.Labels.ErrorMessageEmail), RegistrationPage.Labels.IncorrectMail);
    }
    @Test(priority =4)
    public void CheckBoxIsSelectedTest() throws InterruptedException {
        regestrationPage.clickCheckBoxZgodaPersonalData();
        regestrationPage.clickRegistrationConfirmButton();
        assertions.equalsOfText(driver.findElement(RegistrationPage.Labels.ErrorMessageCheckBox).getText(), "");
    }

}

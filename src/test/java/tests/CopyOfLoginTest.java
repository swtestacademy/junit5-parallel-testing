package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.HomePage;

@Execution(ExecutionMode.CONCURRENT)
public class CopyOfLoginTest extends BaseTest {
    @Test
    public void invalidLoginTest_InvalidUserNameInvalidPassword2 () {
        page.getPage(HomePage.class)
                .GivenIAmAtHomePage()
                .WhenIGoToLoginPage()
                .AndIloginToN11("onur@swtestacademy.com", "11223344")
                .ThenIVerifyPasswordErrorMessage(("E-posta adresiniz veya şifreniz hatalı"));
    }

    @Test
    public void invalidLoginTest_EmptyUserEmptyPassword2 () {
        page.getPage(HomePage.class)
                .GivenIAmAtHomePage()
                .WhenIGoToLoginPage()
                .AndIloginToN11("","")
                .ThenIVerifyLoginUserNameErrorMessage("Lütfen e-posta adresinizi girin.")
                .ThenIVerifyPasswordErrorMessage("Bu alanın doldurulması zorunludur.");
    }
}

package tests.SignIn;

import org.testng.annotations.Test;
import testCore.TestCore;
import сonstants.Credentials;
import сonstants.Urls;


public class Test_0001_SignIn extends TestCore {


    @Test(description = "Sign in into system")
    public void loginIntoCasino() {
        openURL(Urls.CASINO_LOGIN_URL);

        loginPage.checkCurrentUrl(Urls.CASINO_LOGIN_URL)
                .checkMainLogoIsAppears()
                .enterLoginIntoLoginField()
                .enterPasswordIntoPasswordField()
                .clickSignInButton();

        mainPage.checkUserNameInHeader(Credentials.LOGIN_VALUE_INTO_CASINO)
                .checkCurrentUrl(Urls.HOME_PAGE_URL);
    }
}

package tests.SignIn;

import org.testng.annotations.Test;
import testCore.TestCore;
import сonstants.Credentials;
import сonstants.Urls;


public class Test_0002_CheckPlayersTable extends TestCore {


    @Test(description = "Check players table appear in")
    public void checkPlayerTableAppears() {
        openURL(Urls.CASINO_LOGIN_URL);

        loginPage.checkCurrentUrl(Urls.CASINO_LOGIN_URL)
                .checkMainLogoIsAppears()
                .enterLoginIntoLoginField()
                .enterPasswordIntoPasswordField()
                .clickSignInButton();

        mainPage.checkUserNameInHeader(Credentials.LOGIN_VALUE_INTO_CASINO).
                checkCurrentUrl(Urls.HOME_PAGE_URL).
                moveToPlayerPage();

        playersPage.checkPlayersTableAppears()
                .checkPlayersTablesTittlesAppears()
                .checkUsersQuantityInOnePageByDefault();
    }
}

package tests.SignIn;

import org.testng.annotations.Test;
import testCore.TestCore;
import сonstants.Credentials;
import сonstants.Urls;

public class Test_0003_CheckRegistrationDateByDesc extends TestCore {


    @Test(description = "Check players table Registration Date can sorts buy Desc")
    public void checkRegistrationDateSortedByDesc() throws InterruptedException {
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
                .checkUsersQuantityInOnePageByDefault()
                .sortRegistrationDateByDesc()
                .driverSleep(1000)
                .checkRegistrationDateIsDesc();
    }
}

package testCore;

import coreProject.CoreProject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.page.PlayersPage;
import pages.page.loginPage.LoginPage;
import pages.page.mainPage.MainPage;
import java.time.Duration;


public class TestCore {

    protected WebDriver driver = CoreProject.createDriver();

    public LoginPage loginPage = new LoginPage(driver);
    public MainPage mainPage = new MainPage(driver);
    public PlayersPage playersPage = new PlayersPage(driver);


    public void openURL(String url) {
        driver.get(url);
    }


    @BeforeTest
    public void setWindowMaximize() {
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
    }


    @AfterTest
    public void quiteDriver() {
        driver.quit();
    }

}

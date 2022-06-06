package pages.page.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.pageCore.PageCore;
import сonstants.Credentials;


public class LoginPage extends PageCore<LoginPage> {

    public String casinoLogoText = "Casino";
    private final By loginField = By.xpath("//input[@class='form-control' and @placeholder ='Login']");
    private final By passwordField = By.xpath("//input[@class='form-control' and @placeholder ='Password']");
    private final By signInButton = By.xpath("//input[@class='btn btn-primary btn-lg btn-block']");
    private final By casinoLogo = By.xpath("//a[text() ='Casino']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public LoginPage enterLoginIntoLoginField() {
        driver.findElement(explicitWaitOfElement(loginField, 5)).
                sendKeys(Credentials.LOGIN_VALUE_INTO_CASINO);
        return this;
    }


    public LoginPage enterPasswordIntoPasswordField() {
        driver.findElement(explicitWaitOfElement(passwordField, 5)).
                sendKeys(Credentials.PASSWORD_VALUE_INTO_CASINO);
        return this;
    }


    public LoginPage clickSignInButton() {
        driver.findElement(signInButton).click();
        return this;
    }


    public LoginPage checkMainLogoIsAppears() {
        Assert.assertEquals(casinoLogoText, driver.findElement(casinoLogo).getText().trim());
        return this;
    }


    @Override
    protected LoginPage self() {
        return this;
    }
}

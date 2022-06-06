package pages.page.mainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.pageCore.PageCore;


public class MainPage extends PageCore<MainPage> {

    private final static By userNameInHeader = By.xpath("//a[@href ='#' and @class='dropdown-toggle']//span");
    private final static By playersOnlineHeaderIcon = By.xpath("//div[@class='col-lg-3 col-xsm-6']//a[@href='/user/player/admin']");


    public MainPage(WebDriver driver) {
        super(driver);
    }


    public MainPage checkUserNameInHeader(String userName) {
        Assert.assertEquals(driver.findElement(userNameInHeader).getText().trim(), userName);
        return this;
    }


    public MainPage moveToPlayerPage(){
        driver.findElement(explicitWaitOfElement(playersOnlineHeaderIcon,2)).click();
        return this;
    }


    @Override
    protected MainPage self() {
        return this;
    }

}

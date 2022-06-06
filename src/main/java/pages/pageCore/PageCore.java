package pages.pageCore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;


public abstract class PageCore<T extends PageCore<T>> {

    protected WebDriver driver;


    public PageCore(WebDriver driver) {
        this.driver = driver;
    }


    public T checkCurrentUrl(String expectedURL) {
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        return self();
    }


    public By implicitWaitOfElement(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.presenceOfElementLocated(locator));
        return locator;
    }


    public By explicitWaitOfElement(By locator, long duration) {
        new WebDriverWait(driver, Duration.ofSeconds(duration)).
                until(ExpectedConditions.presenceOfElementLocated(locator));
        return locator;
    }


    /**
     * This method make sleep thread specified number of mills.
     * @param mills
     * @return self object.
     * @throws InterruptedException
     */
    public T driverSleep(long mills) throws InterruptedException {
        Thread.sleep(mills);
        return self();
    }


    /**
     * This method allow returning any child type.
     * @return child type object.
     */
    protected abstract T self();
}

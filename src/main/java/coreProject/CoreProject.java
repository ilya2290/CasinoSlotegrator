package coreProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CoreProject {

    public static WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

}

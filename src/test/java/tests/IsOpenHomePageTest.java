package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;


public class IsOpenHomePageTest {

    public static WebDriver driver = new ChromeDriver();
    public static String homePageUrl = "https://useinsider.com";


    @Test
    void isHomePageOpened() {
        driver.manage().window().maximize();
        driver.get(homePageUrl);

        HomePage.isPageLoaded();

        driver.quit();
    }
}

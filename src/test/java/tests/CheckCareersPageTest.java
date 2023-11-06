package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.CareersPage;


public class CheckCareersPageTest {

    public static WebDriver driver = new ChromeDriver();;

    public static String homePageUrl = "https://useinsider.com";


    /* @BeforeMethod
    @Parameters("chrome")
    public static void setup(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
    } */


    @Test
    void checkCareersPageTest() {
        driver.manage().window().maximize();
        driver.get(homePageUrl);

        CareersPage.clickCompanyDropdownBtn();
        CareersPage.clickBtnCareers();
        CareersPage.checkFindYourDreamJob();
        CareersPage.checkLblOurLocations();
        CareersPage.checkSliderLocation();
        CareersPage.checkTeams();
        CareersPage.checkLblLifeAtInsider();
        CareersPage.checkCursorLifeAtInsider();

        driver.quit();
    }

}

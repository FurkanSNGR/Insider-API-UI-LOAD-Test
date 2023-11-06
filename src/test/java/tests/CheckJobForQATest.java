package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ApplyForJobPage;
import pages.QualityAssurancePage;
import pages.FilterJobPage;


public class CheckJobForQATest {

    public static WebDriver driver = new ChromeDriver();
    public static String careersPageUrl = "https://useinsider.com/careers/quality-assurance/";


    @Test
    void isQACareersPagePageOpened () throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(careersPageUrl);

        QualityAssurancePage.isQAPageLoaded();
        QualityAssurancePage.clickBtnSeeAllQAJobs();

        FilterJobPage.clickAcceptCookies();
        FilterJobPage.clickDropLocationMenu();
        FilterJobPage.selectLocation();
        FilterJobPage.clickDepartmentMenu();
        FilterJobPage.selectDepartment();
        FilterJobPage.checkJobList();
        FilterJobPage.moveToCursorOnJob();
        FilterJobPage.clickViewRoleBtn();
        ApplyForJobPage.isApplyForJobPageLoaded();

        driver.quit();
    }
}

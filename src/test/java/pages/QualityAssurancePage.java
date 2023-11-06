package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.CheckJobForQATest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static tests.CheckJobForQATest.driver;

public class QualityAssurancePage {

    static WebDriverWait wait = new WebDriverWait(CheckJobForQATest.driver, Duration.ofSeconds(2));

    public static String btnSeeAllQAJobs = "//a[@class='btn btn-outline-secondary rounded text-medium mt-2 py-3 px-lg-5 w-100 w-md-50' and contains(text(),'See all QA jobs')]";


    public static void isQAPageLoaded() {

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnSeeAllQAJobs)));
            if (element != null) {
                System.out.println("Test Başarılı: Kariyer Alanında QA sayfası yüklendi.");
            }
        } catch (TimeoutException e) {
            System.out.println("Test Başarısız: Kariyer Alanında QA sayfası yüklenemedi");
            captureScreenshot(driver, "careers-qa-hata_alinan_adim");
            System.err.println("Hata Oluştu: " + e.getMessage());
        }
    }

    public static void clickBtnSeeAllQAJobs() {

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnSeeAllQAJobs)));
            if (element != null) {
                driver.findElement(By.xpath(btnSeeAllQAJobs)).click();
                System.out.println("Test Başarılı: See all QA jobs butonuna tıklandı.");
            }
        } catch (TimeoutException e) {
            System.out.println("Test Başarısız: See all QA jobs butonuna tıklanamadı.");
            captureScreenshot(CheckJobForQATest.driver, "allQA-jobs-butonuna-tıklanamadı");
            System.err.println("Hata Oluştu: " + e.getMessage());
        }
    }

    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(src, new File("C:/Users/gs_fu/Desktop/InsiderUITest/ScreenShot/" + screenshotName + ".png"));
            System.out.println("Ekran görüntüsü kaydedildi: " + screenshotName);
        } catch (IOException e) {
            System.err.println("Ekran görüntüsü kaydedilirken bir hata oluştu: " + e.getMessage());
        }
    }
}

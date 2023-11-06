package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.CheckJobForQATest;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;


import static tests.CheckJobForQATest.driver;

public class ApplyForJobPage {

    static WebDriverWait wait = new WebDriverWait(CheckJobForQATest.driver, Duration.ofSeconds(3));

    public static String btnApplyForThisJob = "//*[@class='postings-btn template-btn-submit shamrock' and contains(text(),'Apply for this job')]";

    public static void isApplyForJobPageLoaded() throws InterruptedException {
        String anaSekme = driver.getWindowHandle();


        Set<String> tumSekmeler = driver.getWindowHandles();

        for (String sekme : tumSekmeler) {
            if (!sekme.equals(anaSekme)) {
                driver.switchTo().window(sekme);
                break;
            }
        }

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnApplyForThisJob)));
            if (element != null) {
                System.out.println("Test Başarılı: Is basvuru sayfasi yüklendi.");
            }
        } catch (TimeoutException e) {
            System.out.println("Test Başarısız: Is basvuru sayfasi yüklenemedi");
            captureScreenshot(driver, "is-basvuru-formu-yuklenemedi");
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

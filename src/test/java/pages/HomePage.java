package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static tests.IsOpenHomePageTest.driver;

public class HomePage {

    public static String lblWhyInsiderXpath = "//*[contains(text(),'Why Insider')]";

    public static void isPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lblWhyInsiderXpath)));
            if (element != null) {
                System.out.println("Test Başarılı: Anasayfa yüklendi.");
            }
        } catch (TimeoutException e) {
            System.out.println("Test Başarısız: Anasayfa yüklenemedi");
            captureScreenshot(driver, "ana-sayfa-hata_alinan_adim");
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

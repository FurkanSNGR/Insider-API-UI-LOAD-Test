package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static tests.CheckCareersPageTest.driver;

public class CareersPage {

    public static String dropdownBtnCompany = "//a[@id='navbarDropdownMenuLink' and contains(text(),'Company')]";
    public static String dropdownBtnCareers = "//a[contains(text(),'Careers') and @class='dropdown-sub']";
    public static String btnFindYourDreamJob = "//a[@class='btn btn-info rounded mr-0 mr-md-4 py-3' and contains(text(),'Find your dream job')]";
    public static String lblOurLocations = "//h3[@class='category-title-media ml-0' and contains(text(),'Our Locations')]";
    public static String sliderLocation = "//div[@id='location-slider']";
    public static String teams = "//div[@class='col-12 d-flex flex-wrap p-0 career-load-more']";
    public static String lblLifeAtInsider = "//h2[@class='elementor-heading-title elementor-size-default' and contains(text(),'Life at Insider')]";
    public static String cursorLifeAtInsider = "//div[@class='elementor-main-swiper swiper-container swiper-container-initialized swiper-container-horizontal']";

    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    public static void clickCompanyDropdownBtn() {

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownBtnCompany)));
            if (element != null) {
                driver.findElement(By.xpath(dropdownBtnCompany)).click();
                System.out.println("Test Başarılı: Company dropdown butonuna tıklandı.");
            }
        } catch (TimeoutException e) {
            System.out.println("Test Başarısız: Company dropdown butonuna tıklanamadı.");
            captureScreenshot(driver, "company-dropdown-butonuna-tıklanamadı");
            System.err.println("Hata Oluştu: " + e.getMessage());
        }
    }

    public static void clickBtnCareers() {

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownBtnCareers)));
            if (element != null) {
                driver.findElement(By.xpath(dropdownBtnCareers)).click();
                System.out.println("Test Başarılı: Careers dropdown butonuna tıklandı.");
            }
        } catch (TimeoutException e) {
            System.out.println("Test Başarısız: Careers dropdown butonuna tıklanamadı.");
            captureScreenshot(driver, "careers-dropdown-butonuna-tıklanamadı");
            System.err.println("Hata Oluştu: " + e.getMessage());
        }
    }

    public static void checkFindYourDreamJob() {

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnFindYourDreamJob)));
            if (element != null) {
                System.out.println("Test Başarılı: Find your dream job butonu görüntülendi.");
            }
        } catch (TimeoutException e) {
            System.out.println("Test Başarısız: Find your dream job butonu görüntülenemedi.");
            captureScreenshot(driver, "find-your-dream-job-butonu-görüntülenemedi");
            System.err.println("Hata Oluştu: " + e.getMessage());
        }
    }

    public static void checkLblOurLocations() {

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lblOurLocations)));
            if (element != null) {
                System.out.println("Test Başarılı: Our Locations başlığı görüntülendi.");
            }
        } catch (TimeoutException e) {
            System.out.println("Test Başarısız: Our Locations başlığı görüntülenemedi.");
            captureScreenshot(driver, "our-locations-başlığı-görüntülenemedi");
            System.err.println("Hata Oluştu: " + e.getMessage());
        }
    }

    public static void checkSliderLocation() {

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sliderLocation)));
            if (element != null) {
                System.out.println("Test Başarılı: Slider görüntülendi.");
            }
        } catch (TimeoutException e) {
            System.out.println("Test Başarısız: Slider görüntülenemedi.");
            captureScreenshot(driver, "slider-görüntülenemedi");
            System.err.println("Hata Oluştu: " + e.getMessage());
        }
    }

    public static void checkTeams() {

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(teams)));
            if (element != null) {
                System.out.println("Test Başarılı: Teams görüntülendi.");
            }
        } catch (TimeoutException e) {
            System.out.println("Test Başarısız: Teams görüntülenemedi.");
            captureScreenshot(driver, "teams-görüntülenemedi");
            System.err.println("Hata Oluştu: " + e.getMessage());
        }
    }

    public static void checkLblLifeAtInsider() {

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lblLifeAtInsider)));
            if (element != null) {
                System.out.println("Test Başarılı: Life at Insider başlığı görüntülendi.");
            }
        } catch (TimeoutException e) {
            System.out.println("Test Başarısız: Life at Insider başlığı görüntülenemedi.");
            captureScreenshot(driver, "life-at-insider-başlığı-görüntülenemedi");
            System.err.println("Hata Oluştu: " + e.getMessage());
        }
    }

    public static void checkCursorLifeAtInsider() {

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cursorLifeAtInsider)));
            if (element != null) {
                System.out.println("Test Başarılı: Cursor görüntülendi.");
            }
        } catch (TimeoutException e) {
            System.out.println("Test Başarısız: Cursor görüntülenemedi.");
            captureScreenshot(driver, "cursor-görüntülenemedi");
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

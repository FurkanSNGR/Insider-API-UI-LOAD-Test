package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.CheckJobForQATest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static tests.CheckJobForQATest.driver;

public class FilterJobPage {

    static WebDriverWait wait = new WebDriverWait(CheckJobForQATest.driver, Duration.ofSeconds(3));

    public static String btnAcceptAllCookies = "//a[@id='wt-cli-accept-all-btn']";
    public static String dropdownFilterByLocation = "//span[@id='select2-filter-by-location-container']";
    public static String filterIstanbulTurkey = "//li[@class='select2-results__option' and contains(text(),'Istanbul, Turkey')]";
    public static String dropdownFilterByDepartment = "//span[@id='select2-filter-by-department-container']";
    public static String filterQualityAssurance = "//li[@class='select2-results__option select2-results__option--highlighted' and contains(text(),'Quality Assurance')]";
    public static String listQAJob = "//div[@id='jobs-list']/*[div]";
    public static String jobHeader = "//*[@id='jobs-list']/div[1]/div";
    public static String btnViewRole = "//*[@id='jobs-list']/div[1]/div/a";

    public static void clickAcceptCookies() {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnAcceptAllCookies)));
            if (element != null) {
                driver.findElement(By.xpath(btnAcceptAllCookies)).click();
                System.out.println("Test Başarılı: Accept all cookies butonuna tıklandı.");
            }
        } catch (TimeoutException e) {
            System.out.println("Test Başarısız: Accept all cookies butonuna tıklanamadı.");
            captureScreenshot(CheckJobForQATest.driver, "cookies-butonuna-tiklanamadi");
            System.err.println("Hata Oluştu: " + e.getMessage());
        }
    }

    public static void clickDropLocationMenu() throws InterruptedException {
        Thread.sleep(10000);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownFilterByLocation)));
            if (element != null) {
                driver.findElement(By.xpath(dropdownFilterByLocation)).click();
                System.out.println("Test Başarılı: Dropdown menüye tıklandı.");
            }
        } catch (TimeoutException e) {
            System.out.println("Test Başarısız: Dropdown menüye tıklanamadı.");
            captureScreenshot(CheckJobForQATest.driver, "dropdown-lokasyonlar-acilamadi");
            System.err.println("Hata Oluştu: " + e.getMessage());
        }
    }

    public static void selectLocation() {

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(filterIstanbulTurkey)));
            if (element != null) {
                driver.findElement(By.xpath(filterIstanbulTurkey)).click();
                System.out.println("Test Basarili: Lokasyon Istanbul Secildi.");
            }
        } catch (TimeoutException e) {
            System.out.println("Test Basarisiz: Lokasyon Istanbul Secilemedi.");
            captureScreenshot(CheckJobForQATest.driver, "lokasyon-istanbul-secilemedi");
            System.err.println("Hata Oluştu: " + e.getMessage());
        }
    }

    public static void clickDepartmentMenu() {

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownFilterByDepartment)));
            if (element != null) {
                driver.findElement(By.xpath(dropdownFilterByDepartment)).click();
                System.out.println("Test Basarili: Departmanlar Dropdown Menüsü Acildi.");
            }
        } catch (TimeoutException e) {
            System.out.println("Test Basarisiz: Departmanlar Dropdown Menüsü Acilamadi.");
            captureScreenshot(CheckJobForQATest.driver, "departmanlar-menusu-acilamadi");
            System.err.println("Hata Oluştu: " + e.getMessage());
        }
    }

    public static void selectDepartment() {

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(filterQualityAssurance)));
            if (element != null) {
                driver.findElement(By.xpath(filterQualityAssurance)).click();
                System.out.println("Test Basarili: Departman Quality Assurance Secildi.");
            }
        } catch (TimeoutException e) {
            System.out.println("Test Basarisiz: Departman Quality Assurance Secilemedi.");
            captureScreenshot(CheckJobForQATest.driver, "qa-departmani-secilemedi");
            System.err.println("Hata Oluştu: " + e.getMessage());
        }
    }

    public static void checkJobList() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> getListText = driver.findElements(By.xpath(listQAJob));
        String[] jobs = new String[getListText.size()];

        for (int i = 0; i < getListText.size(); i++) {
            jobs[i] = getListText.get(i).getText();
            String[] splitJobs = jobs[i].split("\n");

            if (splitJobs[i].contains("Quality Assurance") || splitJobs[i].contains("Istanbul, Turkey")) {
                System.out.println("Test Basarili: " + splitJobs[i] + " pozisyonu listelendi.");
            }
            else {
                System.out.println("Test Basarisiz: " + splitJobs[i] + " : Farklı pozisyon listelendi.");
                captureScreenshot(CheckJobForQATest.driver, i + "qa-pozisyonu-listelenemedi");
            }
        }
    }

    public static void moveToCursorOnJob() throws InterruptedException {
        Thread.sleep(2000);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobHeader)));
            if (element != null) {
                Actions action = new Actions(driver);
                action.moveToElement(element).build().perform();
                System.out.println("Test Basarili: Pozisyonun üzerine gelindi.");
            }
        } catch (TimeoutException e) {
            System.out.println("Test Basarisiz: Pozisyonun üzerine gelinemedi.");
            captureScreenshot(CheckJobForQATest.driver, "pozisyonun-uzerine-gelinemedi");
            System.err.println("Hata Oluştu: " + e.getMessage());
        }
    }

    public static void clickViewRoleBtn() throws InterruptedException {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnViewRole)));
            if (element != null) {
                driver.findElement(By.xpath(btnViewRole)).sendKeys(Keys.ENTER);
                System.out.println("Test Basarili: View Role butonuna tıklandı.");
            }
        } catch (TimeoutException e) {
            System.out.println("Test Basarisiz: View Role butonuna tıklanamadı.");
            captureScreenshot(CheckJobForQATest.driver, "view-role-butonuna-tiklanamadi");
            System.err.println("Hata Oluştu: " + e.getMessage());
        }
        Thread.sleep(10000);
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

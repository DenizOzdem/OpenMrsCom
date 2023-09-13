package Deniz;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;


public class US07_TC_HastaSilme {

    public static WebDriver driver; // SingletonDriver method
    public static WebDriverWait wait;

    @Test(groups={"Smoke Test"})
    public void loginTesti() {

        driver = new ChromeDriver();
        driver.get("https://demo.openmrs.org/");

        MyFunc.Bekle(2);

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("admin");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Admin123");

        WebElement locationSelect = driver.findElement(By.id("Registration Desk"));
        locationSelect.click();

        WebElement loginBtn = driver.findElement(By.id("loginButton"));
        loginBtn.click();

    }

    @Test (priority = 1,dependsOnMethods = {"loginTesti"},groups = {"Smoke Test"})
    public void HastaSilmeIsimle() {

        WebElement anasayfa=driver.findElement(By.xpath("//i[@class='icon-home small']"));
        anasayfa.click();

        WebElement loggedIn = driver.findElement(By.xpath("//h4[contains(text(),'Logged')]"));
        Assert.assertTrue(loggedIn.getText().contains("Logged in"), "Login sayfası açılmadı.");

        MyFunc.Bekle(1);
        WebElement findPatientRecord = driver.findElement(By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension"));
        findPatientRecord.click();

        MyFunc.Bekle(1);
        WebElement searchPatient = driver.findElement(By.xpath("//input[@class='form-control']"));
        searchPatient.sendKeys("Ali Turk");

        MyFunc.Bekle(1);
        WebElement noRecord = driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
        Assert.assertTrue(noRecord.getText().contains("No matching records found"), "Hasta listede var.");//Aynı şekilde to lower case hata verdiği için kaldırdım

    }


    @Test (priority = 2,groups = {"Smoke Test"})
    public void HastaSilmeId() {

        WebElement anasayfa=driver.findElement(By.xpath("//i[@class='icon-home small']"));
        anasayfa.click();

        MyFunc.Bekle(3);
        WebElement loggedIn = driver.findElement(By.xpath("//h4[contains(text(),'Logged')]"));
        Assert.assertTrue(loggedIn.getText().contains("Logged in"), "Login sayfası açılmadı.");

        MyFunc.Bekle(1);
        WebElement findPatientRecord = driver.findElement(By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension"));
        findPatientRecord.click();

        MyFunc.Bekle(1);
        WebElement searchPatient = driver.findElement(By.xpath("//input[@class='form-control']"));
        searchPatient.sendKeys("10005HJPS");

        MyFunc.Bekle(1);
        WebElement noRecord = driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
        Assert.assertTrue(noRecord.getText().contains("No matching records found"), "Hasta listede var.");

    }


    @Test (priority = 3,dataProvider = "hastaData",groups = {"Smoke Test"} )
    public void HastaSilme(String isim,String yes) {


        WebElement loggedIn = driver.findElement(By.xpath("//h4[contains(text(),'Logged')]"));
        Assert.assertTrue(loggedIn.getText().contains("Logged in"), "Login sayfası açılmadı.");


        MyFunc.Bekle(1);
        WebElement findPatientRecord = driver.findElement(By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension"));
        findPatientRecord.click();

        MyFunc.Bekle(1);
        WebElement searchPatient = driver.findElement(By.xpath("//input[@class='form-control']"));
        searchPatient.sendKeys(isim);

        MyFunc.Bekle(1);
        WebElement patient = driver.findElement(By.xpath("//*[@id=\"patient-search-results-table\"]/tbody/tr[1]/td[1]"));
        patient.click();

        MyFunc.Bekle(1);
        WebElement deleteBtn = driver.findElement(By.xpath("//ul[@class='float-left']/li[8]"));
        deleteBtn.click();

        MyFunc.Bekle(1);
        WebElement delete = driver.findElement(By.id("delete-reason"));
        delete.sendKeys(yes);

        MyFunc.Bekle(1);
        WebElement confirmBtn = driver.findElement(By.xpath("//div[@id='delete-patient-creation-dialog']//*[text()='Confirm']"));
        confirmBtn.click();

        MyFunc.Bekle(5);
        WebElement searchPatient2 = driver.findElement(By.xpath("//input[@class='form-control']"));
        searchPatient2.sendKeys(isim);

        MyFunc.Bekle(1);
        WebElement noRecord = driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
        Assert.assertTrue(noRecord.getText().contains("No matching records found"), "Hasta listede var.");

        MyFunc.Bekle(5);
        driver.quit();

    }

    @DataProvider
    Object[][] hastaData(){
        Object[][] data={{"Mehmet Turk","yes"}};
        return data;
    }

    @BeforeClass
    public void baslangicIslemleri() {
        Logger logger = Logger.getLogger(""); // output yapılan logları al.
        logger.setLevel(Level.SEVERE); // sadece ERROR ları göster

        driver = new ChromeDriver(); // jenkins deyken : sen head olmadan yani hafızada çalış
        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));  // 20 sn mühlet: elementi bulma mühleti
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://demo.openmrs.org/");

    }
    @AfterClass
    public void bitisIslemleri() { // tearDown
        MyFunc.Bekle(5);
        driver.quit();
    }

}

package OpenMrsOrg;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class OpenMrsOrg extends BaseDriver {

    @Test(dataProvider = "UserData")
    public void SistemLoginHatali(String isim, String sifre) {

        if (isim.equals("ihsan")) {

            WebElement demo = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Demo")));
            demo.click();

            WebElement explore = driver.findElement(By.xpath("(//div[@class='elementor-button-wrapper']/a)[2]"));
            explore.click();
            MyFunc.Bekle(2);

            WebElement enterMRS = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Enter the OpenMRS 2 Demo']")));
            enterMRS.click();
            MyFunc.Bekle(2);

        }

        WebElement id = driver.findElement(By.id("username"));
        id.clear();
        id.sendKeys(isim);


        WebElement pw = driver.findElement(By.id("password"));
        pw.clear();
        pw.sendKeys(sifre);


        WebElement login = driver.findElement(By.id("loginButton"));
        login.click();


        WebElement hatamsj1 = driver.findElement(By.id("sessionLocationError"));
        System.out.println("hatamsj1 = " + hatamsj1);
        Assert.assertTrue(hatamsj1.isDisplayed());


        WebElement location = driver.findElement(By.xpath("//li[@id='Registration Desk']"));
        location.click();

        WebElement login2 = driver.findElement(By.id("loginButton"));
        login2.click();

        WebElement errormsj = driver.findElement(By.xpath("//*[@id='error-message']"));

        Assert.assertTrue(errormsj.isDisplayed());


    }

    @DataProvider
    public Object[][] UserData() {
        Object[][] data = {
                {"ihsan", "122334"},
                {"sokol", "rustem5"},
                {"zeynep", "zeynep111"},
                {"serkan", "serkan500"},
                {"yasin", "kskizmir"},
                {"batuhan", "izmir35"}

        };
        return data;
    }


    @Test
    public void Login() {

        WebElement demoButton = driver.findElement(By.linkText("Demo"));
        demoButton.click();
        MyFunc.Bekle(2);

        WebElement exploreButton = driver.findElement(By.linkText("Explore OpenMRS 2"));
        exploreButton.click();
        MyFunc.Bekle(2);

        WebElement exploreDemoButton = driver.findElement(By.linkText("Enter the OpenMRS 2 Demo"));
        exploreDemoButton.click();
        MyFunc.Bekle(2);

        WebElement Inputusername = driver.findElement(By.id("username"));
        Inputusername.sendKeys("admin");
        MyFunc.Bekle(2);

        WebElement Inputpassword = driver.findElement(By.id("password"));
        Inputpassword.sendKeys("Admin123");
        MyFunc.Bekle(2);

        WebElement InPtnWrdBtn = driver.findElement(By.id("Inpatient Ward"));
        InPtnWrdBtn.click();
        MyFunc.Bekle(2);

        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
        MyFunc.Bekle(2);

    }


    @Test(dependsOnMethods = {"WebAppLogin"})
    public void Logout() {

        WebElement logOutButton = driver.findElement(By.linkText("Logout"));
        logOutButton.click();
        MyFunc.Bekle(2);

    }


    @Test
    public void HastaKaydi() {

        WebElement register= driver.findElement(By.xpath("//i[@class='icon-user']"));
        register.click();
        MyFunc.Bekle(1);
        WebElement name= driver.findElement(By.xpath("//input[@name='givenName']"));
        name.sendKeys("ayşe");
        MyFunc.Bekle(1);
        WebElement middle= driver.findElement(By.xpath("//input[@name='middleName']"));
        middle.sendKeys("fatma");
        MyFunc.Bekle(1);
        WebElement famillyName= driver.findElement(By.xpath("//input[@name='familyName']"));
        famillyName.sendKeys("hayriye");
        MyFunc.Bekle(1);
        WebElement ahead1= driver.findElement(By.xpath("//icon[@class='fas fa-chevron-right']"));
        ahead1.click();
        MyFunc.Bekle(1);
        WebElement gender= driver.findElement(By.cssSelector("select[id='gender-field']>:nth-child(1)"));
        gender.click();
        WebElement ahead2= driver.findElement(By.xpath("//icon[@class='fas fa-chevron-right']"));
        ahead2.click();
        MyFunc.Bekle(1);
        WebElement day= driver.findElement(By.xpath("//input[@id='birthdateDay-field']"));
        day.sendKeys("1");
        MyFunc.Bekle(1);
        WebElement monthSelect= driver.findElement(By.xpath("//select[@id='birthdateMonth-field']"));
        Select menuMonth=new Select(monthSelect);
        menuMonth.selectByValue("1");
        MyFunc.Bekle(1);
        WebElement year= driver.findElement(By.xpath("//input[@id='birthdateYear-field']"));
        year.sendKeys("1995");
        MyFunc.Bekle(1);
        WebElement ahead3= driver.findElement(By.xpath("//button[@id='next-button']/icon"));
        ahead3.click();
        MyFunc.Bekle(1);
        WebElement address= driver.findElement(By.xpath("//input[@id='address1']"));
        address.sendKeys("Atatürk Caddesi");
        MyFunc.Bekle(2);
        WebElement city=driver.findElement(By.xpath("//input[@id='cityVillage']"));
        city.sendKeys("Newyork");
        MyFunc.Bekle(2);
        WebElement country=driver.findElement(By.xpath("//input[@id='country']"));
        country.sendKeys("Newyork");
        MyFunc.Bekle(2);
        WebElement ahead4= driver.findElement(By.xpath("//button[@id='next-button']/icon"));
        ahead4.click();
        MyFunc.Bekle(1);
        WebElement phone=driver.findElement(By.xpath("//input[@name='phoneNumber']"));
        phone.sendKeys("5555555");
        MyFunc.Bekle(2);
        WebElement ahead5= driver.findElement(By.xpath("//button[@id='next-button']/icon"));
        ahead5.click();
        WebElement ahead6= driver.findElement(By.xpath("//button[@id='next-button']/icon"));
        ahead6.click();
        MyFunc.Bekle(1);
        WebElement confirm=driver.findElement(By.xpath("//input[@id='submit']"));
        confirm.click();
        WebElement patientName=driver.findElement(By.xpath("//h1[@class='mt-0 mb-2 name']/span"));
        Assert.assertTrue(patientName.isDisplayed());
        WebElement ID=driver.findElement(By.cssSelector("div[class='float-sm-right']>:nth-child(2)"));
        Assert.assertTrue(ID.isDisplayed());

    }


    @Test
    public void MyAccount() {

        WebElement profilIconu= driver.findElement(By.xpath("//li[@class='nav-item identifier']"));
        Actions aksiyonDriver=new Actions(driver);

        MyFunc.Bekle(2);
        aksiyonDriver.moveToElement(profilIconu).build().perform();

        MyFunc.Bekle(3);
        Assert.assertTrue(profilIconu.getText().contains("Account"),"My Account bulunamadı.");

        WebElement myAccount= driver.findElement(By.xpath("//a[@href='/openmrs/adminui/myaccount/myAccount.page']"));
        myAccount.click();

        MyFunc.Bekle(4);
        WebElement acilanSayfa= driver.findElement(By.xpath("//div[@id='tasks']"));

        Assert.assertTrue(acilanSayfa.getText().contains("Change"),"Buton görünmedi");

        MyFunc.Bekle(4);
        Assert.assertTrue(acilanSayfa.getText().contains("Languages"),"Buton görünmedi");

    }


    @Test
    public void HastaAramaP() throws AWTException {

        By bosYereTiklat=By.xpath("//div[@class='collapse navbar-collapse']");

        Robot robot=new Robot();

        WebElement hastaKayitBul=driver.findElement(By.xpath("//a[@id='coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']"));
        hastaKayitBul.click();
        MyFunc.Bekle(2);

        //isimden arama
        WebElement hastaAra= driver.findElement(By.xpath("//input[@class='form-control']"));
        hastaAra.sendKeys("Cenk"); //hasta sonradan silinmiş olabilir
        MyFunc.Bekle(3);
        WebElement acilanListe= driver.findElement(By.xpath("//table[@id='patient-search-results-table']"));
        Assert.assertTrue(acilanListe.getText().contains("Cenk"),"Aranan hasta ismi bulunamadı");

        hastaAra.clear();
        WebElement bosyereTikla= driver.findElement(bosYereTiklat);
        bosyereTikla.click();

        //soyisimden arama
        for (int i = 0; i < 4; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            MyFunc.Bekle(2);
            robot.keyRelease(KeyEvent.VK_TAB);
        }

        hastaAra.sendKeys("Tosun");//hasta sonradan silinmiş olabilir
        MyFunc.Bekle(3);
        Assert.assertTrue(acilanListe.getText().contains("Tosun"),"Aranan hasta soyismi bulunamadı");

        hastaAra.clear();
        bosyereTikla.click();
        //kimlikten arama
        for (int i = 0; i < 4; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            MyFunc.Bekle(2);
            robot.keyRelease(KeyEvent.VK_TAB);
        }

        hastaAra.sendKeys("100LXD");//hasta sonradan silinmiş olabilir
        MyFunc.Bekle(3);
        Assert.assertTrue(acilanListe.getText().contains("100LXD"),"Aranan hasta ID bulunamadı");

        hastaAra.clear();
        bosyereTikla.click();
        //hasta bilgilerini görüntüleme
        for (int i = 0; i < 4; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            MyFunc.Bekle(2);
            robot.keyRelease(KeyEvent.VK_TAB);
        }

        MyFunc.Bekle(5);
        WebElement hastaBilgisineUlasma= driver.findElement(By.xpath("//tr[@class='odd'][1]"));
        hastaBilgisineUlasma.click();
        MyFunc.Bekle(3);
        WebElement hastaBilgiListesi= driver.findElement(By.xpath("//div[@class='dashboard clear row']"));
        Assert.assertTrue(hastaBilgiListesi.getText().contains("DIAGNOSES"),"Hasta Bilgisi Görüntülenemedi.");
    }

    @Test
    public void HastaAramaN() throws AWTException {

        By bosYereTiklat=By.xpath("//div[@class='collapse navbar-collapse']");
        Robot robot=new Robot();

        WebElement hastaKayitBul=driver.findElement(By.xpath("//a[@id='coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']"));
        hastaKayitBul.click();
        MyFunc.Bekle(2);

        //isimden arama
        WebElement hastaAra= driver.findElement(By.xpath("//input[@class='form-control']"));
        hastaAra.sendKeys("Adriana"); //hasta sonradan eklenmiş olabilir
        MyFunc.Bekle(3);
        WebElement acilanListe= driver.findElement(By.xpath("//table[@id='patient-search-results-table']"));
        Assert.assertTrue(acilanListe.getText().contains("No matching records found"),"GetText bulunamadı.");

        hastaAra.clear();
        WebElement bosyereTikla= driver.findElement(bosYereTiklat);
        bosyereTikla.click();

        //soyisimden arama
        for (int i = 0; i < 4; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            MyFunc.Bekle(2);
            robot.keyRelease(KeyEvent.VK_TAB);
        }

        hastaAra.clear();
        hastaAra.sendKeys("Lima");//hasta sonradan eklenmiş olabilir
        MyFunc.Bekle(3);
        Assert.assertTrue(acilanListe.getText().contains("No matching records found"),"GetText bulunamadı.");

        bosyereTikla.click();
        //kimlikten arama
        for (int i = 0; i < 4; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            MyFunc.Bekle(2);
            robot.keyRelease(KeyEvent.VK_TAB);
        }

        hastaAra.clear();
        hastaAra.sendKeys("15781AL");//hasta sonradan eklenmiş olabilir
        MyFunc.Bekle(3);
        Assert.assertTrue(acilanListe.getText().contains("No matching records found"),"GetText bulunamadı.");

    }


    @Test
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


    @Test
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


    @Test
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


    @Test
    public void HastaListeleme() {

        JavascriptExecutor js=(JavascriptExecutor)driver;

        WebElement findPatientRecord = driver.findElement(By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension"));
        findPatientRecord.click();

        WebElement findSayfaKontrol = driver.findElement(By.xpath("//div[@id='content']/h2"));
        Assert.assertTrue(findSayfaKontrol.getText().equals("Find Patient Record"));

        int i = 0;
        int toplamhasta = 0;

        do {
            MyFunc.Bekle(2);
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

            WebElement ToplamhastaSayisi = driver.findElement(By.xpath("//div[@id='patient-search-results-table_info']"));

            String[] bosluk = ToplamhastaSayisi.getText().split(" ");
            toplamhasta = Integer.parseInt(bosluk[5]);

            List<WebElement> satirSayisi = driver.findElements(By.xpath("//tbody[@role='alert']/tr"));

            for (WebElement e : satirSayisi) {
                i++;
            }

            if(toplamhasta==i) {break;}

            MyFunc.Bekle(4);
            WebElement next = driver.findElement(By.xpath("//a[@id='patient-search-results-table_next']"));
            next.click();
        }
        while (i!=toplamhasta);


        Assert.assertTrue(i==toplamhasta);

    }

    @Test
    public void HastaKayitlariniBirlestirmeP() {

        JavascriptExecutor js=(JavascriptExecutor) driver;
        WebElement demo=driver.findElement(By.xpath("//a[@class='zak-button']"));
        demo.click();

        WebElement openMRS2=driver.findElement(By.xpath("//span[@class='elementor-button-text' and text()='Explore OpenMRS 2']"));
        js.executeScript("window.scrollBy(0, 400);");
        MyFunc.Bekle(2);
        openMRS2.click();
        MyFunc.Bekle(2);
        WebElement openMRS2Demo=driver.findElement(By.xpath("//span[@class='elementor-button-text' and text()='Enter the OpenMRS 2 Demo']"));
        openMRS2Demo.click();

        WebElement username=driver.findElement(By.id("username"));
        username.sendKeys(userName + Keys.TAB);
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys(passWord);

        WebElement registrationDesk=driver.findElement(By.xpath("//li[text()='Registration Desk']"));
        registrationDesk.click();

        WebElement loginButton=driver.findElement(By.id("loginButton"));
        loginButton.click();

        WebElement dataManagement=driver.findElement(By.xpath("//*[@id=\"coreapps-datamanagement-homepageLink-coreapps-datamanagement-homepageLink-extension\"]"));
        dataManagement.click();

        WebElement mergePatient=driver.findElement(By.xpath("//*[@id=\"coreapps-mergePatientsHomepageLink-app\"]"));
        mergePatient.click();

        WebElement id1=driver.findElement(By.xpath("//*[@id=\"patient1-text\"]"));
        id1.sendKeys("100HRU" + Keys.TAB);
        WebElement id2=driver.findElement(By.xpath("//*[@id=\"patient2-text\"]"));
        id2.sendKeys("100J27" + Keys.ENTER);

        /*WebElement continueButton=driver.findElement(By.xpath("//*[@id=\"confirm-button\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"confirm-button\"]")));
        continueButton.click();

        WebElement uyari=driver.findElement(By.xpath("//*[@id=\"content\"]/form/div[3]/h1"));
        System.out.println(uyari.getText());
        Assert.assertTrue(uyari.getText().equals("Merging cannot be undone!\nPlease check records before continuing."));

        WebElement hasta1=driver.findElement(By.xpath("//*[@id=\"second-patient\"]/div[2]/div[1]"));
        hasta1.click();

        WebElement yesContinue=driver.findElement(By.xpath("//*[@id=\"confirm-button\"]"));
        yesContinue.click();

        List<WebElement> list=driver.findElements(By.xpath("//*[@id=\"content\"]/div[6]/div[2]/div/span"));
        for (WebElement e:list) {
            if(e.getText().equals(id1)){
                System.out.println("ilk id eşleşti");
            } else if (e.getText().equals(id2)) {
                System.out.println("ikinci id eşleşti");
            }
            else
                System.out.println("id ler eşleşmedi");
        }*/

    }

    @Test
    public void HastaKayitlariniBirlestirmeN() {

        JavascriptExecutor js=(JavascriptExecutor) driver;
        WebElement demo=driver.findElement(By.xpath("//a[@class='zak-button']"));
        demo.click();

        WebElement openMRS2=driver.findElement(By.xpath("//span[@class='elementor-button-text' and text()='Explore OpenMRS 2']"));
        js.executeScript("window.scrollBy(0, 400);");
        MyFunc.Bekle(2);
        openMRS2.click();
        MyFunc.Bekle(2);
        WebElement openMRS2Demo=driver.findElement(By.xpath("//span[@class='elementor-button-text' and text()='Enter the OpenMRS 2 Demo']"));
        openMRS2Demo.click();

        WebElement username=driver.findElement(By.id("username"));
        username.sendKeys(userName + Keys.TAB);
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys(passWord);

        WebElement registrationDesk=driver.findElement(By.xpath("//li[text()='Registration Desk']"));
        registrationDesk.click();

        WebElement loginButton=driver.findElement(By.id("loginButton"));
        loginButton.click();

        WebElement dataManagement=driver.findElement(By.xpath("//*[@id=\"coreapps-datamanagement-homepageLink-coreapps-datamanagement-homepageLink-extension\"]"));
        dataManagement.click();

        WebElement mergePatient=driver.findElement(By.xpath("//*[@id=\"coreapps-mergePatientsHomepageLink-app\"]"));
        mergePatient.click();

        WebElement id1=driver.findElement(By.xpath("//*[@id=\"patient1-text\"]"));
        id1.sendKeys("100KUL" + Keys.TAB);
        WebElement id2=driver.findElement(By.xpath("//*[@id=\"patient2-text\"]"));
        id2.sendKeys("100N7R" + Keys.ENTER);

        WebElement continueButton=driver.findElement(By.xpath("//*[@id=\"confirm-button\"]"));
        Assert.assertTrue(!continueButton.isEnabled());

    }


    @Test
    public void RandevuYanlisSaatDilimi() {

        MyFunc.Bekle(3);
        WebElement demo=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Demo")));
        demo.click();

        WebElement explore=driver.findElement(By.xpath("(//div[@class='elementor-button-wrapper']/a)[2]"));
        explore.click();

        MyFunc.Bekle(2);
        WebElement enterMRS=wait.until(ExpectedConditions.
                elementToBeClickable(By.xpath("//span[text()='Enter the OpenMRS 2 Demo']")));
        enterMRS.click();
        MyFunc.Bekle(2);

        WebElement id=driver.findElement(By.id("username"));
        id.sendKeys("admin");

        WebElement pw=driver.findElement(By.id("password"));
        pw.sendKeys("Admin123");

        WebElement location=driver.findElement(By.id("Registration Desk"));
        location.click();

        WebElement login=driver.findElement(By.id("loginButton"));
        login.click();

        WebElement scheduling=driver.findElement(By.linkText("Appointment Scheduling"));
        scheduling.click();

        WebElement manage=driver.findElement(By.linkText("Manage Appointments"));
        manage.click();

        WebElement hastaid=driver.findElement(By.xpath("//input[@id='patient-search']"));
        hastaid.sendKeys("100JGA");

        WebElement tbody=wait.until(ExpectedConditions.
                elementToBeClickable(By.xpath("//tbody[@role='alert']/tr")));
        tbody.click();

        WebElement hataText=driver.findElement(By.xpath("//div[@id='time-zone-warning']//p"));

        Assert.assertTrue(hataText.isDisplayed());

    }

}

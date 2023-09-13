package Ahmet_Tefek;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ahmet extends BaseDriver {

    @Test
    public void loginTesti() {
        driver.get("https://openmrs.org/");
        MyFunc.Bekle(2);

        WebElement demo= driver.findElement(By.xpath("//a[@class='zak-button']"));
        demo.click();
        MyFunc.Bekle(1);

        WebElement explore= driver.findElement(By.cssSelector("div[class='elementor-button-wrapper']>:nth-child(1)"));
        Actions actions=new Actions(driver);
        actions.scrollToElement(explore);
        explore.click();
        MyFunc.Bekle(1);
        WebElement openMrs2= driver.findElement(By.xpath("//span[text()='Enter the OpenMRS 2 Demo']"));
        openMrs2.click();
        MyFunc.Bekle(2);
        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("admin");
        MyFunc.Bekle(2);
        WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Admin123");
        MyFunc.Bekle(2);
        WebElement location= driver.findElement(By.xpath("//li[@id='Inpatient Ward']"));
        location.click();
        MyFunc.Bekle(2);
        WebElement login= driver.findElement(By.xpath("//input[@id='loginButton']"));
        login.click();
        //Assert.assertTrue(driver.getTitle().equals("My Account"));


    }

    @Test(dependsOnMethods = {"loginTesti"})
    public void logout(){

        WebElement logOut= driver.findElement(By.cssSelector("a[href='/openmrs/appui/header/logout.action?successUrl=openmrs']"));
        logOut.click();

    }

    @Test()
    public void HastaKaydi(){
//        driver.get("https://demo.openmrs.org/");
//        MyFunc.Bekle(2);

//        WebElement demo= driver.findElement(By.xpath("//a[@class='zak-button']"));
//        demo.click();
//        MyFunc.Bekle(1);
//
//        WebElement explore= driver.findElement(By.cssSelector("div[class='elementor-button-wrapper']>:nth-child(1)"));
//        Actions actions=new Actions(driver);
//        actions.scrollToElement(explore);
//        explore.click();
//        MyFunc.Bekle(1);
//        WebElement openMrs2= driver.findElement(By.xpath("//span[text()='Enter the OpenMRS 2 Demo']"));
//        openMrs2.click();
//        MyFunc.Bekle(2);
//        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
//        username.sendKeys("admin");
//        MyFunc.Bekle(2);
//        WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
//        password.sendKeys("Admin123");
//        MyFunc.Bekle(2);
//        List<WebElement> location=driver.findElements(By.xpath("//ul[@id='sessionLocation']/li")); //başlıklar locationun li olan çocukları
//        MyFunc.Bekle(1);
//
//        int randomSecim= MyFunc.randomGenerator(location.size()); // random bir sayı üretildi
//        String locationText=location.get(randomSecim).getText(); //random location adı alındı
//        System.out.println("locationText = " + locationText); // kontrol için yazdım
//        location.get(randomSecim).click();
//        MyFunc.Bekle(2);
//        WebElement login= driver.findElement(By.xpath("//input[@id='loginButton']"));
//        login.click();
//        MyFunc.Bekle(1);
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
}

package BugrahanYildiz;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccount extends BaseDriver {


    @Test
    public void My_Account()
    {

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
}

package BugrahanYildiz;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class HastaArama_NEGATIF extends BaseDriver {

    By bosYereTiklat=By.xpath("//div[@class='collapse navbar-collapse']");


    @Test
    public void HastaAramaNeg() throws AWTException {

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
}

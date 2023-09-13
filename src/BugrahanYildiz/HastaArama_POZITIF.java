package BugrahanYildiz;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class HastaArama_POZITIF extends BaseDriver{

    By bosYereTiklat=By.xpath("//div[@class='collapse navbar-collapse']");

    @Test
    public void HastaAramaListesi() throws AWTException {

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

        for (int i = 0; i < 4; i++) {
            robot.keyPress(KeyEvent.VK_BACK_SPACE);
            MyFunc.Bekle(1);
            robot.keyRelease(KeyEvent.VK_BACK_SPACE);
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

        for (int i = 0; i < 4; i++) {
            robot.keyPress(KeyEvent.VK_BACK_SPACE);
            MyFunc.Bekle(1);
            robot.keyRelease(KeyEvent.VK_BACK_SPACE);
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

        for (int i = 0; i < 4; i++) {
            robot.keyPress(KeyEvent.VK_BACK_SPACE);
            MyFunc.Bekle(1);
            robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        }
        MyFunc.Bekle(5);
        WebElement hastaBilgisineUlasma= driver.findElement(By.xpath("//tr[@class='odd'][1]"));
        hastaBilgisineUlasma.click();
        MyFunc.Bekle(3);
        WebElement hastaBilgiListesi= driver.findElement(By.xpath("//div[@class='dashboard clear row']"));
        Assert.assertTrue(hastaBilgiListesi.getText().contains("DIAGNOSES"),"Hasta Bilgisi Görüntülenemedi.");
    }


















}

package OpenMrsCom.Korhan;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HastaListeleme extends BaseDriver {
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
}

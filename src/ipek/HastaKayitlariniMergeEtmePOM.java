package ipek;

import Utility.BaseDriver;
import Utility.BaseDriverParameter;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class HastaKayitlariniMergeEtmePOM extends BaseDriver {

    @Test
    public void HastaKayitlariniBirlestirme() {

        HastaKayitlariniMergeEtmeElementleri _elementler=new HastaKayitlariniMergeEtmeElementleri();
        // 100KUL
        // 100KVJ
        _elementler.demo.click();
        MyFunc.Bekle(2);
        _elementler.openMRS2.click();
        MyFunc.Bekle(2);
        _elementler.openMRS2Demo.click();
        MyFunc.Bekle(2);
        _elementler.username.sendKeys("admin" + Keys.TAB);
        _elementler.password.sendKeys("Admin123");
        _elementler.registrationDesk.click();
        _elementler.loginButton.click();
        _elementler.dataManagement.click();
        _elementler.mergePatient.click();
        _elementler.id1.sendKeys("100KUL" + Keys.TAB);
        _elementler.id2.sendKeys("100KVJ" + Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"confirm-button\"]")));
        _elementler.continueButton.click();
        System.out.println(_elementler.uyari.getText());
        Assert.assertTrue(_elementler.uyari.getText().equals("Merging cannot be undone!\nPlease check records before continuing."));
        _elementler.hasta1.click();
        _elementler.yesContinue.click();

        for (WebElement e:_elementler.list) {
            if(e.getText().equals(_elementler.id1)){
                System.out.println("ilk id eşleşti");
            } else if (e.getText().equals(_elementler.id2)) {
                System.out.println("ikinci id eşleşti");
            }
            else
                System.out.println("id ler eşleşmedi");
        }

    }
}

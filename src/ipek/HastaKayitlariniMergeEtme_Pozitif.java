package ipek;

import Utility.BaseDriverParameter;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class HastaKayitlariniMergeEtme_Pozitif extends BaseDriverParameter {
    //100HRU
    //100J27
    @Test
    @Parameters({"parametre1","parametre2"})
    public void HastaKayitlariniBirlestirme(String userName, String passWord) {

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
}

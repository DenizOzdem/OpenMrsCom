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

public class HastaKayitlariniMergeEtme_Negatif extends BaseDriverParameter {

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
        id1.sendKeys("100KUL" + Keys.TAB);
        WebElement id2=driver.findElement(By.xpath("//*[@id=\"patient2-text\"]"));
        id2.sendKeys("100N7R" + Keys.ENTER);

        WebElement continueButton=driver.findElement(By.xpath("//*[@id=\"confirm-button\"]"));
        Assert.assertTrue(!continueButton.isEnabled());

    }
}

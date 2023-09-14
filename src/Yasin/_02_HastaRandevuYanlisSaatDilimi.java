package Yasin;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _02_HastaRandevuYanlisSaatDilimi extends BaseDriver {

    @Test(dataProvider = "getData")
    public void RandevuYanlisSaatDilimi(String isim,String sifre,String kod){



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
        id.sendKeys(isim);


        WebElement pw=driver.findElement(By.id("password"));
        pw.sendKeys(sifre);

        WebElement location=driver.findElement(By.id("Registration Desk"));
        location.click();

        WebElement login=driver.findElement(By.id("loginButton"));
        login.click();

        WebElement scheduling=driver.findElement(By.linkText("Appointment Scheduling"));
        scheduling.click();

        WebElement manage=driver.findElement(By.linkText("Manage Appointments"));
        manage.click();

        WebElement hastaid=driver.findElement(By.xpath("//input[@id='patient-search']"));
        hastaid.sendKeys(kod);

        WebElement tbody=wait.until(ExpectedConditions.
                elementToBeClickable(By.xpath("//tbody[@role='alert']/tr")));
        tbody.click();




        WebElement hataText=wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//div[@id='time-zone-warning']//p")));

        Assert.assertTrue(hataText.isDisplayed());


    }
    @DataProvider
    Object[][] getData()
    {
        Object[][] data={{"admin","Admin123","100JGA"}};
        return data;
    }


}

package Yasin;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _01_SistemLoginHatali extends BaseDriver {

    @Test(dataProvider = "UserData")
    public void SistemLoginHatali(String isim,String sifre){



            WebElement demo = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Demo")));
            demo.click();

            WebElement explore = driver.findElement(By.xpath("(//div[@class='elementor-button-wrapper']/a)[2]"));
            explore.click();
            MyFunc.Bekle(2);

            WebElement enterMRS = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Enter the OpenMRS 2 Demo']")));
            enterMRS.click();
            MyFunc.Bekle(2);


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


            driver.get("https://openmrs.org/");


        WebElement location=driver.findElement(By.xpath("//li[@id='Registration Desk']"));
        location.click();

        WebElement login2=driver.findElement(By.id("loginButton"));
        login2.click();

        WebElement errormsj=wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.linkText("Invalid username/password. Please try again.")));

        Assert.assertTrue(errormsj.isDisplayed());


    }

    @DataProvider
    public Object[][] UserData(){
        Object[][] data= {
                {"ihsan", "122334"},
                {"sokol", "rustem5"},
                {"zeynep", "zeynep111"},
                {"serkan", "serkan500"},
                {"yasin", "kskizmir"},
                {"batuhan", "izmir35"}

        };
        return data;
    }



}

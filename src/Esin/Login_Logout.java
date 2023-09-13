package Esin;

import Utility.BaseDriver;
import Utility.MyFunc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Login_Logout extends BaseDriver {

    @Test
    public void Login() {

        WebElement demoButton = driver.findElement(By.linkText("Demo"));
        demoButton.click();
        MyFunc.Bekle(2);

        WebElement exploreButton = driver.findElement(By.linkText("Explore OpenMRS 2"));
        exploreButton.click();
        MyFunc.Bekle(2);

        WebElement exploreDemoButton = driver.findElement(By.linkText("Enter the OpenMRS 2 Demo"));
        exploreDemoButton.click();
        MyFunc.Bekle(2);

        WebElement Inputusername = driver.findElement(By.id("username"));
        Inputusername.sendKeys("admin");
        MyFunc.Bekle(2);

        WebElement Inputpassword = driver.findElement(By.id("password"));
        Inputpassword.sendKeys("Admin123");
        MyFunc.Bekle(2);

        WebElement InPtnWrdBtn = driver.findElement(By.id("Inpatient Ward"));
        InPtnWrdBtn.click();
        MyFunc.Bekle(2);

        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
        MyFunc.Bekle(2);


    }

    @Test(dependsOnMethods = {"WebAppLogin"})
    public void Logout() {


        WebElement logOutButton = driver.findElement(By.linkText("Logout"));
        logOutButton.click();
        MyFunc.Bekle(2);


    }
}
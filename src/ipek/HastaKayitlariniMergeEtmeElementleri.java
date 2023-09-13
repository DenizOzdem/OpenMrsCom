package ipek;

import Utility.BaseDriver;
import Utility.BaseDriverParameter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HastaKayitlariniMergeEtmeElementleri {
    public HastaKayitlariniMergeEtmeElementleri() {PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath = "//a[@class='zak-button']")
    public WebElement demo;

    @FindBy(xpath = "//span[@class='elementor-button-text' and text()='Explore OpenMRS 2']")
    public WebElement openMRS2;

    @FindBy(xpath = "//span[@class='elementor-button-text' and text()='Enter the OpenMRS 2 Demo']")
    public WebElement openMRS2Demo;

    @FindBy(id = "username")
    public WebElement username;
    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//li[text()='Registration Desk']")
    public WebElement registrationDesk;
    @FindBy(id = "loginButton")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id=\\\"coreapps-datamanagement-homepageLink-coreapps-datamanagement-homepageLink-extension\\\"]")
    public WebElement dataManagement;
    @FindBy(xpath = "//*[@id=\\\"coreapps-mergePatientsHomepageLink-app\\\"]")
    public WebElement mergePatient;

    @FindBy(xpath = "//*[@id=\\\"patient1-text\\\"]")
    public WebElement id1;
    @FindBy(xpath = "//*[@id=\\\"patient2-text\\\"]")
    public WebElement id2;

    @FindBy(xpath = "//*[@id=\"confirm-button\"]")
    public WebElement continueButton;
    @FindBy(xpath = "//*[@id=\\\"content\\\"]/form/div[3]/h1")
    public WebElement uyari;

    @FindBy(xpath = "//*[@id=\\\"second-patient\\\"]/div[2]/div[1]")
    public WebElement hasta1;

    @FindBy(xpath = "//*[@id=\\\"confirm-button\\\"]")
    public WebElement yesContinue;

    @FindBy(xpath = "//*[@id=\\\"content\\\"]/div[6]/div[2]/div/span")
    public List<WebElement> list;
}
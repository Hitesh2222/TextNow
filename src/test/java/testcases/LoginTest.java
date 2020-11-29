package testcases;

import data.ExcelDataManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Hitesh\\Desktop\\PRAGRA\\chromedriver.exe");
    }
    @Test(dataProvider = "contactProvider2",dataProviderClass = ExcelDataManager.class)
    public void openBrowser(String phoneNo, String bodyMsg) throws InterruptedException{
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.textnow.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginPageClick();
        Thread.sleep(2000);
        loginPage.setUserName();
        Thread.sleep(2000);
        loginPage.setPassword();
        Thread.sleep(2000);
        loginPage.singinclick();
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE);
        Thread.sleep(2000);
        loginPage.newMsgClick();
        Thread.sleep(2000);
        loginPage.tomsgClick(phoneNo);
        Thread.sleep(5000);
        loginPage.toBodyMsgClick(bodyMsg);
        Thread.sleep(2000);
        loginPage.sendBtnClick();
        Thread.sleep(10000);
        driver.quit();
    }

}

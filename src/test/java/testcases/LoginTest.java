package testcases;

import data.ExcelDataManager;
import data.NewExcelData;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import pages.LoginPage;
import sun.rmi.runtime.Log;

public class LoginTest {
    private WebDriver driver;
    @BeforeTest
    public void setup(){
        // Please load driver executable here..
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Hitesh\\Desktop\\PRAGRA\\chromedriver.exe");
    }
    @BeforeClass
    public void beforeTest() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver =new ChromeDriver();
        driver.get("https://www.textnow.com/");
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver);
        Thread.sleep(2000);
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
        Thread.sleep(4000);
        loginPage.newMsgClick();
        Thread.sleep(2000);
    }
    @Test(dataProvider = "dateProvider1",dataProviderClass = NewExcelData.class)
    public void openBrowser(String phoneNo, String bodyMsg) throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.tomsgClick(phoneNo);
        Thread.sleep(5000);
        loginPage.toBodyMsgClick(bodyMsg);
        Thread.sleep(5000);
        loginPage.sendBtnClick();
//        Thread.sleep(3000);
//        loginPage.newMsgClick();
        Thread.sleep(10000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

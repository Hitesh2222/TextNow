package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "#navbarDesktop > div > div > ul > li:nth-child(4) > a")
    private WebElement login;
    @FindBy(css = "#txt-username")
    private WebElement userName;
    @FindBy(css = "#txt-password")
    private WebElement password;
    @FindBy(css = "#btn-login > span")
    private WebElement singin;
    @FindBy(css = "#newText")
    private WebElement newMsg;
    @FindBy(css = "#recipientsView > div > div > input")
    private WebElement toMsg;
    @FindBy(css = "#text-input")
    private WebElement bodyMsg;
    @FindBy(css = "#send_button")
    private WebElement sendMsg;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,10);
    }
    public void loginPageClick() throws InterruptedException {
        this.login.click();
//        Thread.sleep(2000);
    }
    public void setUserName(){
        this.userName.sendKeys("");
    }
    public void setPassword(){
        this.password.sendKeys("");
    }
    public void singinclick(){
        this.singin.click();
    }
    public void newMsgClick(){
        this.newMsg.click();
    }
    public void tomsgClick(String phoneNo) throws InterruptedException {
//        this.toMsg = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#text-input")));
        this.toMsg.sendKeys(phoneNo,Keys.ENTER);
        Thread.sleep(2000);
//        return this;
    }
    public void toBodyMsgClick(String bodyMsg){
//        this.bodyMsg = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#text-input")));
        this.bodyMsg.sendKeys(bodyMsg);
//        return this;
    }
    public void sendBtnClick() throws InterruptedException {
        this.sendMsg.click();
        Thread.sleep(2000);
        newMsgClick();
//        return this;
    }
}

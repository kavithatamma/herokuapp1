package org.example.pageElements;

import org.example.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends DriverManager {
    @FindBy(id = "username")
    private WebElement userNameTxtBox;

    @FindBy(id = "password")
    private WebElement passwordTxtBox;

    @FindBy(css = ".fa-sign-in")
    private WebElement loginBtn;

    @FindBy(id = "flash-messages")
    private WebElement errorMessageTxtBox;

    @FindBy(className = "radius")
    private WebElement logoutBtn;

    @FindBy(className = "success")
    private WebElement logoutTxtBox;

    @FindBy(id = "flash")
    private WebElement loginSuccessMsg;

    public void enterUsernameTextBox(String userName) throws InterruptedException {
        userNameTxtBox.sendKeys(userName);
        Thread.sleep(5000);
    }
    public void enterPasswordTxtBox(String password){
        passwordTxtBox.sendKeys(password);
    }
    public void clickLoginBtn(){

        loginBtn.click();
    }
    public void statusCheck() throws InterruptedException {
        Thread.sleep(5000);
        String errorMsg=errorMessageTxtBox.getText();
        System.out.println(errorMsg);
    }
    public String resultError(){
        String errorMsg=errorMessageTxtBox.getText();
        return errorMsg;
    }
    public void clickLogoutBtn(){
        logoutBtn.click();
    }
    public String logoutMsg(){
        return logoutTxtBox.getText();
    }

    public String verifyLoginSuccessMsg(){

        return loginSuccessMsg.getText();
    }

}

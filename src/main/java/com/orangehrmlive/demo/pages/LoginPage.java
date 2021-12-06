package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @FindBy(id = "txtUsername")
    WebElement userName;

    @FindBy (xpath = "//input[@id='txtPassword']")
    WebElement password;

    @FindBy (xpath = "//input[@id='btnLogin']")
    WebElement loginButton;

    @FindBy (id = "logInPanelHeading")
    WebElement loginPanelText;

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement clickOnLogout;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void enterTheUsernameInTheUsernameField(String username){
        Reporter.log("Entering the username : " + userName.toString() + "<br>");
        pmSendTextToElement(userName, username );
    }

    public void enterThePasswordInThePasswordField(String passWord){
        Reporter.log("Entering the password : " + password.toString() + "<br>");
        pmSendTextToElement(password, passWord );
    }

    public void clickOnTheLoginButton(){
        Reporter.log("clicking on the login button : " + loginButton.toString() + "<br>");
        pmClickOnElement(loginButton);
    }

    public void clickOnTheLogOutButton(){
        Reporter.log("clicking on the logout button : " + clickOnLogout.toString() + "<br>");
        pmClickOnElement(clickOnLogout);
    }

    public void verifyTheLoginPanelText(){
        Reporter.log("Verifying the login panel text : " + loginPanelText.toString() + "<br>");
        pmVerifyElements(loginPanelText,"LOGIN Panel",  "Login Panel Text is displayed incorrectly");

    }
}

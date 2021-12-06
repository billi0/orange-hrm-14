package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod//(groups = {"smoke","sanity","regression"})
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LoginPage();

    }

    @BeforeMethod//(groups = {"smoke","sanity","regression"})
    @Parameters({"username", "password"})
    public void loginSuccessfully(String uname, String pword){
        //Enter username
        loginPage.enterTheUsernameInTheUsernameField(uname);
        //Enter password
        loginPage.enterThePasswordInThePasswordField(pword);
        //Click on Login Button
        loginPage.clickOnTheLoginButton();
    }


    @Test//(groups = {"smoke", "regression"})
    public void verifyUserShouldLoginSuccessFully(){
        homePage.verifyTheWelcomeMessage();
    }

    @Test(groups = {"sanity", "regression"} )
    public void verifyThatTheLogoDisplayOnHomePage(){
        homePage.verifyTheOrangeHRMLogo();
    }

    @Test(groups = {"regression"})
    public void verifyUserShouldLogOutSuccessFully() {
        //loginPage.clickOnTheLogOutButton();
        //loginPage.verifyTheLoginPanelText();
    }





}

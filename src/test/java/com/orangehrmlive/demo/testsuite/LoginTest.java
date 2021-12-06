package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    AddUserPage addUserPage;
    AdminPage adminPage;
    DashboardPage dashboardPage;
    ViewSystemUsersPage viewSystemUsersPage;

    @BeforeMethod
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        addUserPage = new AddUserPage();
        adminPage = new AdminPage();
        dashboardPage = new DashboardPage();
        viewSystemUsersPage = new ViewSystemUsersPage();
    }

    @BeforeMethod
    @Parameters({"username", "password"})
    public void loginSuccessfully(String uname, String pword){
        //Enter username
        loginPage.enterTheUsernameInTheUsernameField(uname);
        //Enter password
        loginPage.enterThePasswordInThePasswordField(pword);
        //Click on Login Button
        loginPage.clickOnTheLoginButton();
    }

    @Test(priority = 1, groups = {"smoke", "regression"})
    public void verifyUserShouldLoginSuccessFully(){
        homePage.verifyTheWelcomeMessage();
    }

    @Test(groups = {"sanity", "regression"} )
    public void VerifyThatTheLogoDisplayOnHomePage(){
        homePage.verifyTheOrangeHRMLogo();
    }

    @Test(priority = 2, groups = {"regression"})
    public void VerifyUserShouldLogOutSuccessFully() {
        //loginPage.clickOnTheLogOutButton();
        //loginPage.verifyTheLoginPanelText();
    }





}

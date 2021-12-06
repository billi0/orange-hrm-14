package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
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
    public void loginSuccessfully(){
        //Enter username
        loginPage.enterTheUsernameInTheUsernameField("Admin");
        //Enter password
        loginPage.enterThePasswordInThePasswordField("admin123");
        //Click on Login Button
        loginPage.clickOnTheLoginButton();
    }

    @Test(groups = {"smoke"})
    public void verifyUserShouldLoginSuccessFully(){
        homePage.verifyTheWelcomeMessage();
    }

    @Test(groups = {"smoke", "sanity"} )
    public void VerifyThatTheLogoDisplayOnHomePage(){
        homePage.verifyTheOrangeHRMLogo();
    }

    @Test(groups = {"smoke", "sanity", "regression"})
    public void VerifyUserShouldLogOutSuccessFully() {
        homePage.clickOnTheUserProfileLogo();
        homePage.mouseHoverOnLogoutAndClick();
        loginPage.verifyTheLoginPanelText();
    }





}

package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UsersTest extends TestBase {

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
        // Enter password
        loginPage.enterThePasswordInThePasswordField("admin123");
        // Click on Login Button
        loginPage.clickOnTheLoginButton();
    }

    @Test (priority = 1, groups = {"smoke"})
    public void adminShouldAddUserSuccessfully(){

        homePage.clickOnAdminTabFromHomePage();
        addUserPage.verifyTheSystemUsersWelcomeText();
        addUserPage.clickOnTheAddButton();
        addUserPage.verifyTheAddUserText();
        addUserPage.selectUserRole("Admin");
        addUserPage.putEmployeeNameInTheEmployeeNameField("Ananya Dash");
        addUserPage.putUserNameInTheUserNameField("AnanyaDash20");
        addUserPage.selectUserStatus("Disabled");
        addUserPage.enterPasswordInThePasswordField("Adhfaughua125£$£^");
        addUserPage.enterConfirmationPassword("Adhfaughua125£$£^");
        addUserPage.clickOnTheSaveButton();
        addUserPage.verifyTheSuccessfullySavedMessage();
    }

    @Test (priority = 2, groups = {"smoke", "sanity"} )
    public void searchTheUserCreatedAndVerifyIt(){
        homePage.clickOnAdminTabFromHomePage();
        viewSystemUsersPage.verifyTheSystemUsersWelcomeText();
        viewSystemUsersPage.putUserNameInTheUserNameField("AnanyaDash20");
        viewSystemUsersPage.selectUserRole("Admin");
        viewSystemUsersPage.selectUserStatus("Disabled");
        viewSystemUsersPage.clickOnTheSearchButton();
        //adminPage.verifyUsersNameIsInTheResultsTable();
        //Verify the User should be in Result list.
    }

    @Test (priority = 3, groups = {"smoke", "sanity"})
    public void  verifyThatAdminShouldDeleteTheUserSuccessFully(){
       searchTheUserCreatedAndVerifyIt();
        viewSystemUsersPage.clickOnTheCheckBox();
        viewSystemUsersPage.clickOnTheDeleteButton();
        //viewSystemUsersPage.clickOnOKButtonOfPopUp();
        viewSystemUsersPage.verifyTheSuccessfullyDeletedMessage();

    }

    @Test(priority = 4, groups = {"smoke", "sanity", "regression"})
    public void searchTheDeletedUserAndVerifyTheMessageNoRecordFound(){
        //Login to Application
        //click On "Admin" Tab
        //Verify "System Users" Text
        //Enter Username
        //Select User Role
        //Select Satatus
        //Click on "Search" Button
        //verify message "No Records Found"
        searchTheUserCreatedAndVerifyIt();
        viewSystemUsersPage.verifyTheNoRecordFoundMessage();

    }
}

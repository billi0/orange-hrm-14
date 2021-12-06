package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage extends Utility {

    @FindBy (xpath = "//a[@id='menu_admin_UserManagement']")
    WebElement userManagement;

    @FindBy (xpath = "//a[@id='menu_admin_Job']")
    WebElement job;

    @FindBy (xpath = "//a[@id='menu_admin_Organization']")
    WebElement organizationTabs;




    public AdminPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyUsersNameIsInTheResultsTable(String uName){
        //pmVerifyElements( anayaDash9,uName, "Name is not in results table");


    }
}

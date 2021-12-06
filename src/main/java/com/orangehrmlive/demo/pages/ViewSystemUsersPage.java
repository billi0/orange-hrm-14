package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ViewSystemUsersPage extends Utility {


    @FindBy(xpath = "//input[@id='systemUser_userName']")
    WebElement usernameField;

    @FindBy(xpath = "//select[@id='searchSystemUser_userType']")
    WebElement userRoleDropDown;

    @FindBy(xpath = "//input[@id='systemUser_employeeName_empName']")
    WebElement employeeNameField;

    @FindBy(xpath = "(//input[@id='searchSystemUser_userName'])[1]")
    WebElement userName;

    @FindBy (name = "searchSystemUser[status]")
    WebElement statusDropDown;

    @FindBy(xpath = "//input[@id='searchBtn']")
    WebElement searchButton;

    @FindBy(xpath = "")
    WebElement resetButton;

    @FindBy (xpath = "//input[@id='ohrmList_chkSelectAll']")
    WebElement checkBox;


    @FindBy(xpath = "//input[@id='btnDelete']")
    WebElement deleteButton;


    @FindBy(xpath = "//input[@id='systemUser_password']")
    WebElement password;

    @FindBy(css = "div[class='head'] h1")
    WebElement systemUsersText;

    @FindBy(xpath = "//td[contains(text(),'No Records Found')]")
    WebElement noRecordFound;

    public ViewSystemUsersPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyTheSuccessfullyDeletedMessage(){
        Reporter.log("Verify the add user text : " + noRecordFound.toString() + "<br>");
        //doVerifyElements("","", "Successfully Saved message is incorrect" );
        pmVerifyElements(noRecordFound, "No Records Found", "Message is incorrect");
    }

    public void verifyTheNoRecordFoundMessage(){
        Reporter.log("Verify the add user text : " + noRecordFound.toString() + "<br>");
        //doVerifyElements("","", "Successfully Saved message is incorrect" );
        pmVerifyElements(noRecordFound, "No Records Found", "Message is incorrect");
    }


    public void clickOnTheSearchButton() {
        Reporter.log("Click on the search Button : " + searchButton.toString() + "<br>");
        pmClickOnElement(searchButton);
    }

    public void clickOnTheCheckBox() {
        Reporter.log("Click on the checkbox : " + checkBox.toString() + "<br>");
        pmClickOnElement(checkBox);
    }

    public void clickOnTheDeleteButton() {
        Reporter.log("Click on the delete button : " + deleteButton.toString() + "<br>");
        pmClickOnElement(deleteButton);
    }

    public void clickOnOKButtonOfPopUp(){
        driver.switchTo().alert().accept();

    }



    public void putUserNameInTheUserNameField(String empUserName) {
        Reporter.log("Enter Employee User Name : " + userName.toString() + "<br>");
        pmSendTextToElement(userName, empUserName);
    }

    public void verifyTheSystemUsersWelcomeText() {
        Reporter.log("Verifying the system users text : " + systemUsersText.toString() + "<br>");
        pmVerifyElements(systemUsersText, "System Users", "Incorrect Text Displayed");

    }

    public void selectUserRole(String role){
        Reporter.log("Select role : " + userRoleDropDown.toString() + "<br>");
        selectByVisibleTextFromDropDown(userRoleDropDown,role );
    }

    public void selectUserStatus(String statusValue){
        Reporter.log("Select Status : " + statusDropDown.toString() + "<br>");
        //pmDoWaitUntilVisibilityOfElementLocated(By.xpath("(//select[@id='systemUser_status']"), 50);
        //pmClickOnElement(statusDropDown);
        selectByVisibleTextFromDropDown(statusDropDown, statusValue);
    }


}

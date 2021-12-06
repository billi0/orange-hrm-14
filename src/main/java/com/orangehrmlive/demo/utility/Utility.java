package com.orangehrmlive.demo.utility;

import com.orangehrmlive.demo.drivermanager.ManageDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class Utility extends ManageDriver {

    //*****************BASIC WEBDRIVER METHODS******************************


    /**
     * This method will click on element
     *
     * @ param by
     */
    public void pmClickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    public void pmClickOnElement(WebElement element) {
        element.click();
    }

    /**
     * This method will get text from element
     */
    public String pmGetTextFromElement(By by) {

        return driver.findElement(by).getText();
    }

    public String pmGetTextFromElement(WebElement element) {

        return element.getText();
    }

    /**
     * This method will send text on element
     */
    public void pmSendTextToElement(WebElement element, String text) {
        element.sendKeys(text);
    }

    /**
     * This method will find the element and clear all the data from it
     *
     * @param by
     */
    public void doFindElementAndClearText(By by) {
        WebElement elementToClear = driver.findElement(by);
        elementToClear.clear();
    }

    /**
     * This method will extract the value of a particular attribute from an element
     *
     * @param by
     * @param attribute
     * @return
     */
    public String doGetAttributeFromElement(By by, String attribute) {
        return driver.findElement(by).getAttribute(attribute);
    }


//*************************** Alert Methods ***************************************//

    /**
     * This method will switch to alert
     */
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    /**
     * This method will accept alert
     */
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    /**
     * This method will dismiss alert
     */
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    /**
     * This method will get text from alert
     */
    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    /**
     * This method will send text to alert
     */
    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }


//*************************** Select Class Methods ***************************************//

    /**
     * This method will select the option by visible text
     */
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    public void selectByVisibleTextFromDropDown(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    /**
     * This method will select the option by value
     */
    public void selectByValueFromDropDown(By by, String value) {
        new Select(driver.findElement(by)).selectByValue(value);
    }

    public void pmSelectByValueFromDropDown(WebElement webElement, String value) {
        new Select(webElement).selectByValue(value);
    }


    /**
     * This method will select the option by index
     */
    public void selectByIndexFromDropDown(By by, int index) {
        new Select(driver.findElement(by)).selectByIndex(index);
    }

    /**
     * This method will select the option by contains text
     */
    public void selectByContainsTextFromDropDown(By by, String text) {
        List<WebElement> allOptions = new Select(driver.findElement(by)).getOptions();
        for (WebElement options : allOptions) {
            if (options.getText().contains(text)) {
                options.click();
            }
        }
    }

    /**
     * THIS METHOD SELECTS A PARTICULAR MENU FROM THE MENU BAR
     *
     * @param by
     * @param menu
     * @throws InterruptedException
     */

    public void selectMenu(By by, String menu) throws InterruptedException {

        List<WebElement> names = driver.findElements(by);
        for (WebElement name : names) {
            //Thread.sleep(2000);
            if (name.getText().equalsIgnoreCase(menu)) {
                Thread.sleep(2000);
                name.click();
                break;
            }
        }
    }


//*************************** Window Handle Methods ***************************************//

    /**
     * This method will close all windows
     */
    public void closeAllWindows(List<String> hList, String parentWindow) {
        for (String str : hList) {
            if (!str.equals(parentWindow)) {
                driver.switchTo().window(str).close();
            }
        }
    }

    /**
     * This method will switch to parent window
     */
    public void switchToParentWindow(String parentWindowId) {
        driver.switchTo().window(parentWindowId);
    }

    /**
     * This method will find that we switch to right window
     */
    public boolean switchToRightWindow(String windowTitle, List<String> hList) {
        for (String str : hList) {
            String title = driver.switchTo().window(str).getTitle();
            if (title.contains(windowTitle)) {
                System.out.println("Found the right window....");
                return true;
            }
        }
        return false;
    }
//*************************** Action Methods ***************************************//

    /**
     * This method will use to hover mouse on element
     */
    public void pmMouseHoverNoClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    public void pmMouseHoverNoClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }


    /**
     * This method will hover the mouse over a particular element and click it
     *
     * @param by
     */
    public void pmMouseHoverAndClick(By by) {
        Actions hover = new Actions(driver);
        WebElement a = driver.findElement(by);
        hover.moveToElement(a).click().build().perform();
    }

    public void pmMouseHoverAndClick(WebElement element) {
        Actions hover = new Actions(driver);
        WebElement a = element;
        hover.moveToElement(a).click().build().perform();
    }

    /**
     * This Method will hover mouse on one element, then on second element
     * and click the second element
     */
    public void doMouseHoverOnFirstThenSecondAndClick(By by1, By by2) {
        Actions hover = new Actions(driver);
        WebElement destination1 = driver.findElement(by1);
        WebElement destination2 = driver.findElement(by2);
        hover.moveToElement(destination1).moveToElement(destination2).click().build().perform();
    }

    /**
     * This method performs a Right Click Mouse Action at the current mouse location
     *
     * @param by
     */
    public void doRightClick(By by) {
        Actions rightClick = new Actions(driver);
        WebElement a = driver.findElement(by);
        rightClick.contextClick().build().perform();
    }

    /**
     * This method performs click and hold at the source location, moves to target location
     * and then releases the mouse
     *
     * @param source
     * @param target
     */
    public void doDragAndDrop(By source, By target) {
        Actions builder = new Actions(driver);
        WebElement draggable = driver.findElement(source);
        WebElement droppable = draggable.findElement(target);
        builder.dragAndDrop(draggable, droppable).build().perform();
    }

    /**
     * Moves the slider from its current position to the desired position
     *
     * @param sliderBar
     * @param sliderBox
     * @param xAxis
     * @param yAxis
     */
    public void doSliderMovement(By sliderBar, By sliderBox, int xAxis, int yAxis) {
        Actions moveSlider = new Actions(driver);
        WebElement mainSlider = driver.findElement(sliderBar);
        WebElement slider = driver.findElement(sliderBox);
        moveSlider.dragAndDropBy(slider, xAxis, yAxis).build().perform();
    }

//************************** Waits Methods *********************************************//

    /**
     * This method will use to wait until  VisibilityOfElementLocated
     */
    public WebElement pmDoWaitUntilVisibilityOfElementLocated(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by);
    }


    public String doWaitUntilTitleIsEqualTo(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.titleContains(expectedMessage));
        return expectedMessage;
    }

    /**
     * This method will wait for an element using Fluent Wait
     *
     * @param by
     * @param time
     * @param pollingTime
     * @return
     */
    public WebElement waitForElementWithFluentWait(By by, int time, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }

    //************************** ScreenShot Methods *********************************************//
    public static String currentTimeStamp() {
        Date d = new Date();
        return d.toString().replace(":", "_").replace(" ", "_");
    }

    /*
     *Screenshot methods
     */
    public static String takeScreenShot(String fileName) {
        String filePath = System.getProperty("user.dir") + "/test-output/html/"; // path where screen shot needs to be saved
        TakesScreenshot screenshot = (TakesScreenshot) driver; // method to take screenshot
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        String imageName = fileName + currentTimeStamp() + ".jpg";
        String destination = filePath + imageName;
        try {
            FileUtils.copyFile(scr1, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    /**
     * ******************VERIFICATION METHODS---ASSERT CLASS**********************
     */

    /**
     * This method verifies elements using Assert class after reading text from element
     *
     * @param expectedMessage
     * @param actualMessage
     * @param displayMessage
     */

    public void doVerifyElements(String expectedMessage, String actualMessage, String displayMessage) {
        Assert.assertEquals(expectedMessage, actualMessage, displayMessage);
    }

    /******
     * This method verifies elements using locator directly as the second
     * instead of String
     * @param expectedMessage
     * @param by
     * @param displayMessage
     */

    public void pmVerifyElements(String expectedMessage, By by, String displayMessage) {
        Assert.assertEquals(by, expectedMessage, displayMessage);
    }

    public void pmVerifyElements( WebElement element,String expectedMessage, String displayMessage) {
        String actualMessage = pmGetTextFromElement(element);
        Assert.assertEquals(actualMessage, expectedMessage, displayMessage);
    }

    /**
     * This method is getting text from actual Message's WebElement using
     * the Explicit Wait Method. We will then use this as String actualMessage in Verification Method
     * We have used "waitUntilVisibilityOfElementLocated" Explicit Wait Method here
     *
     * @param actualMessage
     * @param timeout
     * @return
     */

    public String doGetTextFromActualMessageForVerificationUsingWait(By actualMessage, int timeout) {
        String verify = pmDoWaitUntilVisibilityOfElementLocated(actualMessage, timeout).getText();
        return verify;
    }

    /**
     * THIS IS THE VERIFICATION METHOD USING WAIT
     * THIS METHOD WILL WORK IN THE FOLLOWING WAY:
     * 1. Get Expected - can also use the "waitUntilTitleIsEqualTo" explicit wait method.
     * 2. Get Acutal = By getting text from actual element using "waitUntilVisibilityOfElement" method
     * 3. All this incorporated in the Assert Method
     *
     * @param expectedMessage
     * @param theActualMessage
     * @param timeForWait
     */
    public void verificationMethodUsingWait(String expectedMessage, By theActualMessage, int timeForWait) {
        String expected = expectedMessage;
        String actual = doGetTextFromActualMessageForVerificationUsingWait(theActualMessage, timeForWait);
        doVerifyElements(expected, actual, "Message is displayed incorrectly");
    }

    /**********************SORTING METHODS************************
     * THIS METHOD SORTS ELEMENTS IN THE ORDER OF PRICE LOW TO HIGH
     * @param dropDown
     */

    public void verifyTheSortingOrderOfPriceLowToHighIsCorrect(By beforeFilterElements, By dropDown, By lowToHigh) {
        List<WebElement> beforeFilterWebElementPrice = driver.findElements(beforeFilterElements);
        List<Double> beforeFilterDoublePriceList = new ArrayList<>();
        for (WebElement p : beforeFilterWebElementPrice) {
            beforeFilterDoublePriceList.add(Double.valueOf(p.getText().replace("$", " ")));
        }
        //Select dropDownBox = new Select(driver.findElement(dropDown));
        //dropDownBox.selectByVisibleText("Price Low - High");
        pmMouseHoverNoClick(dropDown);
        pmMouseHoverAndClick(lowToHigh);

        List<WebElement> afterFilterWebElementPriceList = driver.findElements(beforeFilterElements);
        List<Double> afterFilterDoublePriceList = new ArrayList<>();

        for (WebElement p : afterFilterWebElementPriceList) {
            afterFilterDoublePriceList.add(Double.valueOf(p.getText().replace("$", " ")));
        }

        Collections.sort(beforeFilterDoublePriceList);
        Assert.assertEquals(beforeFilterDoublePriceList, afterFilterDoublePriceList, "List is not sorted according to price Low to High");
    }

    /**
     * THIS METHOD SORTS ELEMENTS IN THE ORDER OF PRICE HIGH TO LOW
     *
     * @throws InterruptedException
     */

    public void verifyIfProductsAreSortedByPriceHighToLow(By beforeFilterElements, By dropDown, By hToLow) throws InterruptedException {
        List<WebElement> originalList = driver.findElements(beforeFilterElements);

        List<Double> originalProductPriceList = new ArrayList<>();
        for (WebElement price : originalList) {
            originalProductPriceList.add(Double.valueOf(price.getText().replace("$", "")));
        }

        System.out.println(originalProductPriceList);

        Collections.sort(originalProductPriceList, Collections.reverseOrder());
        pmMouseHoverNoClick(dropDown);
        pmMouseHoverAndClick(hToLow);
        Thread.sleep(3000);

        List<WebElement> afterSortingList = driver.findElements(beforeFilterElements);
        List<Double> afterSortingProductPrice = new ArrayList<>();
        for (WebElement price1 : afterSortingList) {
            afterSortingProductPrice.add(Double.valueOf(price1.getText().replace("$", "")));
        }
        System.out.println(afterSortingProductPrice);
        Assert.assertEquals(originalProductPriceList, afterSortingProductPrice, "products are not sorted");

    }

    /**
     * THIS METHOD SORTS ELEMENTS IN THE ORDER OF STAR RATINGS HIGH TO LOW
     *
     * @param beforeFilterElements
     * @param dropDown
     * @param hToLow
     * @throws InterruptedException
     */

    public void verifyProductsAreSortedAccordingToRatingHighToLow(By beforeFilterElements, By dropDown, By hToLow) throws InterruptedException {
        List<WebElement> originalList = driver.findElements(beforeFilterElements);

        List<Integer> originalProductRating = new ArrayList<>();
        for (WebElement rating : originalList) {
            originalProductRating.add(rating.getAttribute("style").indexOf(3, 6));
        }

        Collections.sort(originalProductRating, Collections.reverseOrder());
        pmMouseHoverNoClick(dropDown);
        pmMouseHoverAndClick(hToLow);
        Thread.sleep(3000);
        List<WebElement> afterSortingList = driver.findElements(beforeFilterElements);
        List<Integer> afterSortingProductRating = new ArrayList<>();
        for (WebElement rating1 : afterSortingList) {
            afterSortingProductRating.add(rating1.getAttribute("style").indexOf(2, 6));
        }
        System.out.println(afterSortingProductRating);
        Assert.assertEquals(originalProductRating, afterSortingProductRating, "products are not sorted");

    }


    /**
     * THIS METHOD VERIFIES IF ELEMENTS ARE SORTED FROM BY TITLES FROM A TO Z
     *
     * @param beforeFilterElements
     * @param dropDown
     * @param aToZ
     * @throws InterruptedException
     */
    public void verifyProductsAreSortedAlphabeticallyFromAToZ(By beforeFilterElements, By dropDown, By aToZ) throws InterruptedException {

        List<WebElement> originalList = driver.findElements(beforeFilterElements);
        List<String> originalProductRatingList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductRatingList.add(product.getText());
        }
        Collections.sort(originalProductRatingList);
        System.out.println(originalProductRatingList);

        pmMouseHoverNoClick(dropDown);
        pmMouseHoverAndClick(aToZ);

        List<WebElement> afterSortingList = driver.findElements(beforeFilterElements);
        List<String> afterSortingProductName = new ArrayList<>();
        for (WebElement product : afterSortingList) {
            afterSortingProductName.add(product.getText());
        }
        System.out.println(afterSortingProductName);
        Assert.assertEquals(originalProductRatingList, afterSortingProductName, "Products are not sorted");
    }

    /**
     * THIS METHOD VERIFIES IF ELEMENTS ARE SORTED FROM BY TITLES FROM Z TO A
     *
     * @throws InterruptedException
     */

    public void verifyProductsAreSortedFromZtoA(By beforeFilterElements, By dropDown, By zToA) throws InterruptedException {
        List<WebElement> originalList = driver.findElements(beforeFilterElements);
        List<String> originalProductNameList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductNameList.add(product.getText());
        }
        originalProductNameList.sort(String.CASE_INSENSITIVE_ORDER.reversed());

        System.out.println("Expected Result is : " + originalProductNameList);
        pmMouseHoverNoClick(dropDown);
        pmMouseHoverAndClick(zToA);
        Thread.sleep(3000);


        List<WebElement> afterSortingList = driver.findElements(beforeFilterElements);
        List<String> afterSortingProductName = new ArrayList<>();
        for (WebElement product1 : afterSortingList) {
            afterSortingProductName.add(product1.getText());
        }
        System.out.println("actual result is : )" + afterSortingProductName);

        Assert.assertEquals(originalProductNameList, afterSortingProductName, "products are now sorted");

    }


}

package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class ActionsDemo extends BaseTest {


    public static void radioClick() {
        WebElement radioTest = driver.findElement(By.xpath(".//label[@for='yesRadio']"));
        radioTest.click();

        Assert.assertTrue(radioTest.isEnabled());//Check we Clickable or no
    }


    public static void ceckBoxSelected() {
        driver.findElement(By.xpath("//button[@class='rct-collapse rct-collapse-btn']")).click();
        driver.findElement(By.xpath("(//button[@class='rct-collapse rct-collapse-btn'])[2]")).click();
        WebElement checkBoxSelector = driver.findElement(By.xpath("//label[@for='tree-node-desktop']/span"));
        checkBoxSelector.click();
        Assert.assertTrue(checkBoxSelector.isEnabled());
    }

    //@Test (description = "DoubleClick and RightClick")
    public static void testRightClick() {
        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));

        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickButton).perform();
        Helper.pause(2000);
        Assert.assertEquals(driver.findElement(By.id("doubleClickMessage")).getText(), "You have done a double click");


        WebElement rightClickBtn = driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
        actions.contextClick(rightClickBtn).perform();
        Assert.assertTrue(driver.findElement(By.id("rightClickMessage")).getText().contains("You have done a right click"));

        WebElement clickMeBtn = driver.findElement(By.xpath("//button[text()='Click Me']"));
        actions.click(clickMeBtn).perform();
        Assert.assertTrue(driver.findElement(By.id("dynamicClickMessage")).getText().contains("You have done a dynamic click"));

    }

    @Test(description = "Selector DDL")
    public static void actionClass() {
        driver.get("amazon.com");

        WebElement houseTypeSelectMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select select = new Select(houseTypeSelectMenu);
        //Find By Value
        select.selectByValue("1079");


        WebElement houseSizeSelectMenu = driver.findElement(By.id("hp-nav-select-house"));
        Select select1 = new Select(houseSizeSelectMenu);
        select1.selectByValue("9509");
        pressButton("//button[@class='btn btn-white quickQuoteLink']");

        Helper.pause(3000);

        //Click in PopUp
        pressButton("//span[@class='col-sm-9 col-xs-12']");
        Helper.pause(2000);
        pressButton("//div/button[@class='icn-remove icn-close']");
        Helper.pause(2000);
        pressButton("//a[@id='closeTutorial']");

        //Work With Block
        //Add Dresser
        goToElement("//div[@style='z-index: 15']");
        Helper.pause(2000);
        pressButton("(//a[@class='btn btn-blue'][normalize-space()='Add to Inventory'])[1]");

        //add Bed
        goToElement("//div[@style='z-index: 14']");
        Helper.pause(2000);
        pressButton("(//a[@class='btn btn-blue'][normalize-space()='Add to Inventory'])[1]");

        //add Tv
        goToElement("//div[@style='z-index: 13']");
        Helper.pause(2000);
        pressButton("(//a[@class='btn btn-blue'][normalize-space()='Add to Inventory'])[1]");

        Helper.pause(3000);
        //Check Items Position Left
        assertTextEqual("//div[@class='room-data withItems']/span[1]", "3 items");

        //Check Dresser Qty
        assertTextEqual("(//div[@class='panelContainer ActiveRoom item row'])[1]/span", "1xS");

        //Check Bed Qty
        assertTextEqual("(//div[@class='panelContainer ActiveRoom item row'])[2]/span", "1xS");

        //Check Tv Qty
        assertTextEqual("(//div[@class='panelContainer ActiveRoom item row'])[3]/span", "1xM");




        //Find By Text
//        select.selectByVisibleText("My Apartment");
//        //Find By Index
//        select.deselectByIndex(3);


    }

}

/*
Go to Imoving.com
Select "My Apartment
Just a few Items
Click Compare

in Pop Up
Click "Continue"
Click "GOT IT"


Item:
Add
Dresser , Bed, Tv

After
Check Items in Left Column

Qty
 */


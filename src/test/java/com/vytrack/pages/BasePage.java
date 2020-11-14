package com.vytrack.pages;

import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {

    @FindBy(className = "oro-subtitle")
    protected WebElement pageSubtitle;

    @FindBy(xpath = "(//button[contains(text(), 'Save and Close')])[1]")
    protected WebElement saveAndCloseBtn;

    @FindBy(css = "[class='loader-mask']")
    protected List<WebElement> loaderMask;

    //For using @FindBy
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String getPageSubtitleText(){
        return pageSubtitle.getText();
    }

    public void navigateTo(String tab, String module){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
        String tabXpath = "//*[contains(text(), '" + tab + "') and @class='title title-level-1']";
        String moduleXpath = "//*[contains(text(), '" + module + "') and @class='title title-level-2']";

        BrowserUtils.wait(5);
        //wait.until(ExpectedConditions.invisibilityOfAllElements(loaderMask));

        WebElement tabElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tabXpath)));
        wait.until(ExpectedConditions.elementToBeClickable(tabElement)).click();

        //wait.until(ExpectedConditions.invisibilityOfAllElements(loaderMask));

        WebElement moduleElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(moduleXpath)));
        wait.until(ExpectedConditions.elementToBeClickable(moduleElement)).click();

        //wait.until(ExpectedConditions.invisibilityOfAllElements(loaderMask));

        BrowserUtils.wait(4);

    }

    public void clickSaveAndClose(){
        BrowserUtils.clickOnElement(saveAndCloseBtn);
    }



}

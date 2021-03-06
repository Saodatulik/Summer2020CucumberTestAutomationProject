package com.vytrack.pages;

import com.vytrack.utils.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "prependedInput")
    private WebElement usernameInput;

    @FindBy(id = "prependedInput2")
    private WebElement passwordInput;

    @FindBy (css = "[class='alert alert-error']")
    private WebElement warningMessage;

    public String getWarningMessageText() {
        try { Thread.sleep(5000); }
        catch (InterruptedException e)
        { e.getMessage(); }

        return warningMessage.getText().trim();
    }

    public void login(String usernameValue, String passwordValue){
        usernameInput.sendKeys(usernameValue);
        passwordInput.sendKeys(passwordValue, Keys.ENTER);
    }

    public void login(){
        String usernameValue = ConfigurationReader.getProperty("storemanager.username");
        String passwordValue = ConfigurationReader.getProperty("password");

        usernameInput.sendKeys(usernameValue);
        passwordInput.sendKeys(passwordValue, Keys.ENTER);
    }

    public void login(String role){
        String usernameValue = "";
        String passwordValue = ConfigurationReader.getProperty("password");

        if(role.equalsIgnoreCase("sales manager")){
            usernameValue = ConfigurationReader.getProperty("salesmanager.username");
        } else if (role.equalsIgnoreCase("driver")){
            usernameValue = ConfigurationReader.getProperty("driver.username");
        } else {
            usernameValue = ConfigurationReader.getProperty("storemanager.username");
        }

        usernameInput.sendKeys(usernameValue);
        passwordInput.sendKeys(passwordValue, Keys.ENTER);
    }




}

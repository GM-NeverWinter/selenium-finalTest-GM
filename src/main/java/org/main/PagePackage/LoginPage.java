package org.main.PagePackage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.main.Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    private final Logger log = LogManager.getLogger(this.getClass());

    // Declare Element
    // Login Page
    @FindBy(id = "txt-username")
    private WebElement usernameField;
    @FindBy(id = "txt-password")
    private WebElement pwdField;
    @FindBy(xpath = "//input[@value='John Doe']")
    private WebElement getUsername;
    @FindBy(xpath = "//input[@value='ThisIsNotAPassword']")
    private WebElement getPwd;
    @FindBy(id = "btn-login")
    private WebElement btnLogin;
    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Action
    // Load page
    public void loadLogin(){
        getWait().until(ExpectedConditions.elementToBeClickable(btnLogin));
    }

    // Login action
    public void loginAction(){
        usernameField.sendKeys(getUsername.getAttribute("value"));
        log.info("Input Username.");
        pwdField.sendKeys(getPwd.getAttribute("value"));
        log.info("Input Password.");
        btnLogin.click();
        log.info("Click button Login.");
    }

}

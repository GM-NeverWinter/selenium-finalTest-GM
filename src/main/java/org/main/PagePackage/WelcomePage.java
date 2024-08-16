package org.main.PagePackage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.main.Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class WelcomePage extends BasePage {
    private final Logger log = LogManager.getLogger(this.getClass());

    // Declare Element
    // Welcome Page
    @FindBy(id = "btn-make-appointment")
    private WebElement btn_MakeAppoiment;
    @FindBy(id = "menu-toggle")
    private WebElement btn_menu;
    @FindBy(linkText = "Login")
    private WebElement btn_login;
    @FindBy(linkText = "Logout")
    private WebElement btn_logout;
    public WelcomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Action
    // Load page
    public void loadWelcome(){
        getWait().until(ExpectedConditions.elementToBeClickable(btn_MakeAppoiment));
    }

    // Go to Login Page
    public void loginPage(){
        btn_menu.click();
        log.info("Click Menu");
        getWait().until(ExpectedConditions.elementToBeClickable(btn_login));
        btn_login.click();
        log.info("click Login");
    }

    // Logout Page
    public void logoutPage(){
        btn_menu.click();
        log.info("Click Menu");
        getWait().until(ExpectedConditions.elementToBeClickable(btn_logout));
        btn_logout.click();
        log.info("click Logout");
    }
}

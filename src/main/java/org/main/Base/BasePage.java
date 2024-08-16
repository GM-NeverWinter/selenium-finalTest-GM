package org.main.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    public WebDriverWait getWait(){
        return new WebDriverWait(driver, 10);
    }
}

package org.main.PagePackage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.main.Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AppointmentCfmPage extends BasePage {
    private final Logger log = LogManager.getLogger(this.getClass());

    // Button Back Element
    @FindBy(linkText = "Go to Homepage")
    private WebElement btnHomePage;

    // Value element
    @FindBy(id = "facility")
    private WebElement facilityCfm;
    @FindBy(id = "hospital_readmission")
    private WebElement hospital_readmissionCfm;
    @FindBy(id = "program")
    private WebElement programCfm;
    @FindBy(id = "visit_date")
    private WebElement visit_dateCfm;
    @FindBy(id = "comment")
    private WebElement commentCfm;
    public AppointmentCfmPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Action
    public void loadAppCfmPage(){
        getWait().until(ExpectedConditions.elementToBeClickable(btnHomePage));
    }

    public void appCfmPage(){
        // Declare Expected Result:
        String facilityExpect = "Seoul CURA Healthcare Center";
        String readmissionExpect = "Yes";
        String programExpect = "Medicaid";
        String visitdateExpect = "30/06/2024";
        String commentExpect = "This is test comment";

        // Verify Result
        Assert.assertEquals(facilityCfm.getText(),
                facilityExpect,"The value is NOT match!");
        log.info("The value is match!");
        Assert.assertEquals(hospital_readmissionCfm.getText(),
                readmissionExpect,"The value is NOT match!");
        log.info("The value is match!");
        Assert.assertEquals(programCfm.getText(),
                programExpect,"The value is NOT match!");
        log.info("The value is match!");
        Assert.assertEquals(visit_dateCfm.getText(),
                visitdateExpect,"The value is NOT match!");
        log.info("The value is match!");
        Assert.assertEquals(commentCfm.getText(),
                commentExpect,"The value is NOT match!");
        log.info("The value is match!");
    }

    // Back to homepage
    public void backHomepage(){
        btnHomePage.click();
        log.info("Click Go to HomePage button");
    }


}

package org.main.PagePackage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.main.Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AppointmentPage extends BasePage {
    private final Logger log = LogManager.getLogger(this.getClass());
    // Click button Book Element
    @FindBy(id = "btn-book-appointment")
    private WebElement btnBook;

    // The rest Element
    @FindBy(id = "combo_facility")
    private WebElement facilityField;
    @FindBy(id = "chk_hospotal_readmission")
    private WebElement facilityCheckbox;
    @FindBy(xpath = "//input[@id='radio_program_medicaid']/ancestor::label")
    private WebElement programmedicalCheckbox;
    @FindBy(id = "txt_visit_date")
    private WebElement visitDate;
    @FindBy(id = "txt_comment")
    private WebElement commentBox;

    public AppointmentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Action
    // Load Page
    public void loadAptPage(){
        getWait().until(ExpectedConditions.elementToBeClickable(btnBook));
    }

    // Make Appointment
    public void makeApt() {
        // Data 1
        new Select(facilityField).selectByValue("Seoul CURA Healthcare Center");
        log.info("Select Facility dropdown-list.");

        if (facilityCheckbox.isSelected()) {
            facilityCheckbox.click();
        }
        facilityCheckbox.click();
        log.info("Click checkbox.");

        programmedicalCheckbox.click();
        log.info("Select Healthcare Program.");

        visitDate.sendKeys("30/06/2024");
        log.info("Select date.");

        commentBox.sendKeys("This is test comment");
        log.info("Comment value.");

        btnBook.click();
        log.info("Click button Book Appointment.");
    }
}

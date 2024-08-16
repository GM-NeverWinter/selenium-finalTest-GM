package org.main.Main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.main.Base.BaseTest;
import org.main.PagePackage.AppointmentCfmPage;
import org.main.PagePackage.AppointmentPage;
import org.main.PagePackage.LoginPage;
import org.main.PagePackage.WelcomePage;
import org.testng.annotations.Test;

public class MainTC extends BaseTest {
    private static final Logger log = LogManager.getLogger(MainTC.class);

    @Test(priority = 1)
    public void ATC001() {
       WelcomePage welcomePage = new WelcomePage(driver);
       LoginPage loginPage = new LoginPage(driver);
       AppointmentPage appointmentPage = new AppointmentPage(driver);

        // Testcase 1
        welcomePage.loadWelcome();
        welcomePage.loginPage();

        loginPage.loadLogin();
        loginPage.loginAction();

        appointmentPage.loadAptPage();
        welcomePage.logoutPage();
        welcomePage.loadWelcome();
    }

    @Test(priority = 2)
    public void ATC002() {
        WelcomePage welcomePage = new WelcomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AppointmentPage appointmentPage = new AppointmentPage(driver);
        AppointmentCfmPage appointmentCfmPage = new AppointmentCfmPage(driver);

        // Testcase 2
        welcomePage.loadWelcome();
        welcomePage.loginPage();
        loginPage.loadLogin();
        loginPage.loginAction();

        appointmentPage.loadAptPage();
        appointmentPage.makeApt();

        appointmentCfmPage.loadAppCfmPage();
        appointmentCfmPage.appCfmPage();
        appointmentCfmPage.backHomepage();

        welcomePage.loadWelcome();
    }

}


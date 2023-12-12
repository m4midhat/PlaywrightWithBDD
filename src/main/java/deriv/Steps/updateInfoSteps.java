package deriv.Steps;

import com.microsoft.playwright.Page;
import deriv.Factory.playwrightFactory;
import deriv.pages.loginPage;
import deriv.pages.personalDetailsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.AfterClass;

public class updateInfoSteps {

    static deriv.Factory.playwrightFactory playwrightFactory;
    Page page;
    deriv.pages.loginPage loginPage;
    deriv.pages.dashboardPage dashboardPage;
    personalDetailsPage personalDetailsPage;

    public updateInfoSteps(Page page){
        this.page = page;
    }

    public updateInfoSteps(){

    }

    @Given("User is logged into the orangeHRM")
    public void userIsLoggedIntoTheOrangeHRM() {
        playwrightFactory = new playwrightFactory();
        playwrightFactory.initBrowser("firefox");
        page = playwrightFactory.openURL("https://opensource-demo.orangehrmlive.com");
        loginPage = new loginPage(page);
        loginPage.enterUserName("admin");
        loginPage.enterPassword("admin123");
        dashboardPage = loginPage.clickLogin();
    }

    @And("User clicks on the MyInfo page")
    public void userClicksOnTheMyInfoPage() {
        personalDetailsPage = dashboardPage.clickMyInfo();
    }

    @And("User updates the DOB")
    public void userUpdatesTheDOB() {
        personalDetailsPage.openDOBCalendar();
        personalDetailsPage.selectRandomDate();

    }

    @And("User presses button Save")
    public void userPressesButtonSave() {
        personalDetailsPage.clickSaveButton();
    }

    @Then("Updated DOB is displayed")
    public void updatedDOBIsDisplayed() {
        personalDetailsPage.successMessageIsShown();
    }

    @AfterClass
    public static void closeAll(){
        playwrightFactory.closePlaywright();
    }
}

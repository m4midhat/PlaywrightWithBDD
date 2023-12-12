package deriv.Steps;

import com.microsoft.playwright.Page;
import deriv.Factory.playwrightFactory;
import deriv.pages.loginPage;
import deriv.pages.personalDetailsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class userLogoutSteps {

    static deriv.Factory.playwrightFactory playwrightFactory;
    Page page;
    deriv.pages.loginPage loginPage;
    deriv.pages.dashboardPage dashboardPage;


    @When("User clicks on profile drop down button")
    public void userClicksOnProfileDropDownButton() {
        dashboardPage.userDropDown();
    }

    @And("User clicks on logout link")
    public void userClicksOnLogoutLink() {
        loginPage = dashboardPage.clickLogout();
    }

    @Given("User is already logged into Orange HRM")
    public void userIsAlreadyLoggedIntoOrangeHRM() {
        playwrightFactory = new playwrightFactory();
        playwrightFactory.initBrowser("chrome");
        page = playwrightFactory.openURL("https://opensource-demo.orangehrmlive.com");
        loginPage = new loginPage(page);
        loginPage.enterUserName("admin");
        loginPage.enterPassword("admin123");
        dashboardPage = loginPage.clickLogin();
    }

    @Then("User is redirected to login page")
    public void userIsRedirectedToLoginPage() {
        loginPage.verifyPageURL();
    }
}

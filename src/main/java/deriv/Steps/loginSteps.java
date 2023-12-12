package deriv.Steps;

import deriv.Factory.playwrightFactory;
import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import deriv.pages.dashboardPage;
import deriv.pages.loginPage;
import org.junit.AfterClass;

public class loginSteps {

    static playwrightFactory playwrightFactory;
    Page page;
    loginPage loginPage;
    dashboardPage dashboardPage;

    public loginSteps(Page page){
        this.page = page;
    }

    public loginSteps(){

    }

    @Given("User opens the required browser {string}")
    public void userOpensTheRequiredBrowser(String browser) {
        playwrightFactory = new playwrightFactory();
        playwrightFactory.initBrowser(browser);
    }

    @And("User navigates to the Orange HRM website")
    public void userNavigatesToTheOrangeHRMWebsite() {
       page = playwrightFactory.openURL("https://opensource-demo.orangehrmlive.com");
       loginPage = new loginPage(page);
    }

    @And("User provides the correct credentials {string} and {string}")
    public void userProvidesTheCorrectCredentialsAnd(String username, String password) {
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
    }

    @And("User clicks the login button")
    public void userClicksTheLoginButton() {
        dashboardPage = loginPage.clickLogin();
    }

    @Then("User should be able to view the dashboard")
    public void userShouldBeAbleToViewTheDashboard() {
        dashboardPage.verifyPageTitle();
    }

    @AfterClass
    public static void closeAll(){
        playwrightFactory.closePlaywright();
    }
}

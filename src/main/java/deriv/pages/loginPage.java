package deriv.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import org.junit.Assert;

public class loginPage {

    Page page;
    public loginPage(Page page){
        this.page = page;
    }

    public void enterUserName(String userName){
        page.locator("div.oxd-form-row input").nth(0).fill(userName);
    }

    public void enterPassword(String password){
        page.locator("div.oxd-form-row input").nth(1).fill(password);
    }

    public dashboardPage clickLogin(){
        page.locator("form.oxd-form button").click();
        page.waitForTimeout(500);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        return new dashboardPage(page);
    }

    private String getURL(){
        return page.url();
    }

    public void verifyPageURL(){
        String pageUrl = getURL();
        Assert.assertEquals(pageUrl, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

}

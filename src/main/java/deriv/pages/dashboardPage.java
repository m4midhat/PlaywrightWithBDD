package deriv.pages;

import com.microsoft.playwright.Page;
import org.junit.Assert;

public class dashboardPage {
    Page page;
    public dashboardPage(Page page) {
        this.page = page;
    }

    public String pageTitle(){
        return page.title();
    }

    public void verifyPageTitle(){
        String title = pageTitle();
        Assert.assertEquals(title, "OrangeHRM");
    }

    public personalDetailsPage clickMyInfo(){
        page.locator("//span[normalize-space()='My Info']").click();
        return new personalDetailsPage(page);
    }

    public void userDropDown(){
        page.locator("span.oxd-userdropdown-tab").click();
    }

    public loginPage clickLogout(){
        page.locator("//a[normalize-space()='Logout']").click();
        return new loginPage(page);
    }
}

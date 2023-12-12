package deriv.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.Assert;

public class personalDetailsPage {

    Page page;

    public personalDetailsPage(){

    }

    private int generateRandomNumber(int min, int max){
        return (int) (Math.random()*(max-min+1)+min);
    }

    public personalDetailsPage(Page page){
        this.page = page;
    }

    public String pageTitle(){
        return page.title();
    }

    private Locator DOBField(){
        return page.locator("div.oxd-form-row div.oxd-date-input").nth(1);
    }

    public void openDOBCalendar(){
        DOBField().locator("i").click();
        page.waitForTimeout(500);
    }

    public void selectRandomDate(){
        int randomDate = generateRandomNumber(1, 28);
        page.locator("//div[@class='oxd-calendar-date'][normalize-space()='"+ randomDate +"']").click();
        page.waitForTimeout(500);
    }

    public void clickSaveButton(){
        page.locator("div.oxd-form-actions button").nth(0).click();
        page.waitForTimeout(2000);

    }

    public void successMessageIsShown(){
        Assert.assertTrue(page.locator("div#oxd-toaster_1 div").nth(0).isVisible());
    }

}

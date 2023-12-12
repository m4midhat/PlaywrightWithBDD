package deriv.Factory;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class playwrightFactory {

    private static final ThreadLocal<Playwright> playwrightThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<Browser> browserThreadLocal = new InheritableThreadLocal<>();
    private static final ThreadLocal<BrowserContext> browserContextThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<Page> pageThreadLocal = new ThreadLocal<>();

    private static Playwright getPlaywright(){
        return playwrightThreadLocal.get();
    }

    private static Browser getBrowser(){
        return browserThreadLocal.get();
    }

    private static BrowserContext getBrowserContext(){
        return browserContextThreadLocal.get();
    }

    private static Page getPage(){
        return pageThreadLocal.get();
    }


    public Browser initBrowser(String browserName)  {
        log.info("Browser name : "+ browserName);
        String URL;
        playwrightThreadLocal.set(Playwright.create());

        switch (browserName.toLowerCase()) {
            case "chromium" ->
                    browserThreadLocal.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
            case "firefox" ->
                    browserThreadLocal.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
            case "safari" ->
                    browserThreadLocal.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
            case "chrome" ->
                    browserThreadLocal.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)));
            default ->
            {
                log.error("Invalid browser name !!!");
                log.error("Using default browser 'Google Chrome'");
                browserThreadLocal.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)));
            }
        }
        browserContextThreadLocal.set(getBrowser().newContext());
        getBrowserContext().setDefaultTimeout(100000);

        return getBrowser();
    }

    public Page openURL(String url){
        pageThreadLocal.set(browserContextThreadLocal.get().newPage());
        getPage().navigate(url);
        getPage().waitForLoadState(LoadState.DOMCONTENTLOADED);

        return getPage();
    }


    public void closePlaywright(){
        getPage().close();
        getPlaywright().close();
    }

}

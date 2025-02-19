package khims.rodion.steps;

import khims.rodion.driver.SeleniumDriver;
import khims.rodion.page.AboutServicePage;
import org.openqa.selenium.support.PageFactory;

public class AboutServicePageSteps {
    private AboutServicePage aboutServicePage;

    public AboutServicePageSteps() {
        aboutServicePage = PageFactory.initElements(SeleniumDriver.getInstance(), AboutServicePage.class);
    }

    public String getCurrentSiteMapPositionName() {
        return aboutServicePage.getCurrentBreadCrumb().getText();
    }
}

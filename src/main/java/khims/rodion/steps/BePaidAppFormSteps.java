package khims.rodion.steps;

import khims.rodion.driver.SeleniumDriver;
import khims.rodion.page.BePaidAppForm;
import org.openqa.selenium.support.PageFactory;

public class BePaidAppFormSteps {
    private final BePaidAppForm bePaidAppForm;

    public BePaidAppFormSteps() {
        bePaidAppForm = PageFactory.initElements(SeleniumDriver.getInstance(), BePaidAppForm.class);
    }

    public boolean isDisplayed() {
        return bePaidAppForm.getForm().isDisplayed();
    }
}

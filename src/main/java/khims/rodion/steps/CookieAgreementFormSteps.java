package khims.rodion.steps;

import khims.rodion.driver.SeleniumDriver;
import khims.rodion.pojo.CookieAgreementForm;
import org.openqa.selenium.support.PageFactory;

public class CookieAgreementFormSteps {
    private final CookieAgreementForm cookieAgreementForm;

    public CookieAgreementFormSteps() {
        cookieAgreementForm = PageFactory.initElements(SeleniumDriver.getInstance(), CookieAgreementForm.class);
    }

    public void accept() {
        if (cookieAgreementForm.getCookieForm().isDisplayed()) {
            cookieAgreementForm.getAcceptButton().click();
        }
    }
}

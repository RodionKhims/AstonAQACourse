package khims.rodion.steps;

import khims.rodion.driver.SeleniumDriver;
import khims.rodion.page.CookieAgreementForm;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class CookieAgreementFormSteps {
    private final CookieAgreementForm cookieAgreementForm;

    public CookieAgreementFormSteps() {
        cookieAgreementForm = new CookieAgreementForm();
    }

    public void accept() {
        if (isAccepted()) {
            return;
        }
        WebElement acceptButton = cookieAgreementForm.getAcceptButton();
        if (Objects.isNull(acceptButton)) {
            return;
        }
        if (acceptButton.isEnabled()) {
            acceptButton.click();
        }
    }

    private boolean isAccepted() {
        return SeleniumDriver.getInstance().manage().getCookies().stream()
                .filter(cookie -> "_tt_enable_cookie".equals(cookie.getName()))
                .anyMatch(cookie -> "1".equals(cookie.getValue()));
    }
}

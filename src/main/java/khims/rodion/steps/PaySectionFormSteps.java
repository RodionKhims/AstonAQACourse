package khims.rodion.steps;

import khims.rodion.driver.SeleniumDriver;
import khims.rodion.page.PaySectionForm;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class PaySectionFormSteps {
    private final PaySectionForm paySectionForm;

    public PaySectionFormSteps() {
        this.paySectionForm = PageFactory.initElements(SeleniumDriver.getInstance(), PaySectionForm.class);
    }

    public String getTitle() {
        return paySectionForm.getTitle().getText();
    }

    public boolean isExistAllPayPartnersLogo() {
        return paySectionForm.getPayPartners().stream()
                .allMatch(el -> el.findElement(By.tagName("img")).isDisplayed());
    }

    public int getPayPartnersCount() {
        return paySectionForm.getPayPartners().size();
    }

    public AboutServicePageSteps clickAboutService() {
        paySectionForm.getAboutServiceLink().click();
        return new AboutServicePageSteps();
    }
}

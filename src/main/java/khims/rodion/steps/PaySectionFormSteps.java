package khims.rodion.steps;

import khims.rodion.driver.SeleniumDriver;
import khims.rodion.page.PaySectionForm;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PaySectionFormSteps {
    private final PaySectionForm paySectionForm;
    private final List<PaySectionForm.OptionPayForm> optionPayForms;

    public PaySectionFormSteps() {
        this.paySectionForm = PageFactory.initElements(SeleniumDriver.getInstance(), PaySectionForm.class);
        optionPayForms = List.of(paySectionForm.getConnectionPayForm(),
                paySectionForm.getInternetPayForm(),
                paySectionForm.getInstalmentPayForm(),
                paySectionForm.getArrearsPayForm());
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

    public void fillConnectionPayForm(String phone, double sum) {
        paySectionForm.getConnectionPayForm().getNumInput().sendKeys(phone);
        paySectionForm.getConnectionPayForm().getSumInput().sendKeys(String.valueOf(sum));
    }

    public BePaidAppFormSteps proceedConnectionPay() {
        paySectionForm.getConnectionPayForm().getProceedButton().click();
        return new BePaidAppFormSteps();
    }

    public void choosePayOption(int index) {
        paySectionForm.getSelectPayOptionButton().click();
        paySectionForm.getPayOptions().get(index).click();
    }

    public String getNumInputPlaceholder(int index) {
        return optionPayForms.get(index).getNumInput().getDomAttribute("placeholder");
    }

    public String getSumInputPlaceholder(int index) {
        return optionPayForms.get(index).getSumInput().getDomAttribute("placeholder");
    }

    public String getEmailInputPlaceholder(int index) {
        return optionPayForms.get(index).getEmailInput().getDomAttribute("placeholder");
    }
}

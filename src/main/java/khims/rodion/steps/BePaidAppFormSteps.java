package khims.rodion.steps;

import khims.rodion.driver.SeleniumDriver;
import khims.rodion.page.BePaidAppForm;
import khims.rodion.utils.LazyLoadElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class BePaidAppFormSteps {
    private BePaidAppForm bePaidAppForm;

    public BePaidAppFormSteps() {
        bePaidAppForm = new BePaidAppForm();
        LazyLoadElement.waitForIFrame(20, 2, By.className("bepaid-iframe"));
        LazyLoadElement.waitForPresent(20, 2, By.xpath("//app-card-page//button[@type='submit']"));
        PageFactory.initElements(SeleniumDriver.getInstance(), bePaidAppForm);
    }

    public boolean isDisplayed() {
        return bePaidAppForm.getForm().isDisplayed();
    }

    public String getSumDescription() {
        return bePaidAppForm.getSumDescription().getText();
    }

    public String getCardNumInputPlaceholder() {
        return bePaidAppForm.getCardNumInput().findElement(By.xpath("./../label")).getText();
    }

    public String getExpireDateInputPlaceholder() {
        return bePaidAppForm.getExpireDateInput().findElement(By.xpath("./../label")).getText();
    }

    public String getCvcInputPlaceholder() {
        return bePaidAppForm.getCvcInput().findElement(By.xpath("./../label")).getText();
    }

    public String getHolderInputPlaceholder() {
        return bePaidAppForm.getHolderInput().findElement(By.xpath("./../label")).getText();
    }

    public String getSubmitButtonText() {
        return bePaidAppForm.getSubmitButton().getText();
    }
}

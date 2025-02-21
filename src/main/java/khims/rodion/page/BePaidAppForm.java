package khims.rodion.page;

import khims.rodion.utils.LazyLoadElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class BePaidAppForm {
    @FindBy(xpath = "//div[@class='pay-description__cost']//span")
    private WebElement sumDescription;

    @FindBy(id = "cc-number")
    private WebElement cardNumInput;

    @FindBy(xpath = "//input[@formcontrolname='expirationDate']")
    private WebElement expireDateInput;

    @FindBy(xpath = "//input[@formcontrolname='cvc']")
    private WebElement cvcInput;

    @FindBy(xpath = "//input[@formcontrolname='holder']")
    private WebElement holderInput;

    @FindBy(xpath = "//app-card-page//button[@type='submit']")
    private WebElement submitButton;

    public WebElement getForm() {
        return LazyLoadElement.waitFor(30, 2, By.xpath("//div[@class='bepaid-app']"));
    }
}

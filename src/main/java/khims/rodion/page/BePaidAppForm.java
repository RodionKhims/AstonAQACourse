package khims.rodion.page;

import khims.rodion.annotation.ExpectConditionType;
import khims.rodion.annotation.LazyFind;
import khims.rodion.utils.LazyLoadElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class BePaidAppForm {
    @LazyFind(period = 2, xpath = "//div[@class='bepaid-app']")
    @FindBy(xpath = "//div[@class='bepaid-app']")
    private WebElement form;

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

    @LazyFind(timeout = 20, period = 2, waitType = ExpectConditionType.WAITFORPRESENT, xpath = "//app-card-page//button[@type='submit']")
    @FindBy(xpath = "//app-card-page//button[@type='submit']")
    private WebElement submitButton;
}

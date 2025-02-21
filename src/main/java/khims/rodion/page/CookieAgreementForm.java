package khims.rodion.page;

import khims.rodion.annotation.ExpectConditionType;
import khims.rodion.annotation.LazyFind;
import khims.rodion.utils.LazyLoadElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CookieAgreementForm {
    @LazyFind(waitType = ExpectConditionType.WAITFORCLICKABLE, xpath = "//*[@id='cookie-agree']")
    @FindBy(id = "cookie-agree")
    private WebElement acceptButton;
}

package khims.rodion.page;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class AboutServicePage {
    @FindBy(xpath = "//span[@itemprop='item']//span[@itemprop='name']")
    private WebElement currentBreadCrumb;
}

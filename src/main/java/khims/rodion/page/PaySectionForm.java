package khims.rodion.page;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class PaySectionForm {
    @FindBy(xpath = "//div[@id='pay-section']//section[@class='pay']//h2")
    private WebElement title;

    @FindBy(xpath = "//div[@id='pay-section']//div[@class='pay__partners']//li")
    private List<WebElement> payPartners;

    @FindBy(xpath = "//div[@id='pay-section']//section[@class='pay']//a")
    private WebElement aboutServiceLink;
}

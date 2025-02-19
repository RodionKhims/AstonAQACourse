package khims.rodion.pojo;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class PaySectionForm {
    @FindBy(xpath = "//div[@id='pay-section']//section[@class='pay']//h2")
    private WebElement title;
}

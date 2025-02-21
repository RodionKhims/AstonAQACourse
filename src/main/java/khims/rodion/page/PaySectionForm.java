package khims.rodion.page;

import khims.rodion.driver.SeleniumDriver;
import lombok.Getter;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "//div[@id='pay-section']//button[@class='select__header']")
    private WebElement selectPayOptionButton;

    @FindBy(xpath = "//div[@id='pay-section']//ul[@class='select__list']//li")
    private List<WebElement> payOptions;

    private final OptionPayForm connectionPayForm = new OptionPayForm("connection", "connection-phone", "connection-sum", "connection-email");
    private final OptionPayForm internetPayForm = new OptionPayForm("internet", "internet-phone", "internet-sum", "internet-email");
    private final OptionPayForm instalmentPayForm = new OptionPayForm("instalment", "score-instalment", "instalment-sum", "instalment-email");
    private final OptionPayForm arrearsPayForm = new OptionPayForm("arrears", "score-arrears", "arrears-sum", "arrears-email");

    public static class OptionPayForm {
        private final String prefix;
        private final String numInputId;
        private final String sumInputId;
        private final String emailInputId;

        public OptionPayForm(String prefix, String numInputId, String sumInputId, String emailInputId) {
            this.prefix = prefix;
            this.numInputId = numInputId;
            this.sumInputId = sumInputId;
            this.emailInputId = emailInputId;
        }

        public WebElement getNumInput() {
            return SeleniumDriver.getInstance().findElement(By.id(numInputId));
        }

        public WebElement getSumInput() {
            return SeleniumDriver.getInstance().findElement(By.id(sumInputId));
        }

        public WebElement getEmailInput() {
            return SeleniumDriver.getInstance().findElement(By.id(emailInputId));
        }

        public WebElement getProceedButton() {
            return SeleniumDriver.getInstance()
                    .findElement(By.xpath("//div[@id='pay-section']//form[@id='pay-"+ prefix +"']//button[contains(@class, 'button')]"));
        }
    }
}

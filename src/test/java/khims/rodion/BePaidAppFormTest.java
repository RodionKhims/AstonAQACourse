package khims.rodion;

import khims.rodion.driver.SeleniumDriver;
import khims.rodion.steps.BePaidAppFormSteps;
import khims.rodion.steps.CookieAgreementFormSteps;
import khims.rodion.steps.PaySectionFormSteps;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BePaidAppFormTest extends BaseTest {
    private PaySectionFormSteps paySectionFormSteps;

    @BeforeEach
    public void init() {
        SeleniumDriver.getInstance().get("https://oplata.mts.by");
        CookieAgreementFormSteps cookieAgreementFormSteps = new CookieAgreementFormSteps();
        cookieAgreementFormSteps.accept();
        paySectionFormSteps = new PaySectionFormSteps();
    }

    @Test
    public void testBePaidForm() {
        paySectionFormSteps.fillConnectionPayForm("297777777", 5.00);
        BePaidAppFormSteps bePaidAppFormSteps = paySectionFormSteps.proceedConnectionPay();
        Assertions.assertThat(bePaidAppFormSteps.getSumDescription()).isEqualTo("5.00 BYN");
        Assertions.assertThat(bePaidAppFormSteps.getCardNumInputPlaceholder()).isEqualTo("Номер карты");
        Assertions.assertThat(bePaidAppFormSteps.getExpireDateInputPlaceholder()).isEqualTo("Срок действия");
        Assertions.assertThat(bePaidAppFormSteps.getCvcInputPlaceholder()).isEqualTo("CVC");
        Assertions.assertThat(bePaidAppFormSteps.getHolderInputPlaceholder()).isEqualTo("Имя держателя (как на карте)");
        Assertions.assertThat(bePaidAppFormSteps.getSubmitButtonText()).isEqualTo("Оплатить 5.00 BYN");
    }
}

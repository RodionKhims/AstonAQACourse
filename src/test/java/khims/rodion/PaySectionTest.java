package khims.rodion;

import khims.rodion.driver.SeleniumDriver;
import khims.rodion.steps.CookieAgreementFormSteps;
import khims.rodion.steps.PaySectionFormSteps;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PaySectionTest extends BaseTest {
    @BeforeEach
    public void init() {
        SeleniumDriver.getInstance().get("https://oplata.mts.by");
        CookieAgreementFormSteps cookieAgreementFormSteps = new CookieAgreementFormSteps();
        cookieAgreementFormSteps.accept();
    }

    @Test
    public void testTitleIsExists() {
        PaySectionFormSteps paySectionFormSteps = new PaySectionFormSteps();
        Assertions.assertThat(paySectionFormSteps.getTitle()).isEqualTo("Онлайн пополнение\nбез комиссии");
    }
}

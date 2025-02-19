package khims.rodion;

import khims.rodion.driver.SeleniumDriver;
import khims.rodion.steps.CookieAgreementFormSteps;
import khims.rodion.steps.PaySectionFormSteps;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PaySectionTest extends BaseTest {
    private PaySectionFormSteps paySectionFormSteps;

    @BeforeEach
    public void init() {
        SeleniumDriver.getInstance().get("https://oplata.mts.by");
        CookieAgreementFormSteps cookieAgreementFormSteps = new CookieAgreementFormSteps();
        cookieAgreementFormSteps.accept();
        paySectionFormSteps = new PaySectionFormSteps();
    }

    @Test
    public void testTitleIsExists() {
        Assertions.assertThat(paySectionFormSteps.getTitle()).isEqualTo("Онлайн пополнение\nбез комиссии");
    }

    @Test
    public void testExistingPartnersLogo() {
        Assertions.assertThat(paySectionFormSteps.getPayPartnersCount()).isEqualTo(5);
        Assertions.assertThat(paySectionFormSteps.isExistAllPayPartnersLogo()).isTrue();
    }
}

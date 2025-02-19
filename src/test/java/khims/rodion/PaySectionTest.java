package khims.rodion;

import khims.rodion.driver.SeleniumDriver;
import khims.rodion.steps.AboutServicePageSteps;
import khims.rodion.steps.BePaidAppFormSteps;
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

    @Test
    public void testAboutServicePage() {
        AboutServicePageSteps aboutServicePageSteps = paySectionFormSteps.clickAboutService();
        Assertions.assertThat(aboutServicePageSteps.getCurrentSiteMapPositionName())
                .isEqualTo("Порядок оплаты и безопасность интернет платежей");
    }

    @Test
    public void testSuccessProceedPayForm() {
        paySectionFormSteps.fillForm("297777777", 5);
        BePaidAppFormSteps bePaidAppFormSteps = paySectionFormSteps.proceed();
        Assertions.assertThat(bePaidAppFormSteps.isDisplayed()).isTrue();
    }
}

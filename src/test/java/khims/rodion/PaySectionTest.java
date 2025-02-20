package khims.rodion;

import khims.rodion.driver.SeleniumDriver;
import khims.rodion.page.PaySectionForm;
import khims.rodion.steps.AboutServicePageSteps;
import khims.rodion.steps.BePaidAppFormSteps;
import khims.rodion.steps.CookieAgreementFormSteps;
import khims.rodion.steps.PaySectionFormSteps;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    @DisplayName("Test Pay Section Title")
    public void testTitleIsExists() {
        Assertions.assertThat(paySectionFormSteps.getTitle()).isEqualTo("Онлайн пополнение\nбез комиссии");
    }

    @Test
    @DisplayName("Test Pay Section Partners Logo")
    public void testExistingPartnersLogo() {
        Assertions.assertThat(paySectionFormSteps.getPayPartnersCount()).isEqualTo(5);
        Assertions.assertThat(paySectionFormSteps.isExistAllPayPartnersLogo()).isTrue();
    }

    @Test
    @DisplayName("Test About Service Link")
    public void testAboutServicePage() {
        AboutServicePageSteps aboutServicePageSteps = paySectionFormSteps.clickAboutService();
        Assertions.assertThat(aboutServicePageSteps.getCurrentSiteMapPositionName())
                .isEqualTo("Порядок оплаты и безопасность интернет платежей");
    }

    @Test
    @DisplayName("Test Opening Connection Pay Form")
    public void testSuccessProceedPayForm() {
        paySectionFormSteps.fillConnectionPayForm("297777777", 5);
        BePaidAppFormSteps bePaidAppFormSteps = paySectionFormSteps.proceedConnectionPay();
        Assertions.assertThat(bePaidAppFormSteps.isDisplayed()).isTrue();
    }

    @ParameterizedTest
    @DisplayName("Test placeholders of pay form")
    @CsvSource({
            "0, Номер телефона, Сумма, E-mail для отправки чека",
            "1, Номер абонента, Сумма, E-mail для отправки чека",
            "2, Номер счета на 44, Сумма, E-mail для отправки чека",
            "3, Номер счета на 2073, Сумма, E-mail для отправки чека",
    })
    public void testPayFormPlaceholders(int index, String numPlaceHolder, String sumPlaceholder, String emailPlaceholder) {
        paySectionFormSteps.choosePayOption(index);
        Assertions.assertThat(paySectionFormSteps.getNumInputPlaceholder(index)).isEqualTo(numPlaceHolder);
        Assertions.assertThat(paySectionFormSteps.getSumInputPlaceholder(index)).isEqualTo(sumPlaceholder);
        Assertions.assertThat(paySectionFormSteps.getEmailInputPlaceholder(index)).isEqualTo(emailPlaceholder);
    }
}

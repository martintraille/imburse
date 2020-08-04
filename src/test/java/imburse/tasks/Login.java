package imburse.tasks;

import imburse.ui.AccountLoginPage;
import imburse.ui.TenantPortalLoginPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import utilities.TestData;

import static utilities.TestData.DataKeys.*;

public class Login implements Task {


    private AccountLoginPage accountLoginPage;
    private TenantPortalLoginPage tenantPortalLoginPage;

    private static String emailAddress;
    private static String password;



    public static Performable withAccountPortalCredentials() {
        final TestData testData = new TestData();
        emailAddress = testData.getData(ACCOUNT_PORTAL_EMAIL_ADDRESS);
        password = testData.getData(ACCOUNT_PORTAL_PASSWORD);
        return Instrumented.instanceOf(Login.class).newInstance();
    }

    public static Performable withTenantPortalCredentials() {
        final TestData testData = new TestData();
        emailAddress = testData.getData(TENANT_PORTAL_EMAIL_ADDRESS);
        password = testData.getData(TENANT_PORTAL_PASSWORD);
        return Instrumented.instanceOf(Login.class).newInstance();
    }


    @Override
    @Step("{0} enters their email address and password account credentials")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(emailAddress)
                        .into(AccountLoginPage.EMAIL_ADDRESS)
                        .thenHit(Keys.ENTER));
        actor.attemptsTo(
                Enter.theValue(password)
                        .into(AccountLoginPage.PASSWORD));
        actor.attemptsTo(
                Click.on(AccountLoginPage.SUBMIT_BUTTON));
    }


}

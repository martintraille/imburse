package imburse.tasks;

import imburse.ui.AccountLoginPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

public class Login implements Task {

    private AccountLoginPage accountLoginPage;

    @Override
    @Step("{0} enters their email address and password account credentials")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue("martin.traille@imbursepayments.com")
                .into(AccountLoginPage.EMAIL_ADDRESS)
                .thenHit(Keys.ENTER));
        actor.attemptsTo(
                Enter.theValue("DMS89xln")
                .into(AccountLoginPage.PASSWORD));
        actor.attemptsTo(
                Click.on(AccountLoginPage.SUBMIT_BUTTON));
    }

    public static Performable withAccountPortalCredentials() {
        return Instrumented.instanceOf(Login.class).newInstance();
    }


}

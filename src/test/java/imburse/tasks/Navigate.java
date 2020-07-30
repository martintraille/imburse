package imburse.tasks;

import imburse.ui.AccountLoginPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class Navigate implements Performable {


    private AccountLoginPage accountLoginPage;

    @Override
    @Step("{0} navigates to the Imburse account login page")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(accountLoginPage));

    }

    public static Performable toTheImburseAccountLoginPage() {
        return Instrumented.instanceOf(Navigate.class).newInstance();
    }

}

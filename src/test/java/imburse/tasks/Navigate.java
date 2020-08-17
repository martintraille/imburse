package imburse.tasks;

import imburse.ui.AccountLoginPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import utilities.TestData;

import static utilities.TestData.DataKeys.*;

public class Navigate implements Performable {


    private AccountLoginPage accountLoginPage;
    private static EnvironmentVariables environmentVariables;
    private static String url;
//public TestData testData = new TestData();

    public static Performable toTheImburseAccountLoginPage() {
        final TestData testData = new TestData();
        url = testData.getData(ACCOUNT_PORTAL_URL);
        return Instrumented.instanceOf(Navigate.class).newInstance();
    }

    public static Performable toTheTenantPortalLoginPage() {
        final TestData testData = new TestData();
        url = testData.getData(TENANT_PORTAL_URL);
        return Instrumented.instanceOf(Navigate.class).newInstance();
    }

    public static Performable toTheOpsPortal() {
        final TestData testData = new TestData();
        url = testData.getData(OPS_PORTAL_URL);
        return Instrumented.instanceOf(Navigate.class).newInstance();


    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));

    }

}
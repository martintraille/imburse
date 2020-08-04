package imburse.steps;

import imburse.questions.*;
import imburse.tasks.Login;
import imburse.tasks.Navigate;
import imburse.ui.TenantListPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.util.EnvironmentVariables;
import utilities.TestData;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static utilities.TestData.DataKeys.*;

public class TenantPortalLoginStepDefinitions {

    private final TestData testData = new TestData();
    private EnvironmentVariables environmentVariables;

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
        testData.setData(TENANT_PORTAL_URL,environmentVariables.getProperty("tenantportalurl"));
        testData.setData(TENANT_PORTAL_EMAIL_ADDRESS, environmentVariables.getProperty("tenantportalemailaddress"));
        testData.setData(TENANT_PORTAL_PASSWORD, environmentVariables.getProperty("tenantportalpassword"));

    }


    @Given("{string} has an account with two tenants")
    public void has_an_account_with_two_tenants(String actorName) {
        OnStage.theActorCalled(actorName).attemptsTo(Navigate.toTheTenantPortalLoginPage());
    }

    @When("he logs into the tenant portal")
    public void he_logs_into_the_tenant_portal() {
        OnStage.theActorInTheSpotlight().attemptsTo(Login.withTenantPortalCredentials());
    }

    @Then("he is presented with a list of the tenants he can access")
    public void he_is_presented_with_a_list_of_the_tenants_he_can_access() {
        OnStage.theActorInTheSpotlight().should(eventually(seeThat(TheTenantListHeader.isVisible()))
                .waitingForNoLongerThan(10).seconds());
        OnStage.theActorInTheSpotlight().attemptsTo(Ensure.thatTheCurrentPage().currentUrl()
                .isEqualTo("https://qa-portal.imburse.net/choose-tenant"));
        OnStage.theActorInTheSpotlight().should(eventually(seeThat(TheFirstTenantInTheList.isVisible())));
        OnStage.theActorInTheSpotlight().should(eventually(seeThat(TheSecondTenantInTheList.isVisible())));
    }


    @Given("{string} has an account with one tenant")
    public void has_an_account_with_one_tenant(String actorName) {
        OnStage.theActorCalled(actorName).attemptsTo(Navigate.toTheTenantPortalLoginPage());
    }


    @Then("he is automatically routed to the tenant landing page")
    public void he_is_automatically_routed_to_the_tenant_landing_page() {
       OnStage.theActorInTheSpotlight().should(eventually(seeThat(TheTenantPortalHomeMenuItem.isVisible())));
       OnStage.theActorInTheSpotlight().should(seeThat(TheTenantPortalLandingPageMessage.isVisible()));
    }


}

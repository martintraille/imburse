package imburse.steps;

import imburse.questions.TheAccountName;
import imburse.questions.TheAccountPortalTenantTable;
import imburse.ui.AccountPortalLandingPage;
import imburse.ui.AccountPortalTenantsPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import utilities.TestData;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.*;
import static utilities.TestData.DataKeys.*;

public class AccountPortalManagementStepDefinitions {

    @Steps
    AccountPortalLoginStepDefinitions accountPortalLoginStepDefinitions;

    AccountPortalLandingPage accountPortalLandingPage;

    private final TestData testData = new TestData();
    private EnvironmentVariables environmentVariables;

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
        testData.setData(ACCOUNT_PORTAL_URL, environmentVariables.getProperty("accountportalurl"));
        testData.setData(ACCOUNT_PORTAL_EMAIL_ADDRESS, environmentVariables.getProperty("accountportalemailaddress"));
        testData.setData(ACCOUNT_PORTAL_PASSWORD, environmentVariables.getProperty("accountportalpassword"));
    }

    @Given("{string} has logged into the account portal")
    public void has_logged_into_the_account_portal(String actorName) {
        accountPortalLoginStepDefinitions.is_on_the_Imburse_Account_login_page(actorName);
        accountPortalLoginStepDefinitions.he_submits_his_login_credentials();
        accountPortalLoginStepDefinitions.he_is_logged_in_successfully();

        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(AccountPortalLandingPage.SWITCH_ACCOUNTS_DROPDOWN),
                Click.on(AccountPortalLandingPage.SWITCH_ACCOUNTS),
                Click.on(AccountPortalLandingPage.AUTOMATION_TEST_ACCOUNT));
        OnStage.theActorInTheSpotlight()
                .should(seeThat(TheAccountName.is(), equalTo("Automation Test Account")));

    }

    @Given("there are no active tenants on his account")
    public void there_are_no_active_tenants_on_his_account() {
        OnStage.theActorInTheSpotlight().attemptsTo(Click.on(AccountPortalLandingPage.TENANTS));
        OnStage.theActorInTheSpotlight().should(eventually(seeThat(TheAccountPortalTenantTable.is(), equalTo("Something or other"))));

    }

    @When("he creates a Tenant with valid details")
    public void he_creates_a_Tenant_with_valid_details() {
        System.out.println("Now we are here");
    }

    @Then("that tenant is created successfully")
    public void that_tenant_is_created_successfully() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}

package imburse.steps;

import imburse.questions.TheTenantMenuItem;
import imburse.tasks.Login;
import imburse.tasks.Navigate;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class LoginStepDefinitions {

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{string} is on the Imburse Account login page")
    public void picard_is_on_the_Imburse_Account_login_page(String actorName) {
        OnStage.theActorCalled(actorName).attemptsTo(Navigate.toTheImburseAccountLoginPage());
    }

    @When("he submits his login credentials")
    public void he_submits_his_login_credentials() {
        OnStage.theActorInTheSpotlight().attemptsTo(Login.withAccountPortalCredentials());
    }

    @Then("he is logged in successfully")
    public void he_is_logged_in_successfully() throws InterruptedException {
        OnStage.theActorInTheSpotlight().should(eventually(seeThat(TheTenantMenuItem.isVisible()))
                .waitingForNoLongerThan(10).seconds());
    }


}

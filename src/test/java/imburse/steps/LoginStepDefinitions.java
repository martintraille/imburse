package imburse.steps;

import imburse.tasks.Login;
import imburse.tasks.Navigate;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class LoginStepDefinitions {

@Before
public void set_the_stage() {
    OnStage.setTheStage(new OnlineCast()); }

    @Given("{string} is on the Imburse Account login page")
    public void picard_is_on_the_Imburse_Account_login_page(String actorName) {
       OnStage.theActorCalled(actorName).attemptsTo(Navigate.toTheImburseAccountLoginPage());
    }

    @When("he submits his login credentials")
    public void he_submits_his_login_credentials() {
        // Write code here that turns the phrase above into concrete actions
        OnStage.theActorInTheSpotlight().attemptsTo(Login.withAccountPortalCredentials());
    }

    @Then("he is logged in successfully")
    public void he_is_logged_in_successfully() {
        System.out.println("Wait here!!!!");
        throw new io.cucumber.java.PendingException();
    }


}

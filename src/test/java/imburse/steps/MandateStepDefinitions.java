package imburse.steps;

import imburse.model.builder.order.OrderDirector;
import imburse.model.request.order.RequestBody;
import imburse.tasks.Login;
import imburse.tasks.Navigate;
import imburse.tasks.callendpoints.Api;
import imburse.ui.TenantListPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.junit.Assert;
import org.junit.runner.RunWith;
import utilities.TestData;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertTrue;
import static utilities.TestData.DataKeys.*;


@RunWith(SerenityRunner.class)
public class MandateStepDefinitions {
    private EnvironmentVariables environmentVariables;


    private String accountId;
    private String tenantId;
    private String mandateResponse;


    @Steps(shared = true)
    AuthenticationSteps picard;

    @Steps(shared = true)
    private TestData testData;

    @Steps(shared = true)
    private OrderDirector orderDirector;

    @Steps(shared = true)
    private Api api;

    @Steps(shared = true)
    BearerTokenStepDefinitions bearerTokenStepDefinitions;

    @Steps(shared = true)
    AuthenticationSteps registeredUser;

    @Steps(shared = true)
    TenantPortalLoginStepDefinitions tenantPortalLoginStepDefinitions;



    private RequestBody body;

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{string} has an account that has the mandate feature enabled")
    public void has_an_account_that_has_the_mandate_feature_enabled(String actorName) throws UnsupportedEncodingException {
       bearerTokenStepDefinitions.registered_user_has_a_valid_accountId_and_tenantID();
       bearerTokenStepDefinitions.he_attempts_to_authenticate_via_the_endpoint("v1", "/identity/hmac");
       bearerTokenStepDefinitions.he_receives_a_bearer_token();

        OnStage.theActorCalled(actorName);

        //   testData.setData(OPS_PORTAL_URL, environmentVariables.getProperty("opsportalurl"));
        //TODO API call to verify if mandate is enabled is not yet implemented
        //.when()
        //.post(api).then().statusCode(Integer.parseInt(testData.getData(EXPECTED_STATUS_CODE).toString()));
        setBody(orderDirector.anOrderWithAnInstruction());
    }

    @Given("{string} has an account that does not have the mandate feature enabled")
    public void an_account_that_does_not_have_the_mandate_feature_enabled(String actorName) throws UnsupportedEncodingException {
        OnStage.setTheStage(new OnlineCast());
        //     String environment = environmentVariables.getProperty("environment");
        EnvironmentVariables env = SystemEnvironmentVariables.createEnvironmentVariables();
        String environment = env.getProperty("ENV");
        switch (environment) {
            case "qa":
                RestAssured.baseURI = environmentVariables.getProperty("qaapiurl");
                testData.setData(BASE_URL, environmentVariables.getProperty("qaapiurl"));
                testData.setData(ACCOUNTID, environmentVariables.getProperty("qaaccountidmandatenotenabled"));
                testData.setData(TENANTID, environmentVariables.getProperty("qatenantidmandatenotenabled"));
                testData.setData(PUBLICKEY, environmentVariables.getProperty("qapublickey"));
                testData.setData(PRIVATEKEY, environmentVariables.getProperty("qaprivatekey"));
                testData.setData(SCHEMEID, environmentVariables.getProperty("schemeid"));
                break;
        }
        bearerTokenStepDefinitions.registered_user_has_a_valid_accountId_and_tenantID();
        bearerTokenStepDefinitions.he_attempts_to_authenticate_via_the_endpoint("v1", "/identity/hmac");
        bearerTokenStepDefinitions.he_receives_a_bearer_token();

        OnStage.theActorCalled(actorName);
        setBody(orderDirector.anOrderWithAnInstruction());

    }

    @When("a POST API call is made to the {string} {string} endpoint")
    public void a_Post_API_call_is_made_to_the_endpoint(String apiVersion, String endpoint) {
        api.call(apiVersion, endpoint, getBody());
        //  OnStage.theActorInTheSpotlight().attemptsTo(Call.anApi(apiVersion, endpoint, getBody()));
    }

    @When("a GET API call is made to the {string} {string} endpoint")
    public void a_GET_API_call_is_made_to_the_endpoint(String apiVersion, String endpoint) {
        api.call(apiVersion, endpoint);
        //  OnStage.theActorInTheSpotlight().attemptsTo(Call.anApi(apiVersion, endpoint));

    }

    @Then("I should not be able to access the mandates")
    public void i_should_not_be_able_to_access_the_mandates() {
       SerenityRest.lastResponse().getBody().prettyPeek();
        setMandateResponse(registeredUser.getResponseBody());
        assertTrue(mandateResponse.isEmpty());
    }


    @Given("an account that has the mandate feature enabled")
    public void an_account_that_has_the_mandate_feature_enabled() {
        System.out.println("********************Do account check");
    }

    @When("I access the tenant")
    public void i_access_the_tenant() {
        //OnStage.setTheStage(new OnlineCast());
        testData.setData(TENANT_PORTAL_URL,environmentVariables.getProperty("tenantportalurl"));
        testData.setData(TENANT_PORTAL_EMAIL_ADDRESS, environmentVariables.getProperty("tenantportalemailaddress"));
        testData.setData(TENANT_PORTAL_PASSWORD, environmentVariables.getProperty("tenantportalpassword"));
        OnStage.theActorCalled("Martin");
     OnStage.theActorInTheSpotlight().attemptsTo(Navigate.toTheTenantPortalLoginPage());
     OnStage.theActorInTheSpotlight().attemptsTo(Login.withMandateNotEnabledTenantCredentials());
     OnStage.theActorInTheSpotlight().attemptsTo(Click.on(TenantListPage.CONTINUE_FOR_AUTOMATION_TENANT));
    }


    @Then("I should be able to see the mandate navigation links")
    public void i_should_be_able_to_see_the_mandate_navigation_links() {
        System.out.println("Now we check******************");
    }

    public RequestBody getBody() {
        return body;
    }

    public void setBody(RequestBody body) {
        this.body = body;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getMandateResponse() {
        return mandateResponse;
    }

    public void setMandateResponse(String mandateResponse) {
        this.mandateResponse = mandateResponse;
    }


}
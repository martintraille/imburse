package imburse.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;
import org.junit.runner.RunWith;

import java.io.UnsupportedEncodingException;

import static imburse.steps.AuthenticationSteps.generatesHmac;

@RunWith(SerenityRunner.class)
public class BearerTokenStepDefinitions {

    String accountId;
    String tenantId;
    String hmac;
    String bearerTokenResponse;
    EnvironmentVariables environmentVariables;


    @Steps(shared = true)
    AuthenticationSteps picard;


    @Before
    public void setTheStage() {
        RestAssured.baseURI = "https://sandbox-api.imbursepayments.com";
    }


    @Given("(Picard) has a valid accountId and tenantID")
    public void registered_user_has_a_valid_accountId_and_tenantID() {

        accountId = picard.getAccountId();
        tenantId = picard.getTenantId();

    }

    @When("he attempts to authenticate via the {string} endpoint")
    public void he_attempts_to_authenticate_via_the_endpoint(String endpoint) throws UnsupportedEncodingException {
        hmac = generatesHmac();
        SerenityRest.given().log().all().queryParam("AccountId", accountId).queryParam("TenantId", tenantId)
                .header("Authorization", "Hmac " + hmac).header("ContentType", "application/json")
                .body("")
                .when()
                .post(endpoint).then().statusCode(201);
    }


  /*  @When("he attempts to authenticate")
    public void he_attempts_to_authenticate() throws UnsupportedEncodingException {
        hmac = generatesHmac();
        SerenityRest.given().log().all().queryParam("AccountId", accountId).queryParam("TenantId", tenantId)
                .header("Authorization", "Hmac " + hmac).header("ContentType", "application/json")
                .body("")
                .when()
                .post("/v1/identity/hmac").then().statusCode(201);
    }*/

    @Then("he receives a bearer token")
    public void he_receives_a_bearer_token() {

        bearerTokenResponse = picard.getResponseBody();
        Assert.assertTrue(bearerTokenResponse.contains("accessToken"));
        System.out.println("*****Bearer Token is:****" + bearerTokenResponse);

    }


}
